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

import com.gym.gymportal.entity.Trainer;
import com.gym.gymportal.entity.User;
import com.gym.gymportal.repository.TrainerRepository;
import com.gym.gymportal.service.TrainerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TrainerController {
	
	@Autowired
	private TrainerService trainerservice;
	@Autowired
	private TrainerRepository trainerRepository;
	
	@PostMapping("/add-trainer")
	public String add(@RequestBody Trainer trainer) {
		trainerservice.add(trainer);
		return "trainer added successfully!!";
	}
	
	@PostMapping("/trainer-login")
	public Trainer trainerLogin(@RequestBody Trainer trainer) {
		return trainerservice.authenticateTrainer(trainer);
	}
	
	@PostMapping("/update-trainer")
	public String updateTrainer(@RequestBody Trainer trainer) {
		trainerservice.update(trainer);
		return "updated!!";
	}
	
	@GetMapping("/add-workoutToUser/{userId}/{workoutId}")
	public String addWorkout(@PathVariable int userId, @PathVariable int workoutId) {
		trainerservice.addWorkoutToUser(userId, workoutId);
		return "Workout added successfully!!";
	}
	
	@GetMapping("/add-supplimentToUser/{userId}/{supplimentId}")
	public String addSuppliment(@PathVariable int userId, @PathVariable int supplimentId) {
		trainerservice.addSupplimentToUser(userId, supplimentId);
		return "Suppliment added successfully!!";
	}
	
	@GetMapping("/trainer-users/{trainerId}")
    public List<User> getUsersByTrainer(@PathVariable int trainerId) {
        return trainerservice.getUsersByTrainer(trainerId);
    }
	
	@GetMapping("/get-trainer/{id}")
	public Optional<Trainer> getUser(@PathVariable int id){
		return trainerservice.getTrainerById(id);
	}
	
	@GetMapping("/delete-trainer/{trainerId}")
	public String deleteTrainer(@PathVariable int trainerId) {
		Optional<Trainer> optionalTrainer = trainerRepository.findById(trainerId);
		if(optionalTrainer.isPresent()) {
			trainerRepository.deleteById(trainerId);
			return "trainer deleted successfully";
		}else {
			return "trainer not found";
		}
	}
	
	@GetMapping("/get-trainers")
	public List<Trainer> getAllTrainers(){
		return trainerservice.getAllTrainer();
	}
	
	
}
