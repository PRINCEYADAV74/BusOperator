package com.yash.route;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.model.Route;
import com.yash.repository.RouteRepository;

@SpringBootTest
class RouteRepositoryTest {

	@MockBean
	private RouteRepository repository;

	@Test
	void saveRouteTest() {
		Route route = new Route(1, 1, 2);
		repository.save(route);
		Assertions.assertThat(route.getRouteId()).isGreaterThan(0);

	}

	@Test

	public void getRouteTest() {
		Route route = new Route(1, 1, 2);
		repository.findById(1);
		Assertions.assertThat(route.getRouteId()).isEqualTo(1);

	}

	@Test

	public void getListOfRouteTest() {
		Route route = new Route(1, 1, 2);
		java.util.List<Route> routeList = repository.findAll();
		Assertions.assertThat(repository.findAll()).isEqualTo(routeList);

	}

	@Test
	public void updateBusTest() {
		Route route = new Route(1, 1, 2);
		repository.update(route, 1);
		route.setDestinationCityId(3);
		Assertions.assertThat(route.getDestinationCityId()).isEqualTo(3);

	}

	@Test
	void deleteCityTest() {
		Route route = new Route(1, 1, 2);
		repository.deleteById(1);
		verify(repository, times(1)).deleteById(1);

	}

}
