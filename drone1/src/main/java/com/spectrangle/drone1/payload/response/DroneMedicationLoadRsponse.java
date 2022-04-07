package com.spectrangle.drone1.payload.response;

import com.droneserviceapi.modal.Medication;
import com.spectrangle.drone1.model.Medication;

import java.time.LocalDateTime;

public class DroneMedicationLoadRsponse {

	private String result;
	private String serialNumber;
	private LocalDateTime timestamp;
	Medication medication;
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public Medication getMedication() {
		return medication;
	}
	public void setMedication(Medication medication) {
		this.medication = medication;
	}
}
