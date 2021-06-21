package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.Impl.UserServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(
		  properties = {"spring.cloud.config.enabled=false"}
		)
class DemoApplicationTests {


	@Autowired
	private UserServiceImpl userservice;

	@MockBean
	private UserRepository repository;
	
	@Test
	public void insertUserTest() {
		User user = new User("user_10","sse",2,"pwd10","gg");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user, userservice.insertUser(user));
	}

}
