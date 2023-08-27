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

import com.gym.gymportal.entity.Equipment;
import com.gym.gymportal.entity.Trainer;
import com.gym.gymportal.repository.EquipmentRepository;
import com.gym.gymportal.service.EquipmentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EquipmentController {
	
	@Autowired 
	private EquipmentService equipmentService;
	@Autowired
	private EquipmentRepository equipmentRepository;
	
	@PostMapping("/add-equipment")
	public String add(@RequestBody Equipment equipment) {
		equipmentService.add(equipment);
		return "Equipment added successfully!";
	}
	
	@PostMapping("/update-equipment")
	public String updateTrainer(@RequestBody Equipment equipment) {
		equipmentService.update(equipment);
		return "updated!!";
	}
	
	@GetMapping("/buy-equipment/{userId}/{equipmentId}")
	public String buyEquipment(@PathVariable int userId, @PathVariable int equipmentId) {
		equipmentService.addEquipmentToUser(userId, equipmentId);
		return "product purchased successfully!!";
	}
	
	@GetMapping("/all-equipment")
    public List<Equipment> getAllEquipment() {
        return equipmentRepository.findAll();
    }
	
	@GetMapping("/get-equipmentById/{equipmentId}")
	public Optional<Equipment> getEquipmentById(@PathVariable int equipmentId) {
		return equipmentRepository.findById(equipmentId);
	}
	
	@GetMapping("/delete-equipment/{equipmentId}")
	public String deleteEquipment(@PathVariable int equipmentId) {
	    Optional<Equipment> optionalEquipment = equipmentRepository.findById(equipmentId);

	    if (optionalEquipment.isPresent()) {
	        equipmentRepository.deleteById(equipmentId);
	        return "Equipment deleted successfully!";
	    } else {
	        return "Equipment not found.";
	    }
	}
}
