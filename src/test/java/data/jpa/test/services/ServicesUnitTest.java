package data.jpa.test.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import data.jpa.test.model.Tutorial;
import data.jpa.test.repository.TutorialRepository;

@ExtendWith(MockitoExtension.class)
public class ServicesUnitTest {
	
	  @InjectMocks
	  TutorialService tutorialService;

	  @Mock
	  TutorialRepository tutorialRepository;

	  @BeforeEach
	  public void init() {
	      MockitoAnnotations.openMocks(this);
	  }
	
	@Test void should_create_tutorial() throws Exception {
		Tutorial newTutorial = new Tutorial("Tut title", "Tut desc", true);
		
		when(this.tutorialRepository.save(newTutorial)).then(newTutorial);
		
		//Create in the DB
		Tutorial createdTutorial = tutorialService.create(newTutorial.getTitle(), newTutorial.getDescription(), newTutorial.isPublished());
		assertEquals(createdTutorial.getId(), newTutorial.getId());
	}
	
	@Test void should_delete_tutorial_by_id() throws Exception {
		Tutorial newTutorial = new Tutorial("Tut title", "Tut desc", true);
		
		doThrow().when(tutorialRepository).delete(newTutorial);
		
		try {
			tutorialService.deleteById(newTutorial.getId());
		}catch(Exception e) {
			assertEqual(e, new Ex)
		}
		
		//Create in the DB
		Tutorial createdTutorial = tutorialService.create(newTutorial.getTitle(), newTutorial.getDescription(), newTutorial.isPublished());
		assertEquals(createdTutorial.getId(), newTutorial.getId());
		
		try {
			
		}
	}
}
