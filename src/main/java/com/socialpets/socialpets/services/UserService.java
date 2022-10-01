package com.socialpets.socialpets.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialpets.socialpets.exceptions.MyCustomException;
import com.socialpets.socialpets.models.Role;
import com.socialpets.socialpets.models.User;
import com.socialpets.socialpets.repositories.UserRepository;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Transactional()
    public void crearUsuario(User user) throws MyCustomException{
        validarUsuario(true, user);
    }



    private void validarUsuario(boolean isNewUser,User user) throws MyCustomException{
        if(isNewUser){
            if(user.getId()==null){
                Optional<User> userTemp = userRepository.findByEmail(user.getEmail());
                if(userTemp.isPresent()){
                    throw new MyCustomException("El correo ya se encuentra registrado en el sistema");
                }
            }else{
                throw new MyCustomException("""
                    La validacion del objeto ha fallado, intento validar la creacion con la actualizacion
                    O envio el Id por accidente.
                    """);
            }
        }
    }


    public Optional<User> login(String email, String password) throws MyCustomException{
        validarLogin(email, password);
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            if(user.get().getPassword().equals(password)){
            }else{
                throw new MyCustomException("La contraseña es invalida");
            }
        }
        return user;
    }



    public void validarLogin(String email, String password) throws MyCustomException{
        if(email.isEmpty() || email.isBlank()){
            throw new MyCustomException("Error: El email Esta en blanco");
        }else if(password.isEmpty() || password.isBlank()){
            throw new MyCustomException("Error: La contraseña Esta en blanco");
        }
    }



    public boolean register(String rol, String nombre, String password, String email) throws MyCustomException{
        validarLogin(email, password);
        Optional<User> user = userRepository.findByEmail(email);
        if(!user.isPresent()){
            if(!(password.length()>=8)){ 
                throw new MyCustomException("La contraseña con cumple con los caracteres requeridos.");
            }

            else if(nombre.isEmpty() || nombre.isBlank()){      
                throw new MyCustomException("El nombre no puede estar en blanco.");
            }else{
                User userGuardar;
                if(rol.equals("SALVADOR")){
                    userGuardar = new User(null, nombre, email, password, Role.SALVADOR);
                    userRepository.save(userGuardar);
               }else if(rol.equals("FUNDACION")){
                    userGuardar = new User(null, nombre, email, password, Role.FUNDACION);
                    userRepository.save(userGuardar);
               }
            }

        }else{
            throw new MyCustomException("El usuario ya se encuentra registrado");
            
        }     
        return true;
    }
    
}
