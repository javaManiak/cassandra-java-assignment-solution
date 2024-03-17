package org.gcs.cja.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.gcs.cja.entity.ScanBird;
import org.gcs.cja.repository.ScanBirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScanBirdService {

	@Autowired
	ScanBirdRepository birdRepo;

	public ScanBird save(ScanBird bird) {
		return birdRepo.save(bird);
	}

	public List<ScanBird> getAll() {
		return (List<ScanBird>) birdRepo.findAll();
	}

	public ScanBird findByBirdId(UUID theId) {
		return birdRepo.findByBirdId(theId);
	}

	public void delete(ScanBird theBird) {
		birdRepo.delete(theBird);
	}

	public List<ScanBird> findByBirdLocationAndScanDate(String birdLocation, String scanDate) {
		
		List<ScanBird> birdFoundByLocation = birdRepo.findByLocation(birdLocation);
		List<ScanBird> birdByLocationAndDate = new ArrayList<>();
		
		for (ScanBird bird : birdFoundByLocation) {
			if (bird.getScanDate().equals(scanDate)) {
				birdByLocationAndDate.add(bird);
			}
		}
		return birdByLocationAndDate;
	}
}
