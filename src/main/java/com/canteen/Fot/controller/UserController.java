package com.canteen.Fot.controller;

import com.canteen.Fot.entity.User;
import com.canteen.Fot.repository.UserRepository;
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
        return "users";
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
    public String currentUserName(Principal principal) {
        return principal.getName();
    }


    /*public static Long getCurrentUserId() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        String id = null;
        if (authentication != null)
            if (authentication.getPrincipal() instanceof UserDetails)
                id = ((UserDetails) authentication.getPrincipal()).getUsername();
            else if (authentication.getPrincipal() instanceof String)
                id = (String) authentication.getPrincipal();
        try {
            return Long.valueOf(id != null ? id : "1"); //anonymoususer
        } catch (NumberFormatException e) {
            return 1L;
        }
    }

    @GetMapping("/ids")
    String uid(){
        String id = getCurrentUserId().toString();
        return id;
    }*/

}
