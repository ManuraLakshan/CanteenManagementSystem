package com.canteen.Fot.controller;

import com.canteen.Fot.OrderItem;
import com.canteen.Fot.service.Order_ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Order_ItemController {
    @Autowired
    private Order_ItemService orderService;


    @RequestMapping(value = "/orderItem", method = RequestMethod.GET)
    public String orderItems(@RequestParam(value = "canteenitem") Integer item_id, @RequestParam(value = "user") String user_id){
        OrderItem orderItem = new OrderItem();
        orderItem.setItem_id(item_id);
        orderItem.setCust_id(user_id);
        orderService.saveItem(orderItem);
        return "redirect:/";

    }

}
