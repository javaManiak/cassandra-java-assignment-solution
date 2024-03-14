package org.gcs.cja.controller;

import org.gcs.cja.entity.ScanBird;
import org.gcs.cja.repository.ScanBirdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ScanBirdController {

	@Autowired
	ScanBirdRepository scanBirdRepo;

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
}
