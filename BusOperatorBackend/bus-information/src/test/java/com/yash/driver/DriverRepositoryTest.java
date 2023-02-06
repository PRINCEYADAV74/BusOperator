package com.yash.driver;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.model.Driver;
import com.yash.repository.DriverRepository;


@SpringBootTest
class DriverRepositoryTest {

	@MockBean
	private DriverRepository repository;

	@Test
	void saveDriverTest() {
		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Driver driver = new Driver(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000,
					"Active");
			repository.save(driver);
			Assertions.assertThat(driver.getDriverId()).isGreaterThan(0);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test

	public void getDriverTest() {

		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Driver driver = new Driver(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000,
					"Active");
			repository.findById(1);
			Assertions.assertThat(driver.getDriverId()).isEqualTo(1);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void getListOfDriverTest() {

		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Driver driver = new Driver(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000,
					"Active");

			java.util.List<Driver> driverList = repository.findAll();
			Assertions.assertThat(repository.findAll()).isEqualTo(driverList);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	public void updateDriverTest() {

		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Driver driver = new Driver(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000,
					"Active");

			repository.update(driver, 1);
			driver.setDriverName("Ritesh");
			Assertions.assertThat(driver.getDriverName()).isEqualTo("Ritesh");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	void deleteDriverTest() {

		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Driver driver = new Driver(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000,
					"Active");

			repository.deleteById(1);
			verify(repository, times(1)).deleteById(1);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
