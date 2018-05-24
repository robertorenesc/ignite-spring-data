CREATE DATABASE ignite_spring;

USE ignite_spring;

CREATE TABLE person (
  	id int(11) NOT NULL AUTO_INCREMENT,
  	age int(11) DEFAULT NULL,
  	first_name varchar(255) NOT NULL,
  	last_name varchar(255) NOT NULL,
  	PRIMARY KEY (id)
);

INSERT INTO person(first_name, last_name, age) VALUES('Thomas','Edison',84);
INSERT INTO person(first_name, last_name, age) VALUES('Nicola','Tesla', 86);
INSERT INTO person(first_name, last_name, age) VALUES('James','Maxwell', 48);
INSERT INTO person(first_name, last_name, age) VALUES('Albert','Enstein', 76);
INSERT INTO person(first_name, last_name, age) VALUES('Stephen','Hawking', 76);