package com.socialpets.socialpets.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.socialpets.socialpets.models.Mascota;


@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long>{
    
    @Query("SELECT M FROM Mascota M WHERE adoptada=?1")
    List<Mascota> findMascotasByAdopcion(boolean estanAdoptadas);
    
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional()
    @Query("UPDATE Mascota M set M.adoptada=true where id=?1 " )
    void setAdopcion(Long id);
    
}
