package com.gft.example.ignite.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
public class Person implements Serializable {

	private static final long serialVersionUID = 1761973086978863145L;

	@Id 
	@GeneratedValue
	private Long id;
	
	private String ssNumber;
	
	private String firstName;
	
	private String lastName;
	
	private Integer age;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTs;

}
