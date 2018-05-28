package com.gft.example.ignite.config;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gft.example.ignite.model.PersonIgnite;

@Configuration
@EnableIgniteRepositories(basePackages = {"com.gft.example.ignite.cache"})
public class IgniteConfig {
	
	@Bean
	public Ignite igniteInstance() {
		IgniteConfiguration config = new IgniteConfiguration();
		config.setIgniteInstanceName("igniteNode-1");
		config.setPeerClassLoadingEnabled(true);
		config.setActiveOnStart(true);
		
		CacheConfiguration<Long, PersonIgnite> personCache = new CacheConfiguration<>("PersonCache");
		personCache.setIndexedTypes(Long.class, PersonIgnite.class);
		config.setCacheConfiguration(new CacheConfiguration[] { personCache });
		
        return Ignition.start(config);
	}

}
