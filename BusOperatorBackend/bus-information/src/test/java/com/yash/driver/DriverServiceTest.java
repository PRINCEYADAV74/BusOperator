package com.yash.driver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.model.Driver;
import com.yash.repository.DriverRepository;
import com.yash.service.DriverService;

@SpringBootTest
class DriverServiceTest {

	@Autowired
	private DriverService service;

	@MockBean
	private DriverRepository repository;

	@Test
	void getDriverTest() {

		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			when(repository.findAll()).thenReturn(
					Stream.of(new Driver(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000, "Active"))
							.collect(Collectors.toList()));
			assertEquals(1, service.findAll().size());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void findDriverById() {

		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Driver driver = new Driver(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000, "Active");

			when(repository.findById(1)).thenReturn(driver);
			assertEquals(driver, service.findById(1));
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void saveDriverTest() {

		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Driver conductor = new Driver(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000, "Active");
			repository.save(conductor);
			java.util.List<Driver> conductorList = repository.findAll();
			Assertions.assertThat(service.findAll()).isEqualTo(conductorList);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void deleteDriverTest() {
		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Driver driver = new Driver(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000, "Active");
			repository.deleteById(1);
			Assertions.assertThat(service.findAll()).isEmpty();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void updateDriverTest() {
		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Driver driver = new Driver(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000, "Active");

			System.out.println("Old Bus Name :- " + driver.getDriverName());
			repository.update(driver, 1);
			driver.setDriverName("Ritesh");
			verify(repository, times(1)).update(driver, 1);
			System.out.println("New Bus name:- " + driver.getDriverName());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
