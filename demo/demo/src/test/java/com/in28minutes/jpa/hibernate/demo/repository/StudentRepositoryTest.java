package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Employee;
import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class )
class StudentRepositoryTest {
	
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	EntityManager em;

	@Test
	@Transactional
	void retriveStudentAndPassportDetails() {
		
	 Student student=em.find(Student.class , 20001L);
	 logger.info("student {}",student);
	 logger.info("passport {}",student.getPassport());

		
	}
	
	@Test
	@Transactional
	void retrivePassportAndStudentAssociateDetails() {
		
	 Passport passport=em.find(Passport.class , 40001L);
	 logger.info("passport {}",passport);
	 logger.info("Student {}",passport.getStudent());

		
	}

	}
