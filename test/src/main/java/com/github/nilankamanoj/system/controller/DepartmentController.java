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
import com.github.nilankamanoj.system.model.Department;
import com.github.nilankamanoj.system.service.DepartmentService;

@Controller
@RequestMapping(path = "/department")
public class DepartmentController{
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Department> departments = departmentService.findAll();
		return new ResponseEntity<>(departments, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Department department = departmentService.findOne(id);
		return new ResponseEntity<>(department, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Department department) {
		Department newDepartment = departmentService.save(department);
		return new ResponseEntity<>( newDepartment, HttpStatus.OK);
	}
}