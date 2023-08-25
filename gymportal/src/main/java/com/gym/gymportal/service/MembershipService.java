package com.gym.gymportal.service;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.gymportal.entity.Equipment;
import com.gym.gymportal.entity.Membership;
import com.gym.gymportal.entity.Trainer;
import com.gym.gymportal.entity.User;
import com.gym.gymportal.repository.MembershipRepository;
import com.gym.gymportal.repository.TrainerRepository;
import com.gym.gymportal.repository.UserRepository;

@Service
public class MembershipService {
	@Autowired
	private MembershipRepository membershipRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TrainerRepository trainerRepository;
	
	
	public void add(Membership membership) {
		membershipRepository.save(membership);
	}
	
	public String addMembershipToUser(int userId, int membershipId) {
		Optional<User> userOptional = userRepository.findById(userId);
		Optional<Membership> membershipOptional = membershipRepository.findById(membershipId);
		
		if(userOptional.isPresent() && membershipOptional.isPresent()) {
			User user = userOptional.get();
			Membership membership = membershipOptional.get();
			Trainer trainer = membership.getTrainer();
			List<User> clients = trainer.getClients();
			clients.add(user);
			user.setMembership(membership);
			user.setTrainer(trainer);
			userRepository.save(user);
			trainerRepository.save(trainer);
		}
		
		return "membership purchased successfully";
	}

	public void update(Membership updatedMembership) {
		Optional<Membership> existingMembership = membershipRepository.findById(updatedMembership.getMembershipId());
		if(existingMembership.isPresent()) {
			Membership membership = existingMembership.get();
			membership.setDuration(updatedMembership.getDuration());
			membership.setFees(updatedMembership.getFees());
			membership.setTrainer(updatedMembership.getTrainer());
			membership.setType(updatedMembership.getType());
			membershipRepository.save(membership);
		}
	}
	
	//public void update(Membership updatedMembership)
}
