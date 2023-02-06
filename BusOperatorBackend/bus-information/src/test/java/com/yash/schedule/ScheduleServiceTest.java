package com.yash.schedule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.model.Schedule;
import com.yash.repository.ScheduleRepository;
import com.yash.service.ScheduleService;

@SpringBootTest
class ScheduleServiceTest {

	@Autowired
	private ScheduleService service;

	@MockBean
	private ScheduleRepository repository;

	@Test
	void getScheduleTest() {

		try {
			String time1 = "10:00:00";
			Time arrivalTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time1);

			String time2 = "11:00:00";
			Time departureTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time2);

			when(repository.findAll()).thenReturn(
					Stream.of(new Schedule(1, 1, 1, 1, 1, arrivalTime, departureTime)).collect(Collectors.toList()));
			assertEquals(1, service.findAll().size());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void findScheduleById() {

		try {
			String time1 = "10:00:00";
			Time arrivalTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time1);

			String time2 = "11:00:00";
			Time departureTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time2);

			Schedule schedule = new Schedule(1, 1, 1, 1, 1, arrivalTime, departureTime);
			when(repository.findById(1)).thenReturn(schedule);
			assertEquals(schedule, service.findById(1));
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void saveScheduleTest() {

		try {
			String time1 = "10:00:00";
			Time arrivalTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time1);

			String time2 = "11:00:00";
			Time departureTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time2);

			Schedule schedule = new Schedule(1, 1, 1, 1, 1, arrivalTime, departureTime);
			repository.save(schedule);
			java.util.List<Schedule> scheduleList = repository.findAll();
			Assertions.assertThat(service.findAll()).isEqualTo(scheduleList);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void deleteSchedulTest() {
		try {
			String time1 = "10:00:00";
			Time arrivalTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time1);

			String time2 = "11:00:00";
			Time departureTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time2);

			Schedule schedule = new Schedule(1, 1, 1, 1, 1, arrivalTime, departureTime);
			repository.deleteById(1);
			Assertions.assertThat(service.findAll()).isEmpty();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	void updateDriverTest() {
		try {
			String time1 = "10:00:00";
			Time arrivalTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time1);

			String time2 = "11:00:00";
			Time departureTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time2);

			Schedule schedule = new Schedule(1, 1, 1, 1, 1, arrivalTime, departureTime);

			System.out.println("Old Schedule Bus Id :- " + schedule.getBusId());
			repository.update(schedule, 1);
			schedule.setBusId(2);
			verify(repository, times(1)).update(schedule, 1);
			System.out.println("New Schedule Bus Id:- " + schedule.getBusId());

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
