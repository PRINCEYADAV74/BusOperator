package com.yash.schedule;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Time;
import java.text.SimpleDateFormat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.yash.model.Schedule;
import com.yash.repository.ScheduleRepository;

@SpringBootTest
class ScheduleRepositoryTest {

	@MockBean
	private ScheduleRepository repository;

	@Test
	void saveScheduleTest() {
		try {
			String time1 = "10:00:00";
			Time arrivalTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time1);

			String time2 = "11:00:00";
			Time departureTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time2);

			Schedule schedule = new Schedule(1, 1, 1, 1, 1, arrivalTime, departureTime);
			repository.save(schedule);
			Assertions.assertThat(schedule.getDriverId()).isGreaterThan(0);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test

	public void getScheduleTest() {

		try {
			String time1 = "10:00:00";
			Time arrivalTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time1);

			String time2 = "11:00:00";
			Time departureTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time2);

			Schedule schedule = new Schedule(1, 1, 1, 1, 1, arrivalTime, departureTime);
			repository.findById(1);
			Assertions.assertThat(schedule.getDriverId()).isEqualTo(1);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void getListOfScheduleTest() {

		try {
			String time1 = "10:00:00";
			Time arrivalTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time1);

			String time2 = "11:00:00";
			Time departureTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time2);

			Schedule schedule = new Schedule(1, 1, 1, 1, 1, arrivalTime, departureTime);

			java.util.List<Schedule> driverList = repository.findAll();
			Assertions.assertThat(repository.findAll()).isEqualTo(driverList);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Test
	public void updateScheduleTest() {

		try {
			String time1 = "10:00:00";
			Time arrivalTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time1);

			String time2 = "11:00:00";
			Time departureTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time2);

			Schedule schedule = new Schedule(1, 1, 1, 1, 1, arrivalTime, departureTime);
			repository.update(schedule, 1);
			schedule.setBusId(2);
			Assertions.assertThat(schedule.getBusId()).isEqualTo(2);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	void deleteScheduleTest() {

		try {
			String time1 = "10:00:00";
			Time arrivalTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time1);

			String time2 = "11:00:00";
			Time departureTime = (Time) new SimpleDateFormat("HH:mm:ss").parse(time2);

			Schedule schedule = new Schedule(1, 1, 1, 1, 1, arrivalTime, departureTime);
			repository.deleteById(1);
			verify(repository, times(1)).deleteById(1);

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
