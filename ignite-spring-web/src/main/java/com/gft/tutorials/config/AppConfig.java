package com.gft.tutorials.config;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gft.tutorials.ignite.model.Person;

@Configuration
@EnableIgniteRepositories
public class AppConfig {

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
