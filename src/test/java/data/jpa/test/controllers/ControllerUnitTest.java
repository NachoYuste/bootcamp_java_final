package data.jpa.test.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import data.jpa.test.model.Tutorial;
import data.jpa.test.services.TutorialService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TutorialController.class)
public class ControllerUnitTest {
	@MockBean
	TutorialService tutorialService;
	
	@Autowired
	MockMvc mockMvc;
	
//	@Test
//	public void should_get_tutorial_by_id() throws Exception {
//		Tutorial tutorialOne = new Tutorial("Tut title", "Tut desc", true);
//		Long id = (long) 1;
//		when(tutorialService.findById(id)).thenReturn(tutorialOne);
//
//		mockMvc.perform(get("/tutorials/"+id))
//				.andExpect(status().isOk())
//				.andExpect(jsonPath("$", Matchers.hasSize(1)))
//				.andExpect(jsonPath("$[0].title", Matchers.is("Tut title")));
//	}
//	
	@Test void should_create_tutorial() throws Exception {
		
		
	}
}
