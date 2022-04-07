package com.spectrangle.drone1.service;

import com.droneserviceapi.data.payload.request.DroneDeliveryRequest;
import com.droneserviceapi.data.payload.request.DroneGetBatteryRequest;
import com.droneserviceapi.data.payload.request.DroneRegisterRequest;
import com.droneserviceapi.data.payload.request.LoadDroneRequest;
import com.droneserviceapi.data.payload.response.*;
import com.spectrangle.drone1.payload.request.DroneDeliveryRequest;
import com.spectrangle.drone1.payload.request.DroneGetBatteryRequest;
import com.spectrangle.drone1.payload.request.DroneRegisterRequest;
import com.spectrangle.drone1.payload.request.LoadDroneRequest;
import data.response.*;
import org.springframework.stereotype.Component;

@Component
public interface DroneService {
	
	RegisterDroneResponse register(DroneRegisterRequest drone);

	DroneBatteryDetailsResponse getBateryLevel(DroneGetBatteryRequest drequest) throws Exception;
	
	DroneMedicationLoadRsponse getLoadedMedicationForADrone(String serialno);
	
	AvailableDroneResponse getAvailabeDrones();
	
	LoadDroneResponse loadDrone(LoadDroneRequest loadRequest);
	
	DeliverDroneResponse deliverLoad(DroneDeliveryRequest loadRequest);
	
	void preLoadData();

	
}
