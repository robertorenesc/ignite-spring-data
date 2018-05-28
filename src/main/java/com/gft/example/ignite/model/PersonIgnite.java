package com.gft.example.ignite.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PersonIgnite implements Serializable {

	private static final long serialVersionUID = 1977350922263189339L;

	@QuerySqlField(index = true)
	private Long id;
	
	@QuerySqlField(index = true)
	private String ssNumber;
	
	@QuerySqlField(index = true)
	private String firstName;
	
	@QuerySqlField(index = true)
	private String lastName;
	
	@QuerySqlField(index = true)
	private Integer age;
	
	@QuerySqlField(index = true)
	private Date updateTs;
	
}
