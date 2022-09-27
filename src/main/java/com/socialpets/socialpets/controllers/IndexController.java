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

    @GetMapping("/fotter")
    public String fotter(){
        return "fotter/fotter";
    }

    @GetMapping("/loginpersonas")
    public String login1(){
        return "loginpersonas";
    }

    @GetMapping("/loginfundacion")
    public String login2(){
        return "loginfundacion";
    }

    @GetMapping("/registrof")
    public String registerf(){
        return "registrof";
    }
    
    @GetMapping("/registerpersonas")
    public String register1(){
        return "registerpersonas";
    }
    
    @GetMapping("/fpass")
    public String fpass(){
        return "fpass";
    }
    
    @GetMapping("/register")
    public String register(){
        return "register";
    }



    @GetMapping("/login")
    public String registerf(Model model){
        model.addAttribute("user", new User());
        return "loginPage";
    }

    @GetMapping({"/home", "/inicio"})
    public String home(){
        return "home";
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
