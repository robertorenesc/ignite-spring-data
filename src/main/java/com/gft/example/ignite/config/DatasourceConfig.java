package com.gft.example.ignite.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.gft.example.ignite.repository")
@EntityScan("com.gft.example.ignite.model")
@Configuration
public class DatasourceConfig {

}
