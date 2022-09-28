package com.socialpets.socialpets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.socialpets.socialpets.models.User;
import com.socialpets.socialpets.services.UserService;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    
    @PostMapping("/signin")
    public ModelAndView login(@ModelAttribute("user") User user, Model model){

        try{
            boolean userExist = userService.login(user.email, user.password);
            if(userExist){
                return new ModelAndView("redirect:/home");
            }else{
                return new ModelAndView("redirect:/login");
            }
        } catch (Exception e) {
            return new ModelAndView("redirect:/login");
        }
    }


    @PostMapping("/signup")
    public String register(@ModelAttribute("user") User user, ModelMap model){
        try {
            Boolean userCreated = userService.register(user.rol.toString(), user.nombre, user.password, user.email);
            if(userCreated){
                return "home";
            }else{
                model.addAttribute("error", "El usuario ya existe");
                return "register";
            }
        }catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

}
