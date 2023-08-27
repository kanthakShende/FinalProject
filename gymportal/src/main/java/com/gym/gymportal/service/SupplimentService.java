package com.gym.gymportal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.gymportal.entity.Suppliment;
import com.gym.gymportal.entity.User;
import com.gym.gymportal.entity.Workout;
import com.gym.gymportal.repository.SupplimentRepository;
import com.gym.gymportal.repository.UserRepository;

@Service
public class SupplimentService {
	@Autowired
	private SupplimentRepository supplimentRepository;
	@Autowired
	private UserRepository userRepository;
	
	public void add(Suppliment suppliment) {
		supplimentRepository.save(suppliment);
	}
	
	public void update(Suppliment updatedSuppliment) {
		Optional<Suppliment> existingSuppliment = supplimentRepository.findById(updatedSuppliment.getSupplimentId());
		if(existingSuppliment.isPresent()) {
			Suppliment suppliment = existingSuppliment.get();
			suppliment.setChapati(updatedSuppliment.getChapati());
			suppliment.setChicken(updatedSuppliment.getChicken());
			suppliment.setEggs(updatedSuppliment.getEggs());
			suppliment.setFluidQuantity(updatedSuppliment.getFluidQuantity());
			suppliment.setProtineshake(updatedSuppliment.getProtineshake());
			suppliment.setPulses(updatedSuppliment.getPulses());
			suppliment.setRice(updatedSuppliment.getRice());
			supplimentRepository.save(suppliment);
		} else {
			throw new IllegalArgumentException("Suppliment not found with ID: "+ updatedSuppliment.getSupplimentId());
		}
	}
	
	 public void deleteSupplementById(int supplementId) {
	        Optional<Suppliment> supplimentOptional = supplimentRepository.findById(supplementId);

	        if (supplimentOptional.isPresent()) {
	            Suppliment supplement = supplimentOptional.get();

	            // You can also perform additional checks or logic here before deleting the supplement if needed.

	            supplimentRepository.delete(supplement);
	        } else {
	            throw new IllegalArgumentException("Supplement not found with ID: " + supplementId);
	        }
	    }
	 
	 public List<Suppliment> getAllSupplements() {
	        return supplimentRepository.findAll();
	    }
	 
	 
	
}
