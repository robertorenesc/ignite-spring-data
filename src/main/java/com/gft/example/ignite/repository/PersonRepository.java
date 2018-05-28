package com.gft.example.ignite.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gft.example.ignite.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	List<Person> findByFirstName(String firstName);
	
	List<Person> findByAge(Integer age);
	
	List<Person> findByUpdateTsAfter(Date date);
	
	Person getBySsNumber(String ssNumber);
	
}
