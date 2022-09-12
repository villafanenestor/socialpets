package com.socialpets.socialpets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    
    @GetMapping("/")
    public String index(){
        return "Index";
    }

    @GetMapping("/test")
    public String test(){
        return "Testeando";
    }
}
