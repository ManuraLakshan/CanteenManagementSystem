package com.canteen.Fot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


        @RequestMapping("/welcome")
        public String loginMessage(){
            return "index";
        }

}
