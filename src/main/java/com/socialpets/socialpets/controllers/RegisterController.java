package com.socialpets.socialpets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.socialpets.socialpets.models.User;
import com.socialpets.socialpets.services.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {
    

    @Autowired
    private UserService userService;

    @GetMapping()
    public String registerPagina(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping()
    public String register(@ModelAttribute("user") User user, ModelMap model){
        try {
            Boolean userCreated = userService.register(user.getRol().toString(), user.getNombre(), user.getPassword(), user.getEmail());
            if(userCreated){
                model.addAttribute("exito", "Usuario creado exitosamente.");
            }else{
                model.addAttribute("error", "El usuario ya existe");
            }
            return "register";
        }catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}
