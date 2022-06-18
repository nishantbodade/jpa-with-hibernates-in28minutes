package com.in28minutes.jpa.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.jpa.hibernate.demo.entity.Employee;
import com.in28minutes.jpa.hibernate.demo.entity.Review;
import com.in28minutes.jpa.hibernate.demo.entity.Student;
import com.in28minutes.jpa.hibernate.demo.repository.CourseRepository;
import com.in28minutes.jpa.hibernate.demo.repository.StudentRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//studentRepository.saveStudentWithPassport();
		//repository.playWithEntityManager();
		//courseRepository.addRevieworCourse();  //hard coded
//		List<Review> reviews=new ArrayList<Review>();
//		reviews.add(new Review("5", "Great hand-on stuff"));
//		reviews.add(new Review("5", "Hatsoff"));
//		
//		courseRepository.addRevieworCourse(10003L, reviews);
		

		//studentRepository.inserthardcodedStudentAndCourse();

		studentRepository.insertStudentAndCourse(new Student("jack"),new Employee("Microservice in 100 steps"));

	}

}
