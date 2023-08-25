package com.gym.gymportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.gym.gymportal.entity.Trainer;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
    public Trainer findByContactNoAndPassword(String contactNo, String password);

}
