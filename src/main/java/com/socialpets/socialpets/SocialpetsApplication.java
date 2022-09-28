package com.socialpets.socialpets;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.socialpets.socialpets.models.User;
import com.socialpets.socialpets.models.Role;
import com.socialpets.socialpets.repositories.UserRepository;

@SpringBootApplication
public class SocialpetsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SocialpetsApplication.class, args);
		// UserRepository repository = context.getBean(UserRepository.class);
		// repository.save( 
		// User.builder()
		// .id(null)
		// .nombre("Nestor")
		// .email("mass.nestor@gmail.com")
		// .password("12345678")
		// .rol(Role.ADMINISTRADOR)
		// .build()
		// );	
	}

}
