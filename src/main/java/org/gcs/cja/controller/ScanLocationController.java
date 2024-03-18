package org.gcs.cja.controller;

import org.gcs.cja.entity.ScanLocation;
import org.gcs.cja.repository.ScanLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ScanLocationController {

	@Autowired
	ScanLocationRepository scanLocationRepo;

	public ScanLocationController() {

	}

	@GetMapping("/location/list")
	public String listLocations(Model model) {
		model.addAttribute("locations", scanLocationRepo.findAll());
		return "locations/list-locations";
	}

	@GetMapping("/location/new")
	public String displayLocationForm(Model model) {
		ScanLocation scanLocation = new ScanLocation();
		model.addAttribute("location", scanLocation);
		return "locations/new-location";
	}

	@PostMapping("/location/save")
	public String createLocation(ScanLocation location, Model model) {
		// save to the database using an employee CRUD repository
		scanLocationRepo.save(location);

		// use a redirect to prevent duplicated submissions
		return "redirect:/location/new";
	}
	
//	@GetMapping("/update")
//	public String displayLocationUpdateForm(@RequestParam("id") UUID theId, Model model ) {
//		Location theLocation = locService.findByLocationId(theId);
//		model.addAttribute("location", theLocation);
//		return "locations/new-location";
//	}
//	
//	
//	@GetMapping("/delete")
//	public String deleteLocation(@RequestParam("id") UUID theId, Model model ) {
//		Location theLocation = locService.findByLocationId(theId);
//		locService.delete(theLocation);
//		return "birds/list-birds";
//	}

}
