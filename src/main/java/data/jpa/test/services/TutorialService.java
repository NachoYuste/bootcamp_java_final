package data.jpa.test.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import data.jpa.test.model.Tutorial;
import data.jpa.test.repository.TutorialRepository;

@Service
public class TutorialService {

	@Autowired
	TutorialRepository tutorialRepository;

	public List<Tutorial> findBy(boolean published, String title) {
		List<Tutorial> result = null;
		if (published) {
			result = tutorialRepository.findByPublished(published);
		} else {
			if (title != null && title.length() > 0) {
				result = tutorialRepository.findByTitleContaining(title);
			}
		}
		return (result);
	}

	public void deleteById(Long id) throws NoSuchElementException{
		Tutorial result = null;
		result = tutorialRepository.getById(id.longValue());
		if (result != null) {
			this.tutorialRepository.delete(result);
		}
		else {
			throw new NoSuchElementException("Tutorial [" + id + "] does not exist");
		}
	}

	public Tutorial findById(Long id) { 
		Optional<Tutorial> result = null;
		result = tutorialRepository.findById(id.longValue());
		if (result.isEmpty()) {
			return null;
		} else {
			return (result.get());
		}
	}

}
