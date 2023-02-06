package com.yash.bus;

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

import com.yash.model.Bus;
import com.yash.repository.BusRepository;
import com.yash.service.BusService;

@SpringBootTest
class BusServiceTest {

	@Autowired
	private BusService service;

	@MockBean
	private BusRepository repository;

	@Test
	void getBusTest() {

		when(repository.findAll())
				.thenReturn(Stream.of(new Bus(1, "MP09CA1234", "YashBus", "Petrol", 80, 4, "Seat", "Active"))
						.collect(Collectors.toList()));
		assertEquals(1, service.findAll().size());

	}

	@Test
	void findBusById() {
		Bus bus = new Bus(1, "MP09CA1234", "YashBus", "Petrol", 80, 4, "Seat", "Active");
		when(repository.findById(1)).thenReturn(bus);
		assertEquals(bus, service.findById(1));
	}

	@Test
	void saveBusTest() {
		Bus bus = new Bus(1, "MP09CA1234", "YashBus", "Petrol", 80, 4, "Seat", "Active");
		repository.save(bus);
		java.util.List<Bus> busList = repository.findAll();
		Assertions.assertThat(service.findAll()).isEqualTo(busList);

	}

	@Test
	void deleteBusTest() {
		Bus bus = new Bus(1, "MP09CA1234", "YashBus", "Petrol", 80, 4, "Seat", "Active");
		repository.deleteById(1);
		Assertions.assertThat(service.findAll()).isEmpty();

	}

	@Test
	void updateBusTest() {
		Bus bus = new Bus(1, "MP09CA1234", "YashBus", "Petrol", 80, 4, "Seat", "Active");
		System.out.println("Old Bus Name :- " + bus.getBusName());
		repository.update(bus, 1);
		bus.setBusName("IndoreBus");
		verify(repository, times(1)).update(bus, 1);
		System.out.println("New Bus name:- " + bus.getBusName());

	}

}
