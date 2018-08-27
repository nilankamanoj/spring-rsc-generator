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
import com.github.nilankamanoj.system.model.Profile;
import com.github.nilankamanoj.system.service.ProfileService;

@Controller
@RequestMapping(path = "/profile")
public class ProfileController{
	@Autowired
	private ProfileService profileService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Profile> profiles = profileService.findAll();
		return new ResponseEntity<>(profiles, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Profile profile = profileService.findOne(id);
		return new ResponseEntity<>(profile, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Profile profile) {
		Profile newProfile = profileService.save(profile);
		return new ResponseEntity<>( newProfile, HttpStatus.OK);
	}
}