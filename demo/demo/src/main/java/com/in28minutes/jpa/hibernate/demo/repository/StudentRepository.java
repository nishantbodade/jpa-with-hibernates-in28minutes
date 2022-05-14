package com.in28minutes.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.entity.Passport;
import com.in28minutes.jpa.hibernate.demo.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	EntityManager em;
	
	public Student findById(long id) {
		return em.find(Student.class, id);
	}
	
	public void deleteById(Long id) {
		Student student=findById(id);
		em.remove(student);
	}
	
	public Student save(Student student) {
		
		if(student.getId()==null) {
			em.persist(student);
			
		}else {
			em.merge(student);
		}
		
		return student;
		
	}
	
	public void saveStudentWithPassport() {
		
		Passport passport=new Passport("EZ12345");
		
		em.persist(passport);
		
		Student student = new Student("Web Services in 100 Steps");
		
		student.setPassport(passport);
		em.persist(student);


	}

}
