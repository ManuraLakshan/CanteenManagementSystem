package com.canteen.Fot;

import com.canteen.Fot.entity.Supplier;
import com.canteen.Fot.service.SupplierServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

        @RequestMapping("/welcome")
        public String loginMessage(){
            return "index";
        }

        @RequestMapping("/admin")
        public String loadAdmin(){
            return "admindashboard";
        }

        @RequestMapping("/staticPage")
        public  String loadItem(){
            return "/additems";
        }
}
