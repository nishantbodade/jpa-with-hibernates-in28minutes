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
import com.in28minutes.jpa.hibernate.demo.entity.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class )
class JPQLTest {
	private Logger logger=LoggerFactory.getLogger(this.getClass()); 
	@Autowired
	EntityManager em;

	@Test
	void jpql_basic() {

		Query query = em.createNamedQuery("query_get_allcourses");
		List list=query.getResultList();
		logger.info(list.toString());

	}
	
	@Test
	void jpql_typed() {
		TypedQuery<Employee> query = em.createNamedQuery("query_get_allcourses",Employee.class);
		List<Employee> list= query.getResultList();
		logger.info(list.toString());
	}
	
	@Test
	void jpql_where() {
		TypedQuery<Employee> query = em.createNamedQuery("query_get_JPA",Employee.class);
		List<Employee> list= query.getResultList();
		logger.info(list.toString());
	}
	

}
