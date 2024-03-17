package org.gcs.cja.controller;

import java.util.List;
import java.util.UUID;

import org.gcs.cja.entity.ScanBird;
import org.gcs.cja.repository.ScanBirdRepository;
import org.gcs.cja.service.ScanBirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class ScanBirdController {

	@Autowired
	ScanBirdRepository scanBirdRepo;
	
	@Autowired
	ScanBirdService  birdService;

	public ScanBirdController() {
	}

	@GetMapping("/bird/list")
	public String listBirds(Model model) {
		model.addAttribute("birds", scanBirdRepo.findAll());
		return "birds/list-birds";
	}

	@GetMapping("/bird/new")
	public String displayBirdForm(Model model) {
		ScanBird scanBird = new ScanBird();
		model.addAttribute("bird", scanBird);
		return "birds/new-bird";
	}

	@PostMapping("/bird/save")
	public String createBird(ScanBird bird, Model model) {
		// save to the database using an employee CRUD repository
		scanBirdRepo.save(bird);

		// use a redirect to prevent duplicated submissions
		return "redirect:/bird/new";
	}
	
	@GetMapping("/birds/update")
	public String displayBirdUpdateForm(@RequestParam("id") UUID theId, Model model ) {
		ScanBird theBird = birdService.findByBirdId(theId);
		model.addAttribute("bird", theBird);
		return "birds/new-bird";
	}
	
	
	@GetMapping("/birds/delete")
	public String deleteScanBird(@RequestParam("birdId") UUID theId, Model model ) {
		ScanBird theBird = birdService.findByBirdId(theId);
		birdService.delete(theBird);
		return "birds/list-birds";
	}
	
	@GetMapping("/birds/search/{birdLocation}/{scanDate)")
	public String searchScanBirdLocation(@RequestParam("birdLocation")String theLocation, @RequestParam("scanDate") String theDate, Model model ) {
		List<ScanBird> theBirds = birdService.findByBirdLocationAndScanDate(theLocation, theDate);
		model.addAttribute("birds",theBirds.toArray());
		return "birds/search-birds";
	}
	
}
