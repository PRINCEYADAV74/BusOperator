package com.yash.bus;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.model.Bus;
import com.yash.repository.BusRepositoryImpl;

@SpringBootTest
class BusRepositoryTest {

	@MockBean
	private BusRepositoryImpl repository;

	@Test
	void saveBusTest() {
		Bus bus = new Bus(1, "MP09CA1234", "YashBus", "Petrol", 80, 4, "Seat", "Active");
		repository.save(bus);
		Assertions.assertThat(bus.getBusId()).isGreaterThan(0);

	}

	@Test
	public void getBusTest() {
		Bus bus = new Bus(1, "MP09CA1234", "YashBus", "Petrol", 80, 4, "Seat", "Active");
		repository.findById(1);
		Assertions.assertThat(bus.getBusId()).isEqualTo(1);

	}

	@Test

	public void getListOfBusTest() {
		Bus bus = new Bus(1, "MP09CA1234", "YashBus", "Petrol", 80, 4, "Seat", "Active");
		java.util.List<Bus> busList = repository.findAll();
		Assertions.assertThat(repository.findAll()).isEqualTo(busList);

	}

	@Test
	public void updateBusTest() {
		Bus bus = new Bus(1, "MP09CA1234", "YashBus", "Petrol", 80, 4, "Seat", "Active");
		repository.update(bus, 1);
		bus.setBusName("IndoreBus");
		Assertions.assertThat(bus.getBusName()).isEqualTo("IndoreBus");

	}

	@Test
	void deleteCityTest() {
		Bus bus = new Bus(1, "MP09CA1234", "YashBus", "Petrol", 80, 4, "Seat", "Active");
		repository.deleteById(1);
		verify(repository, times(1)).deleteById(1);

	}

}