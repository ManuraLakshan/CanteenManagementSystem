package com.canteen.Fot.controller;

import com.canteen.Fot.entity.Supplier;
import com.canteen.Fot.entity.User;
import com.canteen.Fot.repository.UserRepository;
import com.canteen.Fot.service.SupplierServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    //to create new user automatically
    @Autowired
    private UserRepository urepo;

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup_form";
    }

    //for registration
    @PostMapping("/process_register")
    public String processRegistration(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setType("customer");
        urepo.save(user);
        return "register_success";
    }

    //to show all users
    @GetMapping("/list_users")
    public String viewUserList(Model model) {
        List<User> listUsers = urepo.findAll();
        model.addAttribute("listUsers", listUsers);
        return "index";
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }



}
