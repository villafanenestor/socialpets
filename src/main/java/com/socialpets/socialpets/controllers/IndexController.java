package com.socialpets.socialpets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
}
