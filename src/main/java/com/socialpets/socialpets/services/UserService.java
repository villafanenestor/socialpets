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
        }
    }


    public boolean login(String email, String password) throws MyCustomException{
        validarLogin(email, password);
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            System.out.println("Usuario Existe");
            if(user.get().password.equals(password)){
                System.out.println("La contraseña es la misma");
                return true;
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



    public boolean register(String rol, String nombre, String password, String email) throws MyCustomException{
        validarLogin(email, password);
        Optional<User> user = userRepository.findByEmail(email);
        if(!user.isPresent()){
            System.err.println("EL USUARIO NO EXISTE");
            if(!(password.length()>=8)){ 
                System.out.println("La contraseña con cumple con los caracteres requeridos.");               
                throw new MyCustomException("La contraseña con cumple con los caracteres requeridos.");
            }

            else if(nombre.isEmpty() || nombre.isBlank()){      
                System.out.println("El nombre no puede estar en blanco.");          
                throw new MyCustomException("El nombre no puede estar en blanco.");
            }else{
                User userGuardar;
                if(rol.equals("SALVADOR")){
                    System.out.println("El ROL es SALVADOR");
                    System.out.println("Usuario antes de guardar: "+nombre+ email+ password+ rol);
                    userGuardar = new User(null, nombre, email, password, Role.SALVADOR);
                    User userTEMP = userRepository.save(userGuardar);
                    System.out.println("Info usuario creado:"+userTEMP.nombre);
               }else if(rol.equals("FUNDACION")){
                System.out.println("ENTRO EN FUNDACION");
                    // userGuardar = new User().builder().id(null).nombre(nombre).password(password).rol(Role.FUNDACION).build();
                    userGuardar = new User(null, nombre, email, password, Role.FUNDACION);
                    userRepository.save(userGuardar);
                    System.out.println("SE GUARDO EL NUEVO USUARIO");
               }
            }

        }else{
            System.out.println("El usuario ya existe");
            throw new MyCustomException("El usuario ya se encuentra registrado");
            
        }     
        return true;
    }
    
}
