package data.jpa.test.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
  
  @Test
  void should_find_tutorial_by_id() { 
      List<Tutorial> list = new ArrayList<Tutorial>();
      Tutorial tutorialOne = new Tutorial("Tut title", "Tut desc", true);
      list.add(tutorialOne);
      when(tutorialRepository.findByPublished(true)).thenReturn(list);
      List<Tutorial> tutList = tutorialService.findBy(true, null);
      assertEquals(1, tutList.size());
      verify(tutorialRepository, times(1)).findByPublished(true);
  }
  
  @Test
  void should_find_all_tutorials() {
	  List<Tutorial> list = new ArrayList<Tutorial>();
	  
	  Tutorial tutorialOne = new Tutorial("Tut title", "Tut desc", true);
	  Tutorial tutorialTwo = new Tutorial("Tut title2", "Tut desc2", true);
	  Tutorial tutorialThree = new Tutorial("Tut title3", "Tut desc3", true);
      
	  list.add(tutorialOne);
      list.add(tutorialTwo);
      list.add(tutorialThree);
      
      when(tutorialRepository.findAll()).thenReturn(list);
      List<Tutorial> tutList = tutorialService.findAll();
      assertEquals(3,tutList.size());
  }
}