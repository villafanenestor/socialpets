package com.socialpets.socialpets.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialpets.socialpets.exceptions.MyCustomException;
import com.socialpets.socialpets.models.Mascota;
import com.socialpets.socialpets.repositories.MascotaRepository;

@Service
public class MascotaService {
    

    @Autowired
    MascotaRepository mascotaRepository;


    @Transactional()
    public boolean adoptar(Long id) throws MyCustomException{


        Optional<Mascota> mascota1 = mascotaRepository.findById(id);

        if(mascota1.isPresent()){
            if(!mascota1.get().getAdoptcion()){
                mascotaRepository.setAdopcion(id);
            }else{
                throw new MyCustomException("La mascota ya fue adoptada");
            }

        }

        return true;
    }

    @Transactional()
    public boolean crear(Mascota mascota) throws MyCustomException{
        validarMascota(mascota.getTipo(), mascota.getPeso(), mascota.getNombre(), mascota.getFoto());
        mascotaRepository.save(mascota);
        return true;
    }



    private void validarMascota(String tipo, String peso, String nombre, String foto) throws MyCustomException{
        if(tipo.isEmpty()){
            throw new MyCustomException("El tipo de la mascota es obligatorio.");
        }
        else if(peso.isEmpty()){
            throw new MyCustomException("El peso de la mascota es obligatorio.");
        }
        else if(nombre.isEmpty()){
            throw new MyCustomException("El nombre de la mascota es obligatorio.");
        }
        else if(foto.isEmpty()){
            throw new MyCustomException("La foto de la mascota es obligatorio.");
        }

    }

}