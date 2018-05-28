package com.gft.example.ignite.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gft.example.ignite.cache.PersonIgniteRepository;
import com.gft.example.ignite.model.Person;
import com.gft.example.ignite.model.PersonIgnite;
import com.gft.example.ignite.repository.PersonRepository;

@Service
public class PersonService {
	
	private PersonRepository personRepository;
	
	private PersonIgniteRepository personIgniteRepository;
	
	@Autowired
	public PersonService(PersonRepository personRepository, PersonIgniteRepository personIgniteRepository) {
		this.personRepository = personRepository;
		this.personIgniteRepository = personIgniteRepository;
	}

	// Database operations
	
	public List<Person> listPersons() {
		return personRepository.findAll();
	}
	
	public List<Person> findUpdatedPersons(Date date) {
		return personRepository.findByUpdateTsAfter(date);
	}
	
	public List<Person> findByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}
	
	public List<Person> findByAge(Integer age) {
		return personRepository.findByAge(age);
	}
	
	public Person findBySsNumber(String ssNumber) {
		return personRepository.getBySsNumber(ssNumber);
	}
	
	// Ignite operations
	
	public List<PersonIgnite> listPersonsFromCache() {
		return StreamSupport.stream(personIgniteRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
	}
	
	public List<PersonIgnite> findByFirstNameFromCache(String firstName) {
		return personIgniteRepository.findByFirstName(firstName);
	}
	
	public List<PersonIgnite> findByAgeFromCache(Integer age) {
		return personIgniteRepository.findByAge(age);
	}
	
	public PersonIgnite findBySsNumberFromCache(String ssNumber) {
		return personIgniteRepository.getBySsNumber(ssNumber);
	}
	
}
