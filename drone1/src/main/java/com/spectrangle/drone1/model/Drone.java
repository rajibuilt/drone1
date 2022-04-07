package com.spectrangle.drone1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "tbl_drone")
public class Drone {

	@Id
	@Column(name = "serial_no", columnDefinition = "VARCHAR(16) NOT NULL")
	private String serialNumber;

	@Column(name = "com/spectrangle/drone1/model", columnDefinition = "VARCHAR(50) NOT NULL") // Lightweight, Middleweight, Cruiserweight,
	private String model;

	@Column(name = "weight_limit", columnDefinition = "VARCHAR(10) NOT NULL")
	private double weightLimit;

	@Column(name = "battery",precision = 3, scale = 2)
	private BigDecimal battery;

	@Column(name = "drone_state", columnDefinition = "VARCHAR(20) NOT NULL") // IDLE, LOADING, LOADED, DELIVERING,
	private String state;


	public Drone() {
		
	}

	public Drone(String serialNumber, String model, double weightLimit, BigDecimal battery, String state) {
		super();
		this.serialNumber = serialNumber;
		this.model = model;
		this.weightLimit = weightLimit;
		this.battery = battery;
		this.state = state;
	}

	


	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getWeightLimit() {
		return weightLimit;
	}

	public void setWeightLimit(double weightLimit) {
		this.weightLimit = weightLimit;
	}

	public String getState() {
		return state;
	}

	public BigDecimal getBattery() {
		return battery;
	}

	public void setBattery(BigDecimal battery) {
		this.battery = battery;
	}

	public void setState(String state) {
		this.state = state;
	}

}
