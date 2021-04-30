package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User("user_2", "sse",2);
		User user2 = new User("user_3", "se",3);
		userRepository.user.addAll(Arrays.asList(user1, user2));
	}

}
