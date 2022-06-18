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
import com.in28minutes.jpa.hibernate.demo.entity.Review;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class )
class CourserepositoryTest {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;

	@Test
	void findById_basic() {
		
		Employee course=repository.findById(10001L);
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
		Employee course=repository.findById(10001L);
		assertEquals("JPA demo", course.getName());
		
		//update details
		course.setName("JPA UPDATE");
		repository.save(course);
		
		//check value
		
		Employee course2=repository.findById(10001L);
		assertEquals("JPA UPDATE", course.getName());
		
		
		
	}
	
	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}
	
	@Test
	@Transactional
	public void retriveReviewForCorse() {
		Employee course=repository.findById(10001L);
	//	logger.info("{}",course.getReviews());
	}
	
	@Test
	@Transactional
	public void retriveCourseForReview() {
		Review review=em.find(Review.class, 50001L);
		logger.info("{}",review.getCourse());
	}


}
