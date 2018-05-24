package com.gft.tutorials.ignite.repositories;

import java.util.List;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

import com.gft.tutorials.ignite.model.Person;

@RepositoryConfig(cacheName = "PersonCache")
public interface PersonRepository extends IgniteRepository<Person, Long> {

	Person getPersonById(Long id);
	
	List<Person> findByFirstName(String name);
	
	List<Person> findByLastName(String name);
	
}
