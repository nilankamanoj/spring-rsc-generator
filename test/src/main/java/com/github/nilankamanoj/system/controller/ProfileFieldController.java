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
import com.github.nilankamanoj.system.model.ProfileField;
import com.github.nilankamanoj.system.service.ProfileFieldService;

@Controller
@RequestMapping(path = "/profileField")
public class ProfileFieldController{
	@Autowired
	private ProfileFieldService profileFieldService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<ProfileField> profileFields = profileFieldService.findAll();
		return new ResponseEntity<>(profileFields, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		ProfileField profileField = profileFieldService.findOne(id);
		return new ResponseEntity<>(profileField, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody ProfileField profileField) {
		ProfileField newProfileField = profileFieldService.save(profileField);
		return new ResponseEntity<>( newProfileField, HttpStatus.OK);
	}
}