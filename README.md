# spring-rsc-generator
Spring Repository-Service-Controller generator by model package

This will generate Repository, Controller and Service packages with basic support of **GET** and **POST** operations of models.
# Instructions
- create **model** package and all models inside the package.
- Copy-paste **generator.py** in to root derectory where **pom.xml** exists.
- Open terminal in the location and run :
```sh
python generator.py
```
- Program will ask related parameters that required to generate repository, Service and Controller.
- Input them and confirm.
# Generated Examples
- these classes generated **without** single line of coding.
## Repository
```java
package com.github.nilankamanoj.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.nilankamanoj.system.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}

```
## Service
```java
package com.github.nilankamanoj.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.nilankamanoj.system.model.Application;
import com.github.nilankamanoj.system.repository.ApplicationRepository;
import java.util.List;

@Service
public class ApplicationService {
	@Autowired
	private ApplicationRepository applicationRepository;

	public List<Application> findAll() {
		List<Application> applications = applicationRepository.findAll();
		return applications;
	}

	public Application findOne(Integer id) {
		Application application = applicationRepository.findOne(id);
		return application;
	}

	public Application save(Application application) {
		applicationRepository.save(application);
		Application newApplication = applicationRepository.findOne(application.getId());
		return newApplication;
	}

}
```
## Controller
```java
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
import com.github.nilankamanoj.system.model.Application;
import com.github.nilankamanoj.system.service.ApplicationService;

@Controller
@RequestMapping(path = "/application")
public class ApplicationController{
	@Autowired
	private ApplicationService applicationService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity<?> findAll() {
		List<Application> applications = applicationService.findAll();
		return new ResponseEntity<>(applications, HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable Integer id) {
		Application application = applicationService.findOne(id);
		return new ResponseEntity<>(application, HttpStatus.OK);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Application application) {
		Application newApplication = applicationService.save(application);
		return new ResponseEntity<>( newApplication, HttpStatus.OK);
	}
}
```
