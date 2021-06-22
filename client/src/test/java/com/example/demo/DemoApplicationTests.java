package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.Impl.UserServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest(
		properties = {"spring.cloud.config.enabled=false"}
		)
class DemoApplicationTests {

	@MockBean
	private RoleRepository rolerepository;

	@MockBean
	private UserRepository repository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;
	
	@Test 
	public void insertUserTest() { 
		User user = new User("user_10","se",1,"pwd10"," user10");
		when(repository.save(user)).thenReturn(user);
		assertEquals(
				user,userRepository.save(user)); 
	}

	@Test 
	public void getAllUserTest() { 
		when(repository.findAll()).thenReturn(Stream
				.of(new User("user_9","se",1,"pwd9"," user9"),new User("user_10","se",1,"pwd10"," user10")).collect(Collectors.toList()));
		assertEquals(2, userRepository.findAll().size());
	}

	@Test
	public void getUserTest() { 	
		User user = new User("user_9","se",1,"pwd9"," user9");
		userRepository.delete(user);
		verify(repository, times(1)).delete(user);
	}
	
	@Test 
	public void insertRoleTest() { 
	Role role = new Role("sse","ACTIVE");
		when(rolerepository.save(role)).thenReturn(role);
		assertEquals(role,roleRepository.save(role)); 
	}

	@Test 
	public void getAllRoleTest() { 
		when(rolerepository.findAll()).thenReturn(Stream
				.of(new Role("sse","ACTIVE"),new Role("sse","ACTIVE")).collect(Collectors.toList()));
		assertEquals(2, ((List<Role>) roleRepository.findAll()).size());
	}

	@Test
	public void getRoleTest() { 	
		Role role = new Role("sse","ACTIVE");
		roleRepository.delete(role);
		verify(rolerepository, times(1)).delete(role);
	}
}
