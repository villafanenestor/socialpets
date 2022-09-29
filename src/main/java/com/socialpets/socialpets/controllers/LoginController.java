package com.socialpets.socialpets.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.socialpets.socialpets.models.User;
import com.socialpets.socialpets.services.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    
    @PostMapping()
    public ModelAndView loguearse(@ModelAttribute("user") User user, ModelMap model, RedirectAttributes redirectAttributes, HttpSession httpSession){

        try{
            Optional<User> usuario = userService.login(user.email, user.password);
            if(usuario.isPresent()){
                System.out.println("IR A HOME");
                redirectAttributes.addFlashAttribute("nombreUsuario", usuario.get().nombre.toUpperCase());
                if(httpSession.getAttribute("datoUsuario") == null){
                    httpSession.setAttribute("datoUsuario", usuario.get());
                }
                return new ModelAndView("redirect:/lobby");
            }else{
                System.out.println("CONTRASEÑA INCORRECTA");
                model.addAttribute("error", "Email y/o contraseña incorrecta");
                return new ModelAndView("loginPage");
            }
        } catch (Exception e) {
            System.out.println("Error generado");
            System.out.println("nombre de la excepcion"+e.getMessage());
            model.addAttribute("error", e.getMessage());
            return new ModelAndView("loginPage");
        }
    }

    @GetMapping()
    public String loginPage(Model model){
        model.addAttribute("user", new User());
        return "loginPage";
    }


    

}
