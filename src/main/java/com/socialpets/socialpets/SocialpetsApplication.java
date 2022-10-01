package com.socialpets.socialpets;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import com.socialpets.socialpets.models.User;
// import com.socialpets.socialpets.models.Role;
// import com.socialpets.socialpets.repositories.MascotaRepository;
// import com.socialpets.socialpets.repositories.UserRepository;
// import com.socialpets.socialpets.services.MascotaService;

@SpringBootApplication
public class SocialpetsApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SocialpetsApplication.class, args);
		// MascotaRepository repository = context.getBean(MascotaRepository.class);
		// System.out.println("Listado de mascotas: "+repository.findMascotasByAdopcion(false));
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
