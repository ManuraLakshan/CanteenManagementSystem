package com.canteen.Fot.controller;

import com.canteen.Fot.Inventry;
import com.canteen.Fot.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private InventoryService InvenService;

    @RequestMapping(path = "")
    public String getAllStudents(Model model, String keyword)
    {
        List<Inventry> inventory = (List<Inventry>) InvenService.getAllitems();
        if(keyword != null) {
            model.addAttribute("listItems",InvenService.findByKeyword(keyword) );

        }else {
            model.addAttribute("listItems", inventory);
        }
        return "index";
    }
}
