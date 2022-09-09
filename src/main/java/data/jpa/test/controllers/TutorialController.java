package data.jpa.test.controllers;

import java.util.List;

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
	
	@GetMapping("/tutorials/{id}")
	  Tutorial readById(@PathVariable Long id) {
	    Tutorial tutorial = tutorialService.findById(id);
	    return(tutorial);
	  }
	
	@GetMapping("/tutorials")
	  List<Tutorial> readAll() {
	    List<Tutorial> tutorials = tutorialService.findAll();
	    return(tutorials);
	  }
}