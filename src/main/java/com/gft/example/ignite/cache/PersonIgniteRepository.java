package com.gft.example.ignite.cache;

import java.util.List;

import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

import com.gft.example.ignite.model.PersonIgnite;

@RepositoryConfig(cacheName = "PersonCache")
public interface PersonIgniteRepository extends IgniteRepository<PersonIgnite, Long> {

	List<PersonIgnite> findByFirstName(String firstName);
	
	List<PersonIgnite> findByAge(Integer age);
	
	PersonIgnite getBySsNumber(String ssNumber);
	
}
