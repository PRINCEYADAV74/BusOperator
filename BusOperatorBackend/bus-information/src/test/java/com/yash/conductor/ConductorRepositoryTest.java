package com.yash.conductor;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.model.Conductor;
import com.yash.repository.ConductorRepository;

@SpringBootTest
class ConductorRepositoryTest {

	@MockBean
	private ConductorRepository repository;

	@Test
	void saveConductorTest() {
		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Conductor conductor = new Conductor(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000,
					"Active");
			repository.save(conductor);
			Assertions.assertThat(conductor.getConductorId()).isGreaterThan(0);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test

	public void getConductorTest() {

		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Conductor conductor = new Conductor(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000,
					"Active");
			repository.findById(1);
			Assertions.assertThat(conductor.getConductorId()).isEqualTo(1);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void getListOfConductorTest() {

		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Conductor conductor = new Conductor(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000,
					"Active");

			java.util.List<Conductor> conductorList = repository.findAll();
			Assertions.assertThat(repository.findAll()).isEqualTo(conductorList);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	public void updateConductorTest() {

		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Conductor conductor = new Conductor(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000,
					"Active");

			repository.update(conductor, 1);
			conductor.setConductorName("Ritesh");
			Assertions.assertThat(conductor.getConductorName()).isEqualTo("Ritesh");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	void deleteConductorTest() {

		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Conductor conductor = new Conductor(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000,
					"Active");

			repository.deleteById(1);
			verify(repository, times(1)).deleteById(1);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}