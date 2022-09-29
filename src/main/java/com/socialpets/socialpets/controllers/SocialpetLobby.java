package com.socialpets.socialpets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lobby")
public class SocialpetLobby {

    
    @GetMapping()
    public String home(){
        return "home";
    }
    
}
