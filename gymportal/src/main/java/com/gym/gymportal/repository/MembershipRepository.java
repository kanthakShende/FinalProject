package com.gym.gymportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.gymportal.entity.Membership;

public interface MembershipRepository extends JpaRepository<Membership, Integer> {

}
