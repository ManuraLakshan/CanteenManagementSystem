package com.canteen.Fot.controller;

import com.canteen.Fot.OrderItem;
import com.canteen.Fot.entity.Ordercart;
import com.canteen.Fot.repository.OrderCartRepo;
import com.canteen.Fot.service.CustomUserDetails;
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




    @RequestMapping(value = "/orderItem", method = RequestMethod.GET)
    public String orderItems(@RequestParam(value = "canteenitem") Integer item_id, @AuthenticationPrincipal CustomUserDetails UserDetails){
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



}
