package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.Impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RepositoryTest {
	@MockBean
	private UserRepository repository;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Test 
	public void insertUserTest() { 
		User user = new User("user_11","se",1,"pwd11"," user11");
		when(repository.save(user)).thenReturn(user);
		assertEquals(user,userRepository.save(user)); 
	}
	
	/**
	 * To test the return values by getAll method from user service 
	 * To check equality of two objects
	 */
	@Test 
	public void getAllUserTest() { 
		when(repository.findAll()).thenReturn(Stream
				.of(new User("user_9","se",1,"pwd9"," user9"),new User("user_10","se",1,"pwd10"," user10")).collect(Collectors.toList()));
		assertEquals(2, userRepository.findAll().size());
	}
	
	/**
	 * To test the return values by deleteById method from user service 
	 * To check equality of two objects
	 */
	@Test
	public void deleteUserTest() {
		User user = new User("user_9","se",1,"pwd9"," user9");
		when(repository.findById(user.getUserId())).thenReturn(Optional.of(user));
		userRepository.deleteById(user.getUserId());
		verify(repository).deleteById(user.getUserId());
	}

	/**
	 * To test the return values by getById method from user service 
	 * To check equality of two objects
	
	@Test
	public void  getUserById() {
		User user = new User("user_9","se",1,"pwd9"," user9");
		when(repository.findById(user.getUserId())).thenReturn(Optional.of(user));
		assertEquals(user, userRepository.findById(user.getUserId()));
	} */
}
