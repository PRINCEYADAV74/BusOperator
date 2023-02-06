package com.yash.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yash.model.Schedule;
import com.yash.repository.ScheduleRepository;

@Service
public class ScheduleService {
	@Autowired
	private ScheduleRepository scheduleRepository;

	public List<Schedule> findAll() {
		return scheduleRepository.findAll();
	}

	public Schedule findById(int id) {
		return scheduleRepository.findById(id);
	}

	public String deleteById(int id) {

		if (scheduleRepository.deleteById(id) > 0)
			return scheduleRepository.deleteById(id) + " Schedule(s) deleted from the database";
		else
			return scheduleRepository.deleteById(id)
					+ " Schedule(s) deleted from the database because There is no data available for this Primary key ,Please look into it";
	}

	public String save(Schedule s) {
		return scheduleRepository.save(s) + " Schedule(s) saved successfully";
	}

	public String update(Schedule s, int id) {
		if (scheduleRepository.update(s, id) > 0)
			return scheduleRepository.update(s, id) + " Schedule(s) updated successfully";

		else {
			return scheduleRepository.update(s, id)
					+ " Schedule(s) updated from the database because There is no data available for this Primary key ,Please look into it";

		}

	}
}
