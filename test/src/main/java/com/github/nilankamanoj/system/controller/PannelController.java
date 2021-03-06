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
import com.github.nilankamanoj.system.model.Pannel;
import com.github.nilankamanoj.system.service.PannelService;

@Controller
@RequestMapping(path = "/pannel")
public class PannelController{
	@Autowired
	private PannelService pannelService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Pannel> pannels = pannelService.findAll();
		return new ResponseEntity<>(pannels, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Pannel pannel = pannelService.findOne(id);
		return new ResponseEntity<>(pannel, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Pannel pannel) {
		Pannel newPannel = pannelService.save(pannel);
		return new ResponseEntity<>( newPannel, HttpStatus.OK);
	}
}