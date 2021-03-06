package com.canteen.Fot.controller;

import com.canteen.Fot.OrderItem;
import com.canteen.Fot.entity.Ordercart;
import com.canteen.Fot.repository.OrderCartRepo;
import com.canteen.Fot.service.CustomUserDetails;
import com.canteen.Fot.service.EmailServer;
import com.canteen.Fot.service.InventoryService;
import com.canteen.Fot.service.Order_ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Order_ItemController {
    @Autowired
    private Order_ItemService orderService;
    @Autowired
    private OrderCartRepo cartRepo;
    @Autowired
    private EmailServer emailServer;
    
    private String catchItemName;


    @RequestMapping(value = "/orderItem", method = RequestMethod.GET)
    public String orderItems(@RequestParam(value = "canteenitem") Integer item_id, @AuthenticationPrincipal CustomUserDetails UserDetails,Model model){
        OrderItem orderItem = new OrderItem();
       if(UserDetails != null) {
           orderItem.setItem_id(item_id);
           orderItem.setCust_id(UserDetails.getUsername());
           orderItem.setOrder_qunt(1);
           orderItem.setPurchased_states(0);
           orderService.saveItem(orderItem);
           return "redirect:/";
       }else {

          return "redirect:../login";
       }

    }
    @GetMapping("/ordered")
    public String orderedItems(Model model, @AuthenticationPrincipal CustomUserDetails UserDetails ){

        if(UserDetails != null) {

            model.addAttribute("orderedList", cartRepo.findAll(UserDetails.getUsername()));
            model.addAttribute("getTotal",cartRepo.cartTotalPrice(UserDetails.getUsername()));
           // model.addAttribute("getBroughts",cartRepo.getBroughts(UserDetails.getUsername()));

            return "oderList" ;
        }else{
            return "redirect:/login";
        }


    }

    @PostMapping("/addQuantity")
    public String updateQuantity(@RequestParam(value = "quantity" ) Integer quantity, @RequestParam(value = "orderId" ) Integer orderId ){
        orderService.updateQuantity(quantity, orderId);
        return "redirect:/ordered";

    }

//    @RequestMapping(value="/sendEmail")
//    public String sendEmail(@AuthenticationPrincipal CustomUserDetails UserDetails, @RequestParam(value = "items") String items, @RequestParam(value = "Prices") Integer Prices){
//
//        emailServer.sendSimpleEmail(UserDetails.getUsername(),items+""+Prices,"Invoice ");
//        return "redirect:/home";
//
//    }
    @RequestMapping(value = "addToInvoice")
    public String addToInvoice(@AuthenticationPrincipal CustomUserDetails UserDetails, @RequestParam(value = "items") Integer orderId, @RequestParam("quentity") Integer quentity,@RequestParam("itemId") Integer itemId ){
        orderService.addToInvoice(orderId);
        orderService.quantityChange(quentity,itemId,UserDetails.getUsername());
        return "redirect:/ordered";
    }
    @RequestMapping(value = "addAllToInvoice")
    public String addAllToInvoice(@AuthenticationPrincipal CustomUserDetails UserDetails,
                                  @RequestParam("quantity") Integer quantity,
                                  @RequestParam("itemId") Integer itemId,
                                  @RequestParam("getTota") Integer getTota,
                                  @RequestParam ("itemName") String itemName,
                                  @RequestParam ("itemPrice") String itemPrice){
        //Update purchase ites to 1
        orderService.addAllToInvoice(UserDetails.getUsername());

        //Decrease queantites from quantity table
        orderService.quantityChange(quantity,itemId,UserDetails.getUsername());

        //Send Email to users
        String[] res = itemName.split("[,]", 0);
        for(String myStr: res) {
            this.catchItemName=myStr;

        }
        String Total= "Total price is :"+getTota;
        System.out.println(Total);

        emailServer.sendSimpleEmail(UserDetails.getUsername(),catchItemName+"\n"+Total,"Invoice ");
        return "redirect:/ordered";
    }

//    @GetMapping(value = "totalPrice")
//    public String cartTotalPrice(){
//        return "redirect:/ordered"
//    }




}
