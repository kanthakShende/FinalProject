package com.gym.gymportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.gymportal.entity.User;
import com.gym.gymportal.entity.Workout;
import com.gym.gymportal.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void add(User user) {
		user.setRole("user");
		userRepository.save(user);
	}
	
	public User authenticateUser(User user) {
		return userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
	}
	
	public void update(User updatedUser) {
		Optional<User> existingUser = userRepository.findById(updatedUser.getUserId());
		if(existingUser.isPresent()) {
			User user = existingUser.get();
			user.setMembership(updatedUser.getMembership());
			user.setEmail(updatedUser.getEmail());
			user.setFullName(updatedUser.getFullName());
			user.setTrainer(updatedUser.getTrainer());
			user.setPassword(updatedUser.getPassword());
			userRepository.save(user);
		} else {
			throw new IllegalArgumentException("User not found with ID: "+ updatedUser.getUserId());
		}
	}


	public Optional<User> getUserById(int id) {
		return userRepository.findById(id);
	}
	
	 public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }
}
