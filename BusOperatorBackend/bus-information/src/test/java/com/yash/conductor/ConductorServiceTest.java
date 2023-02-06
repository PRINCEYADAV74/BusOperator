package com.yash.conductor;

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

import com.yash.model.Conductor;
import com.yash.repository.ConductorRepository;
import com.yash.service.ConductorService;

@SpringBootTest
class ConductorServiceTest {

	@Autowired
	private ConductorService service;

	@MockBean
	private ConductorRepository repository;

	@Test
	void getConductorTest() {

		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			when(repository.findAll()).thenReturn(Stream
					.of(new Conductor(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000, "Active"))
					.collect(Collectors.toList()));
			assertEquals(1, service.findAll().size());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void findConductorById() {

		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Conductor conductor = new Conductor(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000,
					"Active");

			when(repository.findById(1)).thenReturn(conductor);
			assertEquals(conductor, service.findById(1));
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void saveBusTest() {

		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Conductor conductor = new Conductor(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000,
					"Active");
			repository.save(conductor);
			java.util.List<Conductor> conductorList = repository.findAll();
			Assertions.assertThat(service.findAll()).isEqualTo(conductorList);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void deleteBusTest() {
		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Conductor conductor = new Conductor(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000,
					"Active");
			repository.deleteById(1);
			Assertions.assertThat(service.findAll()).isEmpty();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void updateBusTest() {
		try {
			String sDate1 = "31/12/1998";
			Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);

			Conductor conductor = new Conductor(1, "Lokesh", date1, "male", "ABC12334", date1, "9099090909", 20000,
					"Active");

			System.out.println("Old Bus Name :- " + conductor.getConductorName());
			repository.update(conductor, 1);
			conductor.setConductorName("Ritesh");
			verify(repository, times(1)).update(conductor, 1);
			System.out.println("New Bus name:- " + conductor.getConductorName());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
