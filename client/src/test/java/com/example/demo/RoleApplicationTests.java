/**
 * Provide necessary to test its controller and service 
 * Comparing with the actual result through a mock standpoint.
 */
package com.example.demo;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.Model.Role;
import com.example.demo.Model.User;
import com.example.demo.Repository.RoleRepository;
import com.example.demo.Service.Impl.RoleServiceImpl;

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
public class RoleApplicationTests {

	@Mock
	private RoleRepository roleRepository;
	
	@InjectMocks
	private RoleServiceImpl roleService;
	
	/**
	 * To test the return values by insertRole method from role service 
	 * To check equality of two objects
	 */
	@Test 
	public void insertRoleTest() { 
		Role role = new Role(7,"sse","ACTIVE");
		when(roleRepository.save(role)).thenReturn(role);
		assertEquals(role,roleService.insertRole(role)); 
	}
	
	/**
	 * To test the return values by getAllRole method from role service 
	 * To check equality of two objects
	 */
	@Test 
	public void getAllRoleTest() { 
		when(roleRepository.findAll()).thenReturn(Stream
				.of(new Role(1,"sse","ACTIVE"),new Role(2,"se","ACTIVE")).collect(Collectors.toList()));
		assertEquals(2, ((List<Role>) roleService.getAllRole()).size());
	}
	
	/**
	 * To test the return values by getRole method from role service 
	 * To check equality of two objects
	 */
	@Test
	public void  getRoleById() {
		Role role = new Role(6,"se","active");
		when(roleRepository.findById(role.getRoleId())).thenReturn(Optional.of(role));
		assertEquals(role, roleService.getRole(role.getRoleId()));
	}
	

	/**
	 * To test the return values by deleteById method from role service 
	 * To check equality of two objects
	 */
	@Test
	public void deleteUserTest() {
		Role role = new Role(6,"se","active");
		when(roleRepository.findById(role.getRoleId())).thenReturn(Optional.of(role));
		roleService.deleteRole(role.getRoleId());
		verify(roleRepository).deleteById(role.getRoleId());
	}

}
