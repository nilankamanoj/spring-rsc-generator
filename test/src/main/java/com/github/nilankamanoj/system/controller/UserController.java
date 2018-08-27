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
import com.github.nilankamanoj.system.model.User;
import com.github.nilankamanoj.system.service.UserService;

@Controller
@RequestMapping(path = "/user")
public class UserController{
	@Autowired
	private UserService userService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<User> users = userService.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		User user = userService.findOne(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody User user) {
		User newUser = userService.save(user);
		return new ResponseEntity<>( newUser, HttpStatus.OK);
	}
}