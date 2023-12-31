package com.gym.gymportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.gymportal.entity.Workout;
import com.gym.gymportal.repository.WorkoutRepository;

@Service
public class WorkoutService {
	@Autowired
	private WorkoutRepository workoutRepository;
	
	public void add(Workout workout) {
		workoutRepository.save(workout);
	}
	
	public void updateWorkout(Workout updatedWorkout) {
		Optional<Workout> existingWorkout = workoutRepository.findById(updatedWorkout.getWorkoutId());
		if(existingWorkout.isPresent()) {
			Workout workout = existingWorkout.get();
			workout.setDescription(updatedWorkout.getDescription());
			workout.setDuration(updatedWorkout.getDuration());
			workout.setName(updatedWorkout.getName());
			workout.setTrainer(updatedWorkout.getTrainer());
			workoutRepository.save(workout);
		}
	}
	
	public List<Workout> getAllWorkout() {
        return workoutRepository.findAll();
    }
	
	public void deleteWorkoutById(int workoutId) {
        Optional<Workout> workoutOptional = workoutRepository.findById(workoutId);

        if (workoutOptional.isPresent()) {
            Workout workout = workoutOptional.get();

            // You can also perform additional checks or logic here before deleting the workout if needed.

            workoutRepository.delete(workout);
        } else {
            throw new IllegalArgumentException("Workout not found with ID: " + workoutId);
        }
    }
	
}
