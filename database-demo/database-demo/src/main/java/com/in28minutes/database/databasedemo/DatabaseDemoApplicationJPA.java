package com.in28minutes.database.databasedemo;






import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class DatabaseDemoApplicationJPA  implements CommandLineRunner{

	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository jpaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplicationJPA.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("user id data data => {}",jpaRepository	.findById(10001));
		
		 
		  logger.info("Inserting 10004 -> {}", jpaRepository.insert(new Person("Tara",
		  "Berlin", new Date())));
		  
		  logger.info("Update 10003 -> {}", jpaRepository.update(new Person(10003, "Pieter",
		  "Utrecht", new Date())));
		  
		  logger.info("insert  -> {}", jpaRepository.insert(new Person( "Nishant",
		  "india", new Date())));
		
		/*
		 * logger.info("all data => {}",dao.findAll());
		 * logger.info("user id data delete => {}",dao.deleteById(10001));
		 * 
		 * logger.info("Inserting 10004 -> {}", dao.insert(new Person(10004, "Tara",
		 * "Berlin", new Date())));
		 * 
		 * logger.info("Update 10003 -> {}", dao.update(new Person(10003, "Pieter",
		 * "Utrecht", new Date())));
		 */
		
	}

}
