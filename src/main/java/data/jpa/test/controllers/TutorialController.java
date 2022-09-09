package data.jpa.test.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import data.jpa.test.model.Tutorial;
import data.jpa.test.services.TutorialService;

@RestController
public class TutorialController {
	
	@Autowired
	TutorialService tutorialService;
	
	@GetMapping("/tutorials/create/{title}/{desc}/{published}")
	Tutorial create(@PathVariable String title, @PathVariable String desc, @PathVariable boolean published) {
		Tutorial tutorial = tutorialService.create(title, desc, published);
		return tutorial;	
	}

}
