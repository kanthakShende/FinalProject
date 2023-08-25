package com.gym.gymportal.entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int invoiceId;
	
	@ManyToOne
	@JoinColumn(name = "equipmentId")
	private Equipment equipment;
	
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public Invoice(int invoiceId, Equipment equipment, LocalDate date, User user) {
		super();
		this.invoiceId = invoiceId;
		this.equipment = equipment;
		this.date = date;
		this.user = user;
	}
	
	public Invoice() {
		super();
	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
