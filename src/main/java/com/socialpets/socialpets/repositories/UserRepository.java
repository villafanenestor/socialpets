package com.socialpets.socialpets.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.socialpets.socialpets.models.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long>  {

    // @Query("SELECT 1 FROM User U WHERE U.email=?1")
    // public User findByEmail(@Param("email") String email);
    
    @Query("SELECT U FROM User U WHERE U.email=?1")
    public Optional<User> findByEmail(String email);


}
