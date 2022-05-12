package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class )
class CourserepositoryTest {
	
	@Autowired
	CourseRepository repository;

	@Test
	void findById_basic() {
		
		Course course=repository.findById(10001L);
		assertEquals("JPA demo", course.getName());
		
	}
	
	@Test
	@DirtiesContext
	void deleteById_basic() {
		
		repository.deleteById(10001L);
		assertNull(repository.findById(10001L));
		
	}
	
	@Test
	@DirtiesContext
	void save_basic() {

		//get course
		Course course=repository.findById(10001L);
		assertEquals("JPA demo", course.getName());
		
		//update details
		course.setName("JPA UPDATE");
		repository.save(course);
		
		//check value
		
		Course course2=repository.findById(10001L);
		assertEquals("JPA UPDATE", course.getName());
		
		
		
	}

}
