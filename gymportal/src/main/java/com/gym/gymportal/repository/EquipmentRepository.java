package com.gym.gymportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.gymportal.entity.Equipment;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

}
