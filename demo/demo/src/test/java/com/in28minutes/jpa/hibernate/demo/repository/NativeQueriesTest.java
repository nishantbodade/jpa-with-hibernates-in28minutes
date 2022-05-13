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
import org.springframework.transaction.annotation.Transactional;

import com.in28minutes.jpa.hibernate.demo.DemoApplication;
import com.in28minutes.jpa.hibernate.demo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class )
class NativeQueriesTest {
	private Logger logger=LoggerFactory.getLogger(this.getClass()); 
	@Autowired
	EntityManager em;

	@Test
	void nativequeries_basic() {

		Query query = em.createNativeQuery("select * from course",Course.class);
		List list=query.getResultList();
		logger.info(list.toString());

	}

	@Test
	void nativequeries_with_parameter() {

		Query query = em.createNativeQuery("select * from course where id=?",Course.class);
		query.setParameter(1, 10001L);
		List list=query.getResultList();
		logger.info(list.toString());

	}
	@Test
	void nativequeries_with_name_parameter() {

		Query query = em.createNativeQuery("select * from course where id=:id",Course.class);
		query.setParameter("id", 10001L);
		List list=query.getResultList();
		logger.info(list.toString());

	}
	@Test
	@Transactional
	void nativequeries_to_update() {

		Query query = em.createNativeQuery("Update course set last_updated_date=sysdate()");
		int no=query.executeUpdate();
		logger.info("no of rows updated ={}",no);

	}
}
