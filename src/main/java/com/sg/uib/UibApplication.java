package com.sg.uib;

import com.sg.uib.model.Role;
import com.sg.uib.model.User;
import com.sg.uib.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class UibApplication {

	public static void main(String[] args) {
		SpringApplication.run(UibApplication.class, args);
	}
	@Bean
	CommandLineRunner start(AccountService accountService) {
		return args -> {
			accountService.saveRole(new Role("USER"));
			accountService.saveRole(new Role("ADMIN"));
			Stream.of(
					new User("user@gmail.com", "123456789"),
					new User("user1@gmail.com", "123456789"),
					new User("user2@gmail.com", "123456789")
			).forEach(user -> {
				accountService.saveUser(user);
			});
		};
	}
	@Bean
	BCryptPasswordEncoder getBCPE ()
	{
		return new  BCryptPasswordEncoder() ;
	}
}
