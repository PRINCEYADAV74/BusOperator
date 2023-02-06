package com.yash.repository;

import java.util.List;

import com.yash.model.Schedule;


public interface ScheduleRepository {
	
	public List<Schedule> findAll();

	public Schedule findById(int id);

	public int deleteById(int id);

	public int save(Schedule s);

	public int update(Schedule s, int id);

}
