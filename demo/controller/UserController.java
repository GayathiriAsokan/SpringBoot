package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.xml.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.User;
import com.example.demo.Service.UserService;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService; 
	
	@GetMapping("/get/all")
	public List<User> getAllUser() {
		return userService.getAll();
	}
	/*
	 * @PostMapping("/add") public User create(@RequestBody User user) { return
	 * userRepository.save(user); }
	 * 
	 * @PutMapping("/edit") public String edit(@RequestBody User user) { return
	 * userRepository.; }
	 */
	/*
	 * @GetMapping("users/{userId}") public ResponseEntity<User>
	 * getUser(@PathVariable(value = "userId") String Id) { User user =
	 * userRepository.findById(Id); return ResponseEntity.ok().body(user); }
	 */
}
