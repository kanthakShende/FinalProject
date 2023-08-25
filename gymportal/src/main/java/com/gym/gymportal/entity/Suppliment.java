package com.gym.gymportal.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Suppliment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int supplimentId;
	
	private int fluidQuantity;
	private int eggs;
	private int protineshake;
	private int chicken;
	private int rice;
	private int chapati;
	private int pulses;
	
	public Suppliment(int supplimentId, int fluidQuantity, int eggs, int protineshake, int chicken, int rice,
			int chapati, int pulses) {
		super();
		this.supplimentId = supplimentId;
		this.fluidQuantity = fluidQuantity;
		this.eggs = eggs;
		this.protineshake = protineshake;
		this.chicken = chicken;
		this.rice = rice;
		this.chapati = chapati;
		this.pulses = pulses;
	}
	
	public Suppliment() {
		super();
	}

	public int getSupplimentId() {
		return supplimentId;
	}

	public void setSupplimentId(int supplimentId) {
		this.supplimentId = supplimentId;
	}

	public int getFluidQuantity() {
		return fluidQuantity;
	}

	public void setFluidQuantity(int fluidQuantity) {
		this.fluidQuantity = fluidQuantity;
	}

	public int getEggs() {
		return eggs;
	}

	public void setEggs(int eggs) {
		this.eggs = eggs;
	}

	public int getProtineshake() {
		return protineshake;
	}

	public void setProtineshake(int protineshake) {
		this.protineshake = protineshake;
	}

	public int getChicken() {
		return chicken;
	}

	public void setChicken(int chicken) {
		this.chicken = chicken;
	}

	public int getRice() {
		return rice;
	}

	public void setRice(int rice) {
		this.rice = rice;
	}

	public int getChapati() {
		return chapati;
	}

	public void setChapati(int chapati) {
		this.chapati = chapati;
	}

	public int getPulses() {
		return pulses;
	}

	public void setPulses(int pulses) {
		this.pulses = pulses;
	}

	
}
