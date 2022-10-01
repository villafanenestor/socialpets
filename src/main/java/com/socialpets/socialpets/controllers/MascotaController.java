package com.socialpets.socialpets.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.socialpets.socialpets.models.Mascota;
import com.socialpets.socialpets.repositories.MascotaRepository;
import com.socialpets.socialpets.services.MascotaService;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/mascotas")
public class MascotaController {

    @Autowired
    MascotaRepository mascotaRepority;

    @Autowired
    MascotaService mascotaService;
    


    @GetMapping()
    public String hola(Model model){
        List<Mascota> mascotas = mascotaRepority.findMascotasByAdopcion(false);
        model.addAttribute("mascotas", mascotas);
        return "mascotas";
    }


    @PostMapping()
    public ModelAndView crear(@ModelAttribute("mascota") Mascota mascota, ModelMap model){
        try {
            mascotaService.crear(mascota);
            model.addAttribute("exito", "Mascota creada exitosamente.");
            return new ModelAndView("mascotaCreate");
        } catch (Exception e) {
            // TODO: handle exception
            model.addAttribute("error", e.getMessage());
            return new ModelAndView("mascotaCreate");
        }     
    }

}
