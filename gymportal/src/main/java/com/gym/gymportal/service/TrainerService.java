package com.gym.gymportal.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.gymportal.entity.Suppliment;
import com.gym.gymportal.entity.Trainer;
import com.gym.gymportal.entity.User;
import com.gym.gymportal.entity.Workout;
import com.gym.gymportal.repository.SupplimentRepository;
import com.gym.gymportal.repository.TrainerRepository;
import com.gym.gymportal.repository.UserRepository;
import com.gym.gymportal.repository.WorkoutRepository;

@Service
public class TrainerService {
	@Autowired
	private TrainerRepository trainerRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private WorkoutRepository workoutRepository;
	@Autowired
	private SupplimentRepository supplimentRepository;
	
	public void add(Trainer trainer) {
		trainerRepository.save(trainer);
	}
	
	public Trainer authenticateTrainer(Trainer trainer) {
		return trainerRepository.findByContactNoAndPassword(trainer.getContactNo(), trainer.getPassword());
		
	}
	
	public void addWorkoutToUser(int userId, int workoutId) {
	    Optional<User> userOptional = userRepository.findById(userId);
	    Optional<Workout> workoutOptional = workoutRepository.findById(workoutId);

	    if (userOptional.isPresent() && workoutOptional.isPresent()) {
	        User user = userOptional.get();
	        Workout workout = workoutOptional.get();
	        user.setWorkout(workout);
	        userRepository.save(user);
	    }
	}
	
	public void addSupplimentToUser(int userId, int supplimentId) {
		Optional<User> userOptional = userRepository.findById(userId);
		Optional<Suppliment> supplimentOptional = supplimentRepository.findById(supplimentId);
		
		if(userOptional.isPresent() && supplimentOptional.isPresent()) {
			User user = userOptional.get();
			Suppliment suppliment = supplimentOptional.get();
			user.setSuppliment(suppliment);
			userRepository.save(user);
		}
	}
	
	public List<User> getUsersByTrainer(int trainerId) {
		Optional<Trainer> trainerOptional = trainerRepository.findById(trainerId);
		if (trainerOptional.isPresent()) {
		    Trainer trainer = trainerOptional.get();
		    return userRepository.findByTrainer(trainer);
		} else {
		    // Handle the case where the trainer with the given ID was not found
		    return Collections.emptyList(); // Or another appropriate response
		}
    }

	public void update(Trainer updatedTrainer) {
		Optional<Trainer> existingTrainer = trainerRepository.findById(updatedTrainer.getTrainerId());
		if(existingTrainer.isPresent()) {
			Trainer trainer = existingTrainer.get();
			trainer.setContactNo(updatedTrainer.getContactNo());
			trainer.setFees(updatedTrainer.getFees());
			trainer.setFullname(updatedTrainer.getFullname());
			trainer.setPassword(updatedTrainer.getPassword());
			trainer.setSpecialization(updatedTrainer.getSpecialization());
			trainerRepository.save(trainer);
		}else {
			throw new IllegalArgumentException("Trainer not found with ID: "+updatedTrainer.getTrainerId());
		}
	}

	public Optional<Trainer> getTrainerById(int id) {
		return trainerRepository.findById(id);
	}
	
	public List<Trainer> getAllTrainer(){
		return trainerRepository.findAll();
	}
	}

