package data.jpa.test.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.jpa.test.model.Tutorial;
import data.jpa.test.repository.TutorialRepository;


@Service
public class TutorialService {
	@Autowired
	TutorialRepository tutorialRepository;
	
	public Tutorial create(String title, String desc, boolean published) throws NoSuchElementException {
		
		//Check if already exists
		List<Tutorial> tutorial = null;
		tutorial = this.tutorialRepository.findByTitleContaining(title);
		
		if(!tutorial.isEmpty()) {
			//Creates new tutorial
			Tutorial newTutorial = new Tutorial(title, desc, published);
			//Saves the new tutorial
			this.tutorialRepository.save(newTutorial);
			return newTutorial;
		}
		else
			throw new NoSuchElementException("Unable to create tutorial");
	}
}
