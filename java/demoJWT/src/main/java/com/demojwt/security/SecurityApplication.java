package com.demojwt.security;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.demojwt.security.controller.RegisterRequest;
import com.demojwt.security.services.AuthenticationService;
import com.demojwt.security.user.Role;



@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("Admin")
					.lastname("Admin")
					.email("admin@mail.com")
					.password("123mudar")
					.role(Role.ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			// var manager = RegisterRequest.builder()
			// 		.firstname("User")
			// 		.lastname("User")
			// 		.email("user@mail.com")
			// 		.password("123mudar")
			// 		.role(Role.USER)
			// 		.build();
			// System.out.println("User token: " + service.register(manager).getAccessToken());

		};
	}

}
