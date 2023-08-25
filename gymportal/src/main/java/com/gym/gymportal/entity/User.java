package com.gym.gymportal.entity;

import javax.persistence.GeneratedValue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	private String fullName;
	private String password;
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "trainerId")
	private Trainer trainer;
	
	@ManyToOne
	@JoinColumn(name = "membershipId")
	private Membership membership;
	
	@ManyToOne
	@JoinColumn(name = "workoutId")
	private Workout workout;
	
	@ManyToOne
	@JoinColumn(name = "supplimentId")
	private Suppliment suppliment;
	

	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_equipment",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private Set<Equipment> equipments = new HashSet<>();


	public User(int userId, String fullName, String password, String email, Trainer trainer, Membership membership,
			Workout workout, Suppliment suppliment, Set<Equipment> equipments) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.password = password;
		this.email = email;
		this.trainer = trainer;
		this.membership = membership;
		this.workout = workout;
		this.suppliment = suppliment;
		this.equipments = equipments;
	}

	public User() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public Workout getWorkout() {
		return workout;
	}

	public void setWorkout(Workout workout) {
		this.workout = workout;
	}

	public Suppliment getSuppliment() {
		return suppliment;
	}

	public void setSuppliment(Suppliment suppliment) {
		this.suppliment = suppliment;
	}

	public Set<Equipment> getEquipments() {
		return equipments;
	}

	public void setEquipments(Set<Equipment> equipments) {
		this.equipments = equipments;
	}
	
	
}
