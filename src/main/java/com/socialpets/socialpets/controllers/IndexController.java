package com.socialpets.socialpets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping({"/", "/index", "/home", "inicio"})
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
}
