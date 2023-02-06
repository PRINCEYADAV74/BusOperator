package com.yash.city;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.model.City;
import com.yash.repository.CityRepositoryImpl;
import com.yash.service.CityService;

@SpringBootTest
class CityServiceTest {

	@InjectMocks
	private CityService service;

	@Mock
	private CityRepositoryImpl repository;

	@Test
	void getCityTest() {

		when(repository.findAll()).thenReturn(Stream.of(new City(7, "Durg", "CG", 12345)).collect(Collectors.toList()));
		assertEquals(1, service.findAll().size());

	}

	@Test
	void findCityById() {
		City c = new City(9, "Durg", "CG", 12345);
		when(repository.findById(9)).thenReturn(c);
		assertEquals(c, service.findById(9));
	}

	@Test
	void saveCityTest() {
		City city = new City(7, "Durg", "CG", 12345);
		String a=service.save(city);
		 Assertions.assertThat(a).isNotEmpty();
		java.util.List<City> cityList = repository.findAll();
		Assertions.assertThat(service.findAll()).isEqualTo(cityList);

	}


		
	@Test
	void deleteCityTest() {
		City city = new City(7, "Durg", "CG", 12345);
		when(repository.deleteById(7)).thenReturn(1);
		Assertions.assertThat(service.findAll()).isEmpty();
	    String a=service.deleteById(7);
	    Assertions.assertThat(a).isEqualTo("1 City(s) deleted from the database");
	   

	}
	   
	
	@Test
	void deleteCityTestForNullValue() {
		City city = new City(7, "Durg", "CG", 12345);
	    String a=service.deleteById(0);
	    Assertions.assertThat(a).isEqualTo("0 City(s) deleted from the database because There is no data available for this Primary key ,Please look into it");
	    Assertions.assertThat(a).isNotEmpty();
		}
	
	@Test
	void deleteCityTestForNegativeValue() {
		City city = new City(7, "Durg", "CG", 12345);
	    String a=service.deleteById(-1);
	    Assertions.assertThat(a).isEqualTo("0 City(s) deleted from the database because There is no data available for this Primary key ,Please look into it");
	    Assertions.assertThat(a).isNotEmpty();
		}
	   

	

	@Test
	void updateCityTest() {
		City city = new City(7, "Durg", "CG", 12345);
		when(repository.update(city,7)).thenReturn(1);
		String a=service.update(city, 7);
		city.setCityId(8);
		Assertions.assertThat(service.findById(8)).isNotEqualTo(city);
	    Assertions.assertThat(a).isEqualTo("1 City(s) updated successfully");

		System.out.println("New City Id =>"+ city.getCityId());
		

	}
	@Test
	void updateCityTestForNegativeValue() {
		City city = new City(7, "Durg", "CG", 12345);
		String a=service.update(city, -1);
		city.setCityId(8);
		Assertions.assertThat(service.findById(8)).isNotEqualTo(city);
	    Assertions.assertThat(a).isEqualTo("0 City(s) updated from the database because There is no data available for this Primary key ,Please look into it");

		System.out.println("New City Id =>"+ city.getCityId());

}
	
	@Test
	void updateCityTestForNullValue() {
		City city = new City(7, "Durg", "CG", 12345);
		String a=service.update(city, 0);
		city.setCityId(8);
		Assertions.assertThat(service.findById(8)).isNotEqualTo(city);
	    Assertions.assertThat(a).isEqualTo("0 City(s) updated from the database because There is no data available for this Primary key ,Please look into it");

		System.out.println("New City Id =>"+ city.getCityId());

}
}
