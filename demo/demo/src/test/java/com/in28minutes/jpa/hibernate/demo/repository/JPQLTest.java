package com.in28minutes.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class )
class JPQLTest {
	private Logger logger=LoggerFactory.getLogger(this.getClass()); 
	@Autowired
	EntityManager em;

	@Test
	void jpql_basic() {

		Query query = em.createQuery("select c from Course c");
		List list=query.getResultList();
		logger.info(list.toString());

	}
	
	@Test
	void jpql_typed() {
		TypedQuery<Course> query = em.createQuery("select c from Course c",Course.class);
		List<Course> list= query.getResultList();
		logger.info(list.toString());
	}
	
	@Test
	void jpql_where() {
		TypedQuery<Course> query = em.createQuery("select c from Course c where name like '%JPA%'",Course.class);
		List<Course> list= query.getResultList();
		logger.info(list.toString());
	}
	

}
