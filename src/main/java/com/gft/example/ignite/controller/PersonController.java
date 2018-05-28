package com.gft.example.ignite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.example.ignite.service.PersonService;

@RestController
@RequestMapping("/persons")
public class PersonController {

	private PersonService personService;
	
	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	// Database operations
	
	@GetMapping("/list")
	public ResponseEntity<?> getPersons() {
		return new ResponseEntity<>(personService.listPersons(), HttpStatus.OK);
	}
	
	@GetMapping("/list/{age}")
	public ResponseEntity<?> getPersonsByAge(@PathVariable Integer age) {
		return new ResponseEntity<>(personService.findByAge(age), HttpStatus.OK);
	}
	
	@GetMapping("/{ssNumber}")
	public ResponseEntity<?> getPersonBySsNumber(@PathVariable String ssNumber) {
		return new ResponseEntity<>(personService.findBySsNumber(ssNumber), HttpStatus.OK);
	}
	
	// Ignite operations
	
	@GetMapping("/cache/list")
	public ResponseEntity<?> getPersonsFromCache() {
		return new ResponseEntity<>(personService.listPersonsFromCache(), HttpStatus.OK);
	}
	
	@GetMapping("/cache/list/{age}")
	public ResponseEntity<?> getPersonsByAgeFromCache(@PathVariable Integer age) {
		return new ResponseEntity<>(personService.findByAgeFromCache(age), HttpStatus.OK);
	}
	
	@GetMapping("/cache/{ssNumber}")
	public ResponseEntity<?> getPersonBySsNumberFromCache(@PathVariable String ssNumber) {
		return new ResponseEntity<>(personService.findBySsNumberFromCache(ssNumber), HttpStatus.OK);
	}
	
}