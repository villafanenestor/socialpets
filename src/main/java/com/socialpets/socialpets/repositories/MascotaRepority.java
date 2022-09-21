package com.socialpets.socialpets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socialpets.socialpets.models.MascotaModel;

@Repository
public interface MascotaRepority extends JpaRepository<MascotaModel, Long>{
    
}
