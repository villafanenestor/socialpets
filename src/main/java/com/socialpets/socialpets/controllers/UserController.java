package com.socialpets.socialpets.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import com.socialpets.socialpets.exceptions.MyCustomException;
import com.socialpets.socialpets.models.User;
import com.socialpets.socialpets.repositories.UserRepository;
import com.socialpets.socialpets.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    // @GetMapping("/h")
    // public String saludo() {
    //     return "Saludo";
    // }


    @PostMapping()
    public ResponseEntity<?> crearUsuario(@RequestBody User user) throws MyCustomException{
        try {
            userService.crearUsuario(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // @PostMapping()
    // public ResponseEntity<?> crearUsuario(@RequestBody User user) {
    //     System.out.println("Informacion usuario"+user);
    //     if (user.id == null) {
    //         return ResponseEntity.ok(appUserRepository.save(user));
    //     } else {
    //         return ResponseEntity.badRequest().build();
    //     }
    //     // return ResponseEntity.ok("Creado");

    // }

    // @GetMapping()
    // public ResponseEntity<List<User>> getAll() {
    //     return ResponseEntity.ok(appUserRepository.findAll());
    // }

    @GetMapping()
    public String findByEmail(@RequestParam() String email){
        return "Email: "+email;

    }

    
    
    @PostMapping("/login")
    public void login(@ModelAttribute("user") User user, Model model){
        System.out.println("Email: "+user.email+" Password: "+user.password);

        //     boolean userExist = userService.login(email, password);
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     System.out.println(e);
        // }
    }


}
