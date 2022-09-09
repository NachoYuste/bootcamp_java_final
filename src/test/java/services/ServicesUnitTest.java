package services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
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
import data.jpa.test.services.TutorialService;


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
  
//  @Test
//  void should_find_tutorial_by_id() { 
//      List<Tutorial> list = new ArrayList<Tutorial>();
//      Tutorial tutorialOne = new Tutorial("Tut title", "Tut desc", true);
//      list.add(tutorialOne);
//      when(tutorialRepository.findByPublished(true)).thenReturn(list);
//      List<Tutorial> tutList = tutorialService.findBy(true, null);
//      assertEquals(1, tutList.size());
//      verify(tutorialRepository, times(1)).findByPublished(true);
//  }
  
  @Test
  void should_delete_tutorial_by_id() {
	  Tutorial tutorial = new Tutorial("Tut title", "Tut desc", true);
	  
	  when(tutorialRepository.getById(tutorial.getId())).thenReturn(tutorial);
	  
	  tutorialService.deleteById(tutorial.getId());

	  verify(tutorialRepository, times(1)).delete(tutorial);
	  
  }
}
