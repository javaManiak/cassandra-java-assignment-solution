package org.gcs.cja.controller;

import java.util.List;

import org.gcs.cja.entity.ScanBird;
import org.gcs.cja.entity.ScanLocation;
import org.gcs.cja.repository.ScanBirdRepository;
import org.gcs.cja.repository.ScanLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
public class HomePageController {

	@Value("${version}")
	private String ver;
	
		
	@Autowired
	ScanLocationRepository locationRepo;
	
	@Autowired
	ScanBirdRepository birdRepo;

	@GetMapping("/")
	public String displayHomePage(Model model) throws JsonProcessingException {

		model.addAttribute("versionNumber", ver);
		
		List<ScanLocation> locations = (List<ScanLocation>) locationRepo.findAll();
		model.addAttribute("locations", locations);

		List<ScanBird> birds = (List<ScanBird>) birdRepo.findAll();
		model.addAttribute("birds", birds);
		return "main/home";
	}	

}
