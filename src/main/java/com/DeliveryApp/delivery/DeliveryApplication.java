package com.DeliveryApp.delivery;

import com.DeliveryApp.delivery.security.services.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
public class DeliveryApplication {

	public static void main(String[] args) {

		SpringApplication.run(DeliveryApplication.class, args);
	}
	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	//@Bean
	CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager){
		PasswordEncoder passwordEncoder = passwordEncoder();
		return args -> {
			jdbcUserDetailsManager.createUser(User.withUsername("admin").password(passwordEncoder.encode("123")).build());
			jdbcUserDetailsManager.createUser(User.withUsername("cashier").password(passwordEncoder.encode("123")).build());
			jdbcUserDetailsManager.createUser(User.withUsername("livreur").password(passwordEncoder.encode("123")).build());

		};
	}
	//@Bean
	CommandLineRunner commandLineRunner(AccountService accountService){
		return args -> {
			 accountService.createRole("ADMIN");
			 accountService.createRole("CASHIER");
			 accountService.createRole("LIVREUR");

			//accountService.createUser("admin","123","admin@gmail.com","123");
			//accountService.createUser("cashier","123","cashier@gmail.com","123");
			//accountService.createUser("livreur","123","livreur@gmail.com","123");

			//   accountService.addRoletoUser("admin", "ADMIN");
			//   accountService.addRoletoUser("admin", "USER");
			//   accountService.addRoletoUser("cashier", "CASHIER");
			//    accountService.addRoletoUser("livreur", "LIVREUR");

			System.out.println( accountService.loadUserByUsername("cashier").getEmail());

		};
	}
}
