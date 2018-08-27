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
import com.github.nilankamanoj.system.model.Field;
import com.github.nilankamanoj.system.service.FieldService;

@Controller
@RequestMapping(path = "/field")
public class FieldController{
	@Autowired
	private FieldService fieldService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Field> fields = fieldService.findAll();
		return new ResponseEntity<>(fields, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Field field = fieldService.findOne(id);
		return new ResponseEntity<>(field, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Field field) {
		Field newField = fieldService.save(field);
		return new ResponseEntity<>( newField, HttpStatus.OK);
	}
}