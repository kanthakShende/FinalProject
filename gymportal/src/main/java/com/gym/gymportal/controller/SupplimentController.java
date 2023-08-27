package com.gym.gymportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gym.gymportal.entity.Suppliment;
import com.gym.gymportal.repository.SupplimentRepository;
import com.gym.gymportal.service.SupplimentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SupplimentController {
	@Autowired
	private SupplimentService supplimentService;
	@Autowired
	private SupplimentRepository supplimentRepository;
	
	@PostMapping("/add-suppliment")
	public String add(@RequestBody Suppliment suppliment) {
		supplimentService.add(suppliment);
		return "suppliment added successfully!!";
	}
	
	@PostMapping("/update-suppliment")
	public String updateSuppliment(@RequestBody Suppliment suppliment) {
		supplimentService.update(suppliment);
		return "updated";
	}
	
	@GetMapping("/get-suppliments")
	public List<Suppliment> getAllSuppliments(){
		return supplimentService.getAllSupplements();
	}
	
	@GetMapping("/delete-suppliment/{id}")
	public void deleteSuppliment(@PathVariable int id) {
		supplimentService.deleteSupplementById(id);
	}
}
