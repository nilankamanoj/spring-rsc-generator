package com.github.nilankamanoj.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Controller;
import com.github.nilankamanoj.system.model.Schedule;
import com.github.nilankamanoj.system.service.ScheduleService;

@Controller
@RequestMapping(path = "/schedule")
public class ScheduleController{
	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Schedule> schedules = scheduleService.findAll();
		return new ResponseEntity<>(schedules, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Schedule schedule = scheduleService.findOne(id);
		return new ResponseEntity<>(schedule, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Schedule schedule) {
		Schedule newSchedule = scheduleService.save(schedule);
		return new ResponseEntity<>( newSchedule, HttpStatus.OK);
	}
}