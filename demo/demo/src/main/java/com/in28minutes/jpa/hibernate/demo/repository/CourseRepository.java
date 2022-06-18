package com.in28minutes.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Employee;
import com.in28minutes.jpa.hibernate.demo.entity.Review;

@Repository
@Transactional
public class CourseRepository {
	Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	public Employee findById(long id) {
		return em.find(Employee.class, id);
	}
	
	public void deleteById(Long id) {
		Employee course=findById(id);
		em.remove(course);
	}
	
	public Employee save(Employee course) {
		
		if(course.getId()==null) {
			em.persist(course);
			
		}else {
			em.merge(course);
		}
		
		return course;
		
	}
	
	public void playWithEntityManager() {
		Employee course1 = new Employee("Web Services in 100 Steps");
		em.persist(course1);
		
		Employee course2=findById(10001L);
		course2.setName("JPA demo-updated");

	}

	public void addRevieworCourse() {
		// get the course 10003
		Employee course=findById(10003L);
		logger.info("course reviews {}",course.getReviews());
		
		//add 2 review to it
		Review review1=new Review("5", "Great hand-on stuff");
		Review review2=new Review("5", "Hatsoff");
		
		//setting the relationship
		course.addReviews(review1);
		review1.setCourse(course);
		
		course.addReviews(review2);
		review2.setCourse(course);
	
		//save it to database
		em.persist(review1);
		em.persist(review2);
		
	}

	public void addRevieworCourse(Long courseId,List<Review> reviews) {
		// get the course 10003
		Employee course=findById(courseId);
		logger.info("course reviews {}",course.getReviews());
		
		//add 2 review to it

		for(Review review1:reviews) {
			//setting the relationship
			course.addReviews(review1);
			review1.setCourse(course);
			//save it to database
			em.persist(review1);
			
		}


		
	}
}
