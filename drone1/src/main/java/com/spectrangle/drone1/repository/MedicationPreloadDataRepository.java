package com.spectrangle.drone1.repository;

import com.droneserviceapi.modal.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationPreloadDataRepository extends JpaRepository<Medication, String> {

	
	
}
