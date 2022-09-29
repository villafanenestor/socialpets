package com.socialpets.socialpets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.socialpets.socialpets.models.User;

@Controller
public class IndexController {
    
    @GetMapping({"/", "/index"})
    public String index(){
        return "Index";
    }

    @GetMapping("/contacto")
    public String test(){
        return "contacto";
    }

    @GetMapping("/nosotros")
    public String ejemplo(){
        return "nosotros";
    }

    
    @GetMapping("/fpass")
    public String fpass(){
        return "fpass";
    }
    

            

    // @GetMapping("/loginPage={templateName}")
    // public String loginPage(@PathVariable String templateName, Model model){
    //     if(templateName.equals("f") || templateName.equals("p")){
    //         boolean isFundacion= templateName.equals("f");
    //         model.addAttribute("isFundacion", isFundacion);
    //         return "loginPage";
    //     }

    //     return "index";
    // }
}
