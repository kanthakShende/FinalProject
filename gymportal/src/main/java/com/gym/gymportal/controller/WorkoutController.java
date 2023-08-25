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

import com.gym.gymportal.entity.Workout;
import com.gym.gymportal.repository.WorkoutRepository;
import com.gym.gymportal.service.WorkoutService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class WorkoutController {

	@Autowired
	private WorkoutService workoutService;
	@Autowired
	private WorkoutRepository workoutRepository;
	
	@PostMapping("/add-workout")
	public String add(@RequestBody Workout workout) {
		workoutService.add(workout);
		return "Workout added successfully!";
	}
	
	@PostMapping("/update-workout")
	public String updateWorkout(@RequestBody Workout workout) {
		workoutService.updateWorkout(workout);
		return "updated";
	}
	
	@GetMapping("/delete-workout/{workoutId}")
	public String deleteWorkout(@PathVariable int workoutId) {
		Optional<Workout> optionalWorkout = workoutRepository.findById(workoutId);
		if(optionalWorkout.isPresent()) {
			workoutRepository.deleteById(workoutId);
			return "Workout deleted successfully!";
		}else {
			return "Workout not found!";
		}
	}
	
	@GetMapping("/get-Workout/{workoutId}")
	public Optional<Workout> getWorkoutById(@PathVariable int workoutId){
		return workoutRepository.findById(workoutId);
	}
	
	@GetMapping("/get-AllWorkouts")
	public List<Workout> getAllWorkout(){
		return workoutService.getAllWorkout();
	}
}
