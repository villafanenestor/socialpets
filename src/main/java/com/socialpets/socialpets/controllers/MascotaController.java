package com.socialpets.socialpets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.socialpets.socialpets.models.Mascota;
import com.socialpets.socialpets.repositories.MascotaRepository;

import org.springframework.ui.Model;

@Controller
// @RequestMapping("")
public class MascotaController {

    @Autowired
    MascotaRepository mascotaRepority;
    


    @GetMapping("/mascotas")
    public String hola(Model model){
        List<Mascota> mascotas = mascotaRepority.findMascotasByAdopcion(false);
        model.addAttribute("mascotas", mascotas);
        return "mascotas";
    }
}
