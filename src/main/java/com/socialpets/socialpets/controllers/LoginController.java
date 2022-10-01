package com.socialpets.socialpets.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.socialpets.socialpets.models.User;
import com.socialpets.socialpets.services.UserService;
import com.socialpets.socialpets.services.MascotaService;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private MascotaService mascotaService;
    
    @PostMapping()
    public ModelAndView loguearse(@ModelAttribute("user") User user, ModelMap model, RedirectAttributes redirectAttributes, HttpSession httpSession){
        try{
            Optional<User> usuario = userService.login(user.getEmail(), user.getPassword());
            if(usuario.isPresent()){
                redirectAttributes.addFlashAttribute("nombreUsuario", usuario.get().getNombre().toUpperCase());
                if(httpSession.getAttribute("datoUsuario") == null){
                    httpSession.setAttribute("datoUsuario", usuario.get());
                }
                return new ModelAndView("redirect:/lobby");
            }else{
                model.addAttribute("error", "Email y/o contraseña incorrecta");
                return new ModelAndView("loginPage");
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return new ModelAndView("loginPage");
        }
    }

    @GetMapping()
    public String loginPage(Model model){
        model.addAttribute("user", new User());
        return "loginPage";
    }


    @GetMapping("/{id}")
    public String loginAdoptar(@PathVariable Long id, User user, ModelMap model, RedirectAttributes redirectAttributes){
        try {
            mascotaService.adoptar(id);
        } catch (Exception e) {
        }
        return "redirect:/mascotas";
    }


    

}
