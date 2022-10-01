package com.socialpets.socialpets.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;


import com.socialpets.socialpets.exceptions.MyCustomException;
import com.socialpets.socialpets.models.User;
import com.socialpets.socialpets.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping()
    public ResponseEntity<?> crearUsuario(@RequestBody User user) throws MyCustomException{
        try {
            userService.crearUsuario(user);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping()
    public String findByEmail(@RequestParam() String email){
        return "Email: "+email;

    }


}