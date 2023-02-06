package com.yash.route;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.model.Route;
import com.yash.repository.RouteRepository;
import com.yash.service.RouteService;

@SpringBootTest
class RouteServiceTest {

	@Autowired
	private RouteService service;

	@MockBean
	private RouteRepository repository;

	@Test
	void getRouteTest() {

		when(repository.findAll()).thenReturn(Stream.of(new Route(1, 1, 2)).collect(Collectors.toList()));
		assertEquals(1, service.findAll().size());

	}

	@Test
	void findRouteById() {
		Route route = new Route(1, 1, 2);
		when(repository.findById(1)).thenReturn(route);
		assertEquals(route, service.findById(1));
	}

	@Test
	void saveRouteTest() {
		Route route = new Route(1, 1, 2);
		repository.save(route);
		java.util.List<Route> routeList = repository.findAll();
		Assertions.assertThat(service.findAll()).isEqualTo(routeList);

	}

	@Test
	void deleteRouteTest() {
		Route route = new Route(1, 1, 2);
		repository.deleteById(1);
		Assertions.assertThat(service.findAll()).isEmpty();

	}

	@Test
	void updateRouteTest() {
		Route route = new Route(1, 1, 2);
		System.out.println("Old Destination City Id :- " + route.getDestinationCityId());
		repository.update(route, 1);
		route.setDestinationCityId(3);
		verify(repository, times(1)).update(route, 1);
		System.out.println("New Destination City Id :- " + route.getDestinationCityId());

	}

}
