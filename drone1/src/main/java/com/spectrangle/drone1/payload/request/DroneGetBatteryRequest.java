package com.spectrangle.drone1.payload.request;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DroneGetBatteryRequest {

	@NotNull
	private String serialNumber;

	public DroneGetBatteryRequest() {
		
	}
	
	public DroneGetBatteryRequest(@NotNull String serialNumber) {
		super();
		this.serialNumber = serialNumber;
	}


	
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
}
