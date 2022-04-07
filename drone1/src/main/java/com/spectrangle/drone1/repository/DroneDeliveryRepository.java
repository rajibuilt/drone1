package com.spectrangle.drone1.repository;

import com.droneserviceapi.modal.MedicalDelivery;
import com.spectrangle.drone1.model.MedicalDelivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneDeliveryRepository extends JpaRepository<MedicalDelivery, String> {

}
