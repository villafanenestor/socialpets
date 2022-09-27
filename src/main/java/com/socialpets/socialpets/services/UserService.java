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

        boolean validationStatus=true;

        if(isNewUser){
            if(user.id==null){
                Optional<User> userTemp = userRepository.findByEmail(user.email);
                if(userTemp.isPresent()){
                    throw new MyCustomException("El correo ya se encuentra registrado en el sistema");
                }

            }else{
                throw new MyCustomException("""
                    La validacion del objeto ha fallado, intento validar la creacion con la actualizacion
                    O envio el Id por accidente.
                    """);
            }
        }else{

        }
        
    }



    public boolean login(String email, String password) throws MyCustomException{
        System.out.println("Login service");
        // System.out.println("Usuario esta presente");
        
        validarLogin(email, password);
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            System.out.println("Usuario Existe");
            if(user.get().password.equals(password)){
                System.out.println("La contraseña es la misma");

            }else{
                System.out.println("contraseña enviada: "+password + " Contraseña usuario: "+user.get().password);
                throw new MyCustomException("La contraseña es invalida");
            }
        }

        return false;

    }



    public void validarLogin(String email, String password) throws MyCustomException{
        if(email.isEmpty() || email.isBlank()){
            throw new MyCustomException("Error: El email Esta en blanco");
        }else if(password.isEmpty() || password.isBlank()){
            throw new MyCustomException("Error: La contraseña Esta en blanco");
        }
    }
    
}
