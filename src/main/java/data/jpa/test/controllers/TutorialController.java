package data.jpa.test.controllers;

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
	
	@GetMapping("/tutorials/update/{id}/{title}/{desc}/{published}")
	  Tutorial updateById(@PathVariable Long id, @PathVariable String title, @PathVariable String desc, @PathVariable boolean published) {
	    Tutorial tutorial = tutorialService.updateById(id, title, desc, published);
	    return(tutorial);
	  }

}
