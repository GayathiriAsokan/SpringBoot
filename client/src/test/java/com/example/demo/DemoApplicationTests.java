/**
 * Provide necessary to test its controller and service 
 * Comparing with the actual result through a mock standpoint.
 */
package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.Impl.RoleServiceImpl;
import com.example.demo.Service.Impl.UserServiceImpl;

/**
 * To test its controller and service 
 * Invokes the class MockitoJUnitRunner to run the tests
 * 
 * @author GAYATHIRI
 */
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(
		properties = {"spring.cloud.config.enabled=false"}
		)
class DemoApplicationTests {

	// To simulate the behavior of a real object ie) repository
	@Mock
	private UserRepository repository;

	//Creates an instance of the class and injects the mock created with the @Mock annotation into this instance
	@InjectMocks
	private UserServiceImpl userService;

	/**
	 * To test the return values by insert method from user service 
	 * To check equality of two objects
	 */
	@Test 
	public void insertUserTest() { 
		User user = new User("user_11","se",1,"pwd11"," user11");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user,userService.insertUser(user)); 
	}
	
	/**
	 * To test the return values by getAll method from user service 
	 * To check equality of two objects
	 */
	@Test 
	public void getAllUserTest() { 
		when(repository.findAll()).thenReturn(Stream
				.of(new User("user_9","se",1,"pwd9"," user9"),new User("user_10","se",1,"pwd10"," user10")).collect(Collectors.toList()));
		assertEquals(2, userService.getAll().size());
	}
	

	/**
	 * To test the return values by deleteById method from user service 
	 * To check equality of two objects
	 */
	@Test
	public void deleteUserTest() {
		User user = new User("user_9","se",1,"pwd9"," user9");
		when(repository.findById(user.getUserId())).thenReturn(Optional.of(user));
		userService.deleteUser(user.getUserId());
		verify(repository).deleteById(user.getUserId());
	}


	/**
	 * To test the return values by getById method from user service 
	 * To check equality of two objects
	 */
	@Test
	public void  getUserById() {
		User user = new User("user_9","se",1,"pwd9"," user9");
		when(repository.findById(user.getUserId())).thenReturn(Optional.of(user));
		assertEquals(user, userService.getById(user.getUserId()));
	}
}
