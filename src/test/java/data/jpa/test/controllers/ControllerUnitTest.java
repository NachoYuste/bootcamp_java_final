package data.jpa.test.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import data.jpa.test.model.Tutorial;
import data.jpa.test.repository.TutorialRepository;
import data.jpa.test.services.TutorialService;



@ExtendWith(SpringExtension.class)
@WebMvcTest(TutorialController.class)
public class ControllerUnitTest {
	@MockBean
	TutorialService tutorialService;
	
	@MockBean
	TutorialRepository tutorialRepository;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void should_update_tutorial_by_id() throws Exception {
		Tutorial newTutorial = new Tutorial("Tut title", "Tut desc", true);
		
		Long id = newTutorial.getId();
		String title = "Titulo";
		String desc = "Descripcion";
		boolean published = true;
		
		when(this.tutorialRepository.getById(newTutorial.getId())).thenReturn(newTutorial);
	    when(this.tutorialRepository.save(newTutorial)).thenReturn(newTutorial);
	    
	    Tutorial mod = tutorialService.updateById(id,"Titulo", "Descripcion", true);

		mockMvc.perform(get("/tutorials/update/"+id+"/"+title+"/"+desc+"/"+published))
				.andExpect(status().isOk());
		
	}
	
}