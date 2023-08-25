package com.gym.gymportal.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Trainer {
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int trainerId;
	
	private String fullname;
	private String specialization;
	private String contactNo;
	private float fees;
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy = "trainer")
    private List<User> clients;

	public Trainer(int trainerId, String fullname, String specialization, String contactNo, float fees, String password,
			List<User> clients) {
		super();
		this.trainerId = trainerId;
		this.fullname = fullname;
		this.specialization = specialization;
		this.contactNo = contactNo;
		this.fees = fees;
		this.password = password;
		this.clients = clients;
	}
	public Trainer() {
		super();
	}
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public float getFees() {
		return fees;
	}
	public void setFees(float fees) {
		this.fees = fees;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<User> getClients() {
		return clients;
	}
	public void setClients(List<User> clients) {
		this.clients = clients;
	}
	
	
}
