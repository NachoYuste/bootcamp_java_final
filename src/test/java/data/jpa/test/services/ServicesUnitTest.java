package data.jpa.test.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

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
  void should_update_tutorial_by_id() { 
      Tutorial newTutorial = new Tutorial("Tut title", "Tut desc", true);
      
      when(this.tutorialRepository.getById(newTutorial.getId())).thenReturn(newTutorial);
      when(this.tutorialRepository.save(newTutorial)).thenReturn(newTutorial);
      
      Tutorial mod = tutorialService.updateById(newTutorial.getId(),"Tut title1", "Tut desc1", true);
      assertEquals(newTutorial.getTitle(), mod.getTitle());
  }
  
//  @Test
//  void should_throw_exception() { 
//      Tutorial newTutorial = new Tutorial("Tut title", "Tut desc", true);
//      
//      when(this.tutorialRepository.getById(newTutorial.getId())).thenReturn(newTutorial);
//      when(this.tutorialRepository.save(newTutorial)).thenReturn(newTutorial);
//      
//      Tutorial mod = tutorialService.updateById(23L,"Tut title1", "Tut desc1", true);
//      assertEquals(newTutorial.getTitle(), mod.getTitle());
//  }
}