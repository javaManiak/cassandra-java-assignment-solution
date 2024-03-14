package org.gcs.cja.repository;

import java.util.UUID;

import org.gcs.cja.entity.ScanLocation;
import org.springframework.data.repository.CrudRepository;

public interface ScanLocationRepository extends CrudRepository<ScanLocation, UUID>{

}
