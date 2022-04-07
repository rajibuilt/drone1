package com.spectrangle.drone1.repository;

import com.droneserviceapi.modal.Drone;
import com.spectrangle.drone1.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface DroneRepository extends JpaRepository<Drone, String> {

	List<Drone> findAllByState(@Param("drone_state") String state); // using method
	
	@Query(value = "SELECT e from Drone e where e.serialNumber =:id ") // using @query with native
	Drone findBySerialNumber(@Param("id") String id);
	
	@Modifying
	@Query(value = "update Drone d set d.state = :state where  d.serialNumber= :serialno") //using query
	void setUpdateState (@Param("state") String status, @Param("serialno") String serialno);
	
}
