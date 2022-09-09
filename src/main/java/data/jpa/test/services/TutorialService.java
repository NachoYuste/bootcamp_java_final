package data.jpa.test.services;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.jpa.test.model.Tutorial;
import data.jpa.test.repository.TutorialRepository;

@Service
public class TutorialService {
	@Autowired
	TutorialRepository tutorialRepository;
	
	public Tutorial updateById(Long id, String title, String desc, boolean published) throws NoSuchElementException{
		Tutorial modif = tutorialRepository.getById(id);
		if(modif == null) {
			throw new NoSuchElementException("Unable to update. Id not found.");
		}
		modif.setTitle(title);
		modif.setDescription(desc);
		modif.setPublished(published);
		
		tutorialRepository.save(modif);
		return modif;
	}

}
