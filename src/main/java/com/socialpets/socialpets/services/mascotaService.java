package com.socialpets.socialpets.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialpets.socialpets.exceptions.MyCustomException;
import com.socialpets.socialpets.models.Mascota;
import com.socialpets.socialpets.repositories.MascotaRepository;

@Service
public class mascotaService {
    

    @Autowired
    MascotaRepository mascotaRepository;


    // @Transactional()
    public boolean adoptar(Long id) throws MyCustomException{


        Optional<Mascota> mascota1 = mascotaRepository.findById(id);

        if(mascota1.isPresent()){
            if(!mascota1.get().getAdoptcion()){
                mascotaRepository.setAdopcion(id);
                System.out.println("Adoptar Mascota");
            }else{
                new MyCustomException("La mascota ya fue adoptada");
            }

        }

        return true;
    }
}
