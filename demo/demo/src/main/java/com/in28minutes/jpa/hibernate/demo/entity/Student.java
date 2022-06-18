package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Passport passport; 

	@ManyToMany
	@JoinTable(name="STUDENT_COURSE",
			   joinColumns=@JoinColumn(name="STUDENT_ID"),
			   inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	List<Employee> courses=new ArrayList<Employee>();
	
	protected Student() {
	}

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}
	
	

	public List<Employee> getCourses() {
		return courses;
	}

	public void addCourses(Employee courses) {
		this.courses.add(courses);
	}

	@Override
	public String toString() {
		return String.format("Student[%s]", name);
	}
	
	
	
	
	
	
}
