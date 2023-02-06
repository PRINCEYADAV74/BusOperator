package com.yash.city;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import com.yash.model.City;
import com.yash.repository.CityRepositoryImpl;
import com.yash.user.mapper.UserMapperCity;

@SpringBootTest
public class CityRepositoryTest1 {

	@InjectMocks
	private CityRepositoryImpl repository;

	@Mock
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@SuppressWarnings("unchecked")
	@Test
	void getCityTest() {
		
		City city = new City(7, "Durg", "CG", 12345);
		java.util.List<City> cityList = namedParameterJdbcTemplate.query(any(String.class),any(UserMapperCity.class));
		Assertions.assertThat(repository.findAll()).isEqualTo(cityList);

	}

	@SuppressWarnings("unchecked")
	@Test
	public void whenMockJdbcTemplate_thenReturnCorrectEmployeeCount() {

		City city = new City(7, "Durg", "CG", 12345);
		when(namedParameterJdbcTemplate.queryForObject(any(String.class), any(Map.class), any(UserMapperCity.class)))
				.thenReturn(city);
		assertEquals(city, repository.findById(7));

	}

}
