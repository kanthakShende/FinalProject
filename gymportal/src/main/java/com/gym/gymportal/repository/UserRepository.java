package com.gym.gymportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gym.gymportal.entity.Trainer;
import com.gym.gymportal.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByEmailAndPassword(String email, String password);
	
	public List<User> findByTrainer(Trainer trainer);
	
}
