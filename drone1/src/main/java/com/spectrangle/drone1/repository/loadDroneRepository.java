package com.spectrangle.drone1.repository;

import com.droneserviceapi.modal.LoadMedication;
import com.spectrangle.drone1.model.LoadMedication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface loadDroneRepository extends JpaRepository<LoadMedication, String> {

	@Query(value = "SELECT * from drone_load e where e.fk_serial_no =:serialno ", nativeQuery = true) // using @query with
	LoadMedication findByDrone(@Param("serialno") String serialno);
	
	@Query(value = "SELECT e from LoadMedication e where e.medication.code =:code ")
	LoadMedication findByCode(@Param("code") String code);
}
