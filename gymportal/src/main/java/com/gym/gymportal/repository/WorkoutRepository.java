package com.gym.gymportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.gymportal.entity.Workout;

public interface WorkoutRepository extends JpaRepository<Workout, Integer> {

}
