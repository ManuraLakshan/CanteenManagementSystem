package com.canteen.Fot.controller;

import com.canteen.Fot.Category;
import com.canteen.Fot.Inventry;
import com.canteen.Fot.OrderItem;
import com.canteen.Fot.entity.User;
import com.canteen.Fot.repository.UserRepository;
import com.canteen.Fot.service.CustomUserDetails;
import com.canteen.Fot.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
public class ItemController {
    @Autowired
    private InventoryService InvenService;

    @GetMapping("/home")
    public String goHome(){
        return "redirect:/";
    }

    @GetMapping("/")
    public String getAllInventory(Model model, String keyword,@AuthenticationPrincipal CustomUserDetails UserDetails)
    {
        List<Inventry> inventory = (List<Inventry>) InvenService.getAllitems();
        if(keyword != null) {
            model.addAttribute("listItems",InvenService.findByKeyword(keyword) );
            String type =  UserDetails.getType();
            model.addAttribute("type",type);

        }else {
            model.addAttribute("listItems", inventory);
        }
        return "index";
    }
    @GetMapping("/mainCategoryFoods")
    public String showBreakfastPage( Model model, Integer id){
//        List<Category> categories = (List<Category>) CatService.getAllCategories();
//        model.addAttribute("MaincateItems", CatService.findByMainFoodId(cate_key));
        //Inventry inventry = (Inventry) InvenService.findByMainFoodId(cate_key);
        List<Inventry> inventory = (List<Inventry>) InvenService.getAllitems();
        model.addAttribute("mainCateItems",InvenService.findByMainFoodId(id) );
        return "mainFoodPage";

    }





}

// delete session stuff before pushing