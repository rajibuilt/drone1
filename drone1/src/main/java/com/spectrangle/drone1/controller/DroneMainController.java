package com.spectrangle.drone1.controller;

import com.droneserviceapi.data.payload.request.DroneDeliveryRequest;
import com.droneserviceapi.data.payload.request.DroneGetBatteryRequest;
import com.droneserviceapi.data.payload.request.DroneRegisterRequest;
import com.droneserviceapi.data.payload.request.LoadDroneRequest;
import com.droneserviceapi.data.payload.response.*;
import com.droneserviceapi.service.DroneSeriviceImpl;
import com.spectrangle.drone1.payload.request.DroneDeliveryRequest;
import com.spectrangle.drone1.payload.request.DroneGetBatteryRequest;
import com.spectrangle.drone1.payload.request.DroneRegisterRequest;
import com.spectrangle.drone1.payload.request.LoadDroneRequest;
import com.spectrangle.drone1.payload.response.*;
import com.spectrangle.drone1.service.DroneSeriviceImpl;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path="/api/drone")
@Validated
public class DroneMainController {
	@Autowired
	private DroneSeriviceImpl droneService;

	@PostMapping(path="/register", consumes = "application/json", produces = "application/json")
	public ResponseEntity<RegisterDroneResponse> registerDrone(@NotNull @RequestBody DroneRegisterRequest dronerequest) {
		RegisterDroneResponse newDrone = droneService.register(dronerequest);
		return new ResponseEntity<RegisterDroneResponse>(newDrone, HttpStatus.CREATED);
	}

	@GetMapping(path= "/available", produces = "application/json")
	public ResponseEntity<AvailableDroneResponse> getAvailableDroneForLoading() {
		AvailableDroneResponse drones = droneService.getAvailabeDrones();
		return new ResponseEntity<AvailableDroneResponse>(drones, HttpStatus.OK);
	}

	@PostMapping(path ="/battery", consumes = "application/json", produces = "application/json")
	public ResponseEntity<DroneBatteryDetailsResponse> checkDroneBattery(
			@NotNull @RequestBody(required = true) DroneGetBatteryRequest drequest) {
		if (drequest.getSerialNumber() == null || drequest.getSerialNumber().isEmpty()) {
			throw new RuntimeException("SerialNumber is Required");
		}
		DroneBatteryDetailsResponse droneBattery = droneService.getBateryLevel(drequest);
		return new ResponseEntity<DroneBatteryDetailsResponse>(droneBattery, HttpStatus.CREATED);
	}

	@PostMapping(path = "/load", consumes = "application/json", produces = "application/json")
	public ResponseEntity<LoadDroneResponse> loadDroneWithMedication(@Valid @NotNull @RequestBody LoadDroneRequest loadrequest) {
		LoadDroneResponse loadDrone = droneService.loadDrone(loadrequest);
		return new ResponseEntity<LoadDroneResponse>(loadDrone, HttpStatus.CREATED);
	}

	@GetMapping(path = "details/{serialNumber}", produces = "application/json")
	public ResponseEntity<DroneMedicationLoadRsponse> checkLoadedMedicationItem(@PathVariable("serialNumber") String serialNumber) {
		DroneMedicationLoadRsponse droneLoads = droneService.getLoadedMedicationForADrone(serialNumber);
		return new ResponseEntity<DroneMedicationLoadRsponse>(droneLoads, HttpStatus.OK);
	}

	@PostMapping(path = "/deliver", consumes = "application/json", produces = "application/json")
	public ResponseEntity<DeliverDroneResponse> droneMedicalLoadDelivery(@NotNull @RequestBody DroneDeliveryRequest deliverRequest) {
		DeliverDroneResponse delivery = droneService.deliverLoad(deliverRequest);
		return new ResponseEntity<DeliverDroneResponse>(delivery, HttpStatus.CREATED);
	}

}
