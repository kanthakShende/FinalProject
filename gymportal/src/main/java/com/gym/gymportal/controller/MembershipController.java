package com.gym.gymportal.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gym.gymportal.entity.Equipment;
import com.gym.gymportal.entity.Membership;
import com.gym.gymportal.repository.MembershipRepository;
import com.gym.gymportal.service.MembershipService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MembershipController {
	
	@Autowired
	private MembershipService membershipService;
	@Autowired
	private MembershipRepository membershipRepository;
	
	@PostMapping("/add-membership")
	public String add(@RequestBody Membership membership) {
		membershipService.add(membership);
		return "Membership added successfully!!";
	}
	
	@PostMapping("/update-membership")
	public String updateMembership(@RequestBody Membership membership) {
		membershipService.update(membership);
		return "updated!!";
	}
	
	@GetMapping("/buy-membership/{userId}/{membershipId}")
	public String addMembershipToUser(@PathVariable int userId, @PathVariable int membershipId) {
		membershipService.addMembershipToUser(userId, membershipId);
		return "Membership purchased successfully!!";
	}
	
	@GetMapping("/delete-membership/{membershipId}")
	public String deleteMembership(@PathVariable int membershipId) {
	    // Check if the equipment exists
	    Optional<Membership> optionalMembership = membershipRepository.findById(membershipId);

	    if (optionalMembership.isPresent()) {
	        // Equipment exists, delete it
	    	membershipRepository.deleteById(membershipId);
	        return "Equipment deleted successfully!";
	    } else {
	        // Equipment not found
	        return "Equipment not found.";
	    }
	}
}
