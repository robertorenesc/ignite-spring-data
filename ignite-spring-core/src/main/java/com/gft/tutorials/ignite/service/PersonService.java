package com.gft.tutorials.ignite.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.tutorials.ignite.model.Person;
import com.gft.tutorials.ignite.repository.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}	
	
	public List<Person> listPersons() {
		return StreamSupport.stream(personRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
	}

}
