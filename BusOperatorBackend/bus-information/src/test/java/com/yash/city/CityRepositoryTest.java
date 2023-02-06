package com.yash.city;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.model.City;
import com.yash.repository.CityRepositoryImpl;

@SpringBootTest
class CityRepositoryTest {

	@Mock
	private CityRepositoryImpl repository;

	@Test
	void saveCityTest() {
		City city = new City(7, "Durg", "CG", 12345);
	
		when(repository.save(city)).thenReturn(1);
		Assertions.assertThat(city.getCityId()).isGreaterThan(0);

	}

	@Test
	public void getCityTest() {
		City city = new City(7, "Durg", "CG", 12345);
		repository.findById(7);
		Assertions.assertThat(city.getCityId()).isEqualTo(7);

	}

	@Test

	public void getListOfCityTest() {
		City city = new City(7, "Durg", "CG", 12345);
		java.util.List<City> cityList = repository.findAll();
		Assertions.assertThat(repository.findAll()).isEqualTo(cityList);

	}

	@Test
	public void updateCityTest() {
		City city = new City(7, "Durg", "CG", 12345);
		repository.update(city, 7);
		city.setCityName("Bhilai");
		Assertions.assertThat(city.getCityName()).isEqualTo("Bhilai");

	}

	@Test
	void deleteCityTest() {
		City city = new City(7, "Durg", "CG", 12345);
		repository.deleteById(7);
		verify(repository, times(1)).deleteById(7);

	}

}