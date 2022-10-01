package com.socialpets.socialpets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.socialpets.socialpets.models.Mascota;

@Controller
@RequestMapping("/admin")
public class AdminController {


    @GetMapping("/mascotaCrear")
    public ModelAndView mascotaForm(Model model){
        model.addAttribute("mascota", new Mascota());
        return new ModelAndView("mascotaCreate");
    }
    
}
