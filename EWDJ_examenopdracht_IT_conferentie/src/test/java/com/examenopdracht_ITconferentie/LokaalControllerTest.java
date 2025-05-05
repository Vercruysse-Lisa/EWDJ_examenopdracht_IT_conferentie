package com.examenopdracht_ITconferentie;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import domain.Lokaal;
import service.LokaalService;


@AutoConfigureMockMvc
@SpringBootTest
public class LokaalControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	LokaalService mockService;
	
	@Test
	void testLokaalGet() throws Exception {
		mockMvc.perform(get("/lokaal"))
			.andExpect(status().isOk())
			.andExpect(view().name("lokaalForm"))
			.andExpect(model().attributeExists("lokaal"));
	}
	
	@Test
	void testLokaalPostValidData() throws Exception {
		Lokaal mockLokaal = new Lokaal();
		mockLokaal.setLokaalNaam("a234");
		mockLokaal.setCapaciteit(20);
		when(mockService.saveLokaal(any(Lokaal.class))).thenReturn(mockLokaal);
		
		mockMvc.perform(post("/lokaal")
				.param("lokaalNaam", "a234")
				.param("capaciteit", "20"))
					.andExpect(status().isOk())
					.andExpect(view().name("lokaalForm"))
					.andExpect(model().attributeExists("saved"))
					.andExpect(model().attribute("saved", true));
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"aaa", "a1", "a23555", "145a"})
	void testLokaalPostInvalidName(String invalidName) throws Exception {
		mockMvc.perform(post("/lokaal")
				.param("lokaalNaam", invalidName)
				.param("capaciteit", "30"))
					.andExpect(status().isOk())
					.andExpect(view().name("lokaalForm"))
					.andExpect(model().attributeHasFieldErrors("lokaal", "lokaalNaam"))
					.andExpect(model().attributeDoesNotExist("saved"));
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"0", "-5", "51", "60"})
	void testLokaalPostInvalidCapaciteit(String invalidCapacity) throws Exception{
		mockMvc.perform(post("/lokaal")
				.param("lokaalNaam", "a234")
				.param("capaciteit", invalidCapacity))
					.andExpect(status().isOk())
					.andExpect(view().name("lokaalForm"))
					.andExpect(model().attributeHasFieldErrors("lokaal", "capaciteit"))
					.andExpect(model().attributeDoesNotExist("saved"));
	}
}
