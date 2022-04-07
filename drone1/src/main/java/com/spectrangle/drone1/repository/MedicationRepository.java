package com.spectrangle.drone1.repository;

import com.droneserviceapi.modal.Medication;
import com.spectrangle.drone1.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicationRepository extends JpaRepository<Medication, String> {
	
	@Query(value = "SELECT * from medication e where e.code =:id ", nativeQuery = true) // using @query with
	Medication findByCode(@Param("id") String id);

}
