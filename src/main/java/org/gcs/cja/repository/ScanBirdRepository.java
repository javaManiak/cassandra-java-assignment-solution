package org.gcs.cja.repository;

import java.util.List;
import java.util.UUID;

import org.gcs.cja.entity.ScanBird;
import org.springframework.data.repository.CrudRepository;

public interface ScanBirdRepository extends CrudRepository<ScanBird, UUID> {

	ScanBird findByBirdId(UUID theId);

	List<ScanBird> findByLocation(String theLocation);
	
}