package com.gft.example.ignite.component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.gft.example.ignite.cache.PersonIgniteRepository;
import com.gft.example.ignite.model.Person;
import com.gft.example.ignite.model.PersonIgnite;
import com.gft.example.ignite.service.PersonService;

@Component
public class SyncPersonsComponent {

	private static final Logger log = LoggerFactory.getLogger(SyncPersonsComponent.class);
	
	private static Date lastSync = null;
	
	private static Boolean syncInProgress;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private PersonIgniteRepository personsIgniteRepository;
	
	static {
		syncInProgress = Boolean.FALSE;
	}
	
	@Scheduled(fixedRate = 30000, initialDelay = 5000)
	public void syncPersons() {
		if(syncInProgress) {
			return;
		}
		syncInProgress = Boolean.TRUE;
		
		if(lastSync == null) {
			lastSync = getInitialDate();
		}
		
		log.info("--------------------------------------------------------------------");
		log.info(" Start synchronization of new records: " + lastSync);
		
		List<Person> persons = personService.findUpdatedPersons(lastSync);
		log.info(" ---> " + persons.size() + " new records found...");
		persons.forEach(p -> {
			personsIgniteRepository.save(p.getId(), new PersonIgnite(p.getId(), p.getSsNumber(), p.getFirstName(), p.getLastName(), p.getAge(), p.getUpdateTs()));
		});
		lastSync = new Date();
		
		log.info(" ---> Synchronization  finished succesfully!");
		log.info("--------------------------------------------------------------------");
		syncInProgress = Boolean.FALSE;
	}
	
	private Date getInitialDate() {
		try {
			return (new SimpleDateFormat("yyyy-MM-dd")).parse("1990-01-01");
		} catch (Exception e) {
			return new Date();
		}
	}
	
}
