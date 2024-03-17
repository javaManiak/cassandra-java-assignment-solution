package org.gcs.cja.service;

import java.util.List;

import org.gcs.cja.entity.ScanLocation;
import org.gcs.cja.repository.ScanLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScanLocationService {

	@Autowired
	ScanLocationRepository locRepo;

	public ScanLocation save(ScanLocation loc) {
		return locRepo.save(loc);
	}

	public List<ScanLocation> getAll() {
		return (List<ScanLocation>) locRepo.findAll();
	}

}
