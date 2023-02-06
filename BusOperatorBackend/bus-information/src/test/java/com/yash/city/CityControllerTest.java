package com.yash.city;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yash.controller.CityController;
import com.yash.model.City;
import com.yash.repository.CityRepositoryImpl;
import com.yash.service.CityService;

@WebMvcTest(CityController.class)
public class CityControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private CityService cityService;

	@Mock
	private CityRepositoryImpl repository;

	@Test
	public void listAllCityTest() throws Exception {
		City city = new City(7, "Durg", "CG", 12345);
		List<City> allUsers = Arrays.asList(city);
		when(cityService.findAll()).thenReturn(allUsers);
		mvc.perform(get("/city/details").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void listAllCityWithEmptyListTest() throws Exception {
		Assertions.assertThat(cityService.findAll().isEmpty()).isEqualTo(true);
		mvc.perform(get("/city/details").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}

	@Test
	public void listCityByIdTest() throws Exception {
		City city = new City(7, "Durg", "CG", 12345);
		when(cityService.findById(7)).thenReturn(city);
		mvc.perform(get("/city/7").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void listCityDeleteyByIdTest() throws Exception {
		City city = new City(7, "Durg", "CG", 12345);
		when(cityService.deleteById(7)).thenReturn("done");
		mvc.perform(delete("/city/delete/7").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	public void saveCityTest() throws Exception {
		City city = new City(7, "Durg", "CG", 12345);
		cityService.save(city);
		Assertions.assertThat(city.getCityName()).isEqualTo("Durg");
		ObjectMapper mapper = new ObjectMapper();
		mvc.perform(
				post("/city/insert").content(mapper.writeValueAsString(city)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void saveCityTestForNullValue() throws Exception {
		City city = new City(7, "", "CG", 12345);
		cityService.save(city);
		ObjectMapper mapper = new ObjectMapper();
		mvc.perform(
				post("/city/insert").content(mapper.writeValueAsString(city)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

	}

	@Test
	public void saveCityTestForNegativeValue() throws Exception {
		City city = new City(7, "Durg", "CG", -12345);
		cityService.save(city);
		ObjectMapper mapper = new ObjectMapper();
		mvc.perform(
				post("/city/insert").content(mapper.writeValueAsString(city)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());

	}

	@Test
	public void updateCityByIdTest() throws Exception {
		City city = new City(7, "Durg", "CG", 12345);
		when(cityService.update(city, 7)).thenReturn(city.toString());
		city.setCityId(8);
		ObjectMapper mapper = new ObjectMapper();
		mvc.perform(
				put("/city/update/7").content(mapper.writeValueAsString(city)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		System.out.println("New City Id =>" + city.getCityId());

	}

	@Test
	public void updateCityByIdWithNullValueTest() throws Exception {
		City city = new City(7, "Durg", "CG", 12345);
		when(cityService.update(city, 7)).thenReturn(city.toString());
		city.setCityName("");
		ObjectMapper mapper = new ObjectMapper();
		mvc.perform(
				put("/city/update/7").content(mapper.writeValueAsString(city)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
		System.out.println("New City Id =>" + city.getCityName());

	}

	@Test
	public void updateCityByIdWithNegativeValueTest() throws Exception {
		City city = new City(7, "Durg", "CG", 12345);
		when(cityService.update(city, 7)).thenReturn(city.toString());
		city.setPincode(-1);
		ObjectMapper mapper = new ObjectMapper();
		mvc.perform(
				put("/city/update/7").content(mapper.writeValueAsString(city)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
		System.out.println("New City Id =>" + city.getPincode());

	}

}