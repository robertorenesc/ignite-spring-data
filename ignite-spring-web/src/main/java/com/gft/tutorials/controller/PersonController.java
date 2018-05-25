package com.gft.tutorials.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.tutorials.ignite.model.Person;

@RestController
@RequestMapping("/persons")
public class PersonController {

	@GetMapping("/list")
	public ResponseEntity<?> getPersons() {
		
		return new ResponseEntity<>(new Person(), HttpStatus.OK);
	}
	
}
