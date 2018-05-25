package com.gft.tutorials.ignite.model;

import java.io.Serializable;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person implements Serializable {

	private static final long serialVersionUID = 1761973086978863145L;

	@QuerySqlField(index = true)
	private Long id;
	
	@QuerySqlField(index = true)
	private Long firstName;
	
	@QuerySqlField(index = true)
	private Long lastName;
	
	private Integer age;
	
}
