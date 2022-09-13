package com.socialpets.socialpets.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping("")
public class MascotaController {
    


    @GetMapping("/mascotas")
    public String hola(){
        return "Hola Mascota";
    }
}
