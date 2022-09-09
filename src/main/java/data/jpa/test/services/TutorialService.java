package data.jpa.test.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.jpa.test.model.Tutorial;
import data.jpa.test.repository.TutorialRepository;



@Service
public class TutorialService {
	@Autowired
	TutorialRepository tutorialRepository;
	
	List<Tutorial> findBy(boolean published, String title){
		List<Tutorial> result = null;
		if(published) {
			result = tutorialRepository.findByPublished(published);
		} else {
			if(title != null && title.length()>0) {
				result = tutorialRepository.findByTitleContaining(title);
			}
		}
		return(result);
	}
	
	public List<Tutorial> findAll(){
		List<Tutorial> result = tutorialRepository.findAll();
		return(result);
	}

	public Tutorial findById(Long id) {
		Optional<Tutorial> result = null;
		result = tutorialRepository.findById(id.longValue());
		if(result.isEmpty()) {
			return null;
		} else {
			return(result.get());
		}
	}
}