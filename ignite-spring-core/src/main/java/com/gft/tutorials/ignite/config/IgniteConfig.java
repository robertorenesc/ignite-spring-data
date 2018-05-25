package com.gft.tutorials.ignite.config;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gft.tutorials.ignite.model.Person;

@Configuration
public class IgniteConfig {

	// @Autowired
	// private DataSource datasource;
	
	@Bean
	public Ignite igniteInstance() {
		IgniteConfiguration cfg = new IgniteConfiguration();
		cfg.setIgniteInstanceName("igniteNode-1");
		
		cfg.setPeerClassLoadingEnabled(true);
		CacheConfiguration<Long, Person> personCache = new CacheConfiguration<>("PersonCache");
		personCache.setIndexedTypes(Long.class, Person.class);
		
		cfg.setCacheConfiguration(new CacheConfiguration[] { personCache });
		return Ignition.start(cfg);
	}

}
