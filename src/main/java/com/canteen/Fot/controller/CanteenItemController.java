package com.canteen.Fot.controller;

import com.canteen.Fot.entity.CanteenItem;
import com.canteen.Fot.service.CanteenItemServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class CanteenItemController {

    @Autowired
    private CanteenItemServices cnItemService;

    @RequestMapping(path = "viewall_items")
    public String getAllSuppliersList(Model model) {
        List<CanteenItem> canteenItemList = cnItemService.getAllItems();
        model.addAttribute("canteenItemList", canteenItemList);

        CanteenItem ci = new CanteenItem();
        model.addAttribute("item", ci);
        return "/additems";
    }

    /*@RequestMapping(path = "addnewitem")
    public String addItem(Model model) {
        CanteenItem ci = new CanteenItem();
        model.addAttribute("item", ci);
        return "/additems";
    }

    @RequestMapping(value = "/process_add_item", method = RequestMethod.POST)
    public String saveItem(@ModelAttribute("CanteenItem") CanteenItem ci) {
        cnItemService.addItem(ci);
        return "/additems";
    }*/

}
