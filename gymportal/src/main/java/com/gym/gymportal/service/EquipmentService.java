package com.gym.gymportal.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.gymportal.entity.Equipment;
import com.gym.gymportal.entity.User;
import com.gym.gymportal.repository.EquipmentRepository;
import com.gym.gymportal.repository.UserRepository;

@Service
public class EquipmentService {
	@Autowired
	private EquipmentRepository equipmentRepository;
	@Autowired
	private UserRepository userRepository;
	
	public void add(Equipment equipment) {
		equipmentRepository.save(equipment);
	}

	public void update(Equipment updatedEquipment) {
		Optional<Equipment> existingEquipment = equipmentRepository.findById(updatedEquipment.getEquipmentId());
		if(existingEquipment.isPresent()) {
			Equipment equipment = existingEquipment.get();
			equipment.setDescription(updatedEquipment.getDescription());
			equipment.setName(updatedEquipment.getName());
			equipment.setPrice(updatedEquipment.getPrice());
			equipment.setStatus(false);
			equipmentRepository.save(equipment);
		}
	}
	
	public void addEquipmentToUser(int userId, int equipmentId) {
		Optional<User> userOptional = userRepository.findById(userId);
		Optional<Equipment> equipmentOptional = equipmentRepository.findById(equipmentId);
		
		if(userOptional.isPresent() && equipmentOptional.isPresent()) {
			User user = userOptional.get();
			Equipment equipment = equipmentOptional.get();
			
			Set<Equipment> equipmentList = user.getEquipments();
			equipmentList.add(equipment);
			
			Set<User> usersList = equipment.getUsers();
			usersList.add(user);
			
			userRepository.save(user);
			equipmentRepository.save(equipment);
		}
	}
	
	public List<Equipment> getEquipmentList() {
		return equipmentRepository.findAll();
	}
	
	public void deleteEquipmentById(int equipmentId) {
        Optional<Equipment> equipmentOptional = equipmentRepository.findById(equipmentId);

        if (equipmentOptional.isPresent()) {
            Equipment equipment = equipmentOptional.get();

            // You can also perform additional checks or logic here before deleting the equipment if needed.

            equipmentRepository.delete(equipment);
        } else {
            throw new IllegalArgumentException("Equipment not found with ID: " + equipmentId);
        }
    }
}
