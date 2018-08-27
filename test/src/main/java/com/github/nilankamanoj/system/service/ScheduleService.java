package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.Schedule;
import com.github.nilankamanoj.system.repository.ScheduleRepository;
import java.util.List;

@Service
public class ScheduleService {
	@Autowired
	private ScheduleRepository scheduleRepository;

	public List<Schedule> findAll() {
		List<Schedule> schedules = scheduleRepository.findAll();
		return schedules;
	}

	public Schedule findOne(Integer id) {
		Schedule schedule = scheduleRepository.findOne(id);
		return schedule;
	}

	public Schedule save(Schedule schedule) {
		scheduleRepository.save(schedule);
		Schedule newSchedule = scheduleRepository.findOne(schedule.getId());
		return newSchedule;
	}

}