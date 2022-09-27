package com.socialpets.socialpets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.socialpets.socialpets.models.User;
import com.socialpets.socialpets.services.UserService;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("user") User user, Model model){
        // System.out.println("Email: "+user.email+" Password: "+user.password);

        try{
            boolean userExist = userService.login(user.email, user.password);
            return new ModelAndView("redirect:/home");
        } catch (Exception e) {
            // TODO: handle exception
            // System.out.println(e);
            return new ModelAndView("redirect:/login");
        }
    }
}
