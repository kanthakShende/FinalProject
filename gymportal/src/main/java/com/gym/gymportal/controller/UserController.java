package com.gym.gymportal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gym.gymportal.entity.Suppliment;
import com.gym.gymportal.entity.User;
import com.gym.gymportal.entity.Workout;
import com.gym.gymportal.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/add-user")
	public String add(@RequestBody User user) {
		userservice.add(user);
		return "user added successfully";
	}
	
	@PostMapping("/user-login")
	public User userLogin(@RequestBody User user) {
		return userservice.authenticateUser(user);
	}
	
	@GetMapping("/update-user")
	public String updateMembership(@RequestBody User user) {
		 userservice.update(user);
		 return "Updated !";
	}
	
	@GetMapping("/get-user/{id}")
	public Optional<User> getUser(@PathVariable String id) {
		return userservice.getUserById(Integer.parseInt(id));
	}
	
	@GetMapping("/get-allUsers")
	public List<User> getAllUsers() {
	    return userservice.getAllUsers();
	}
	
}
