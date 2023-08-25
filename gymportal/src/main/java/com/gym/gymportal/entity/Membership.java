package com.gym.gymportal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Membership {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int membershipId;
	private String type;
	private int duration;
	private float fees;
	
	@OneToOne
	@JoinColumn(name = "trainerId") 
	private Trainer trainer;

	public Membership(int membershipId, String type, int duration, float fees, Trainer trainer) {
		super();
		this.membershipId = membershipId;
		this.type = type;
		this.duration = duration;
		this.fees = fees;
		this.trainer = trainer;
	}
	
	public Membership() {
		super();
	}

	public int getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(int membershipId) {
		this.membershipId = membershipId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	
	
}
