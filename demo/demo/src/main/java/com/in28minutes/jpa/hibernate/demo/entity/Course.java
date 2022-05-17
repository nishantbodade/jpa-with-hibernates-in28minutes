package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@NamedQueries(
		value = {
				@NamedQuery(name="query_get_allcourses",query = "select c from Course c"),
				@NamedQuery(name = "query_get_JPA",query = "select c from Course c where name like '%JPA%'")
				
		})
public class Course {

	@Id
	@GeneratedValue
	private Long id;
	

	private String name;
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@OneToMany(mappedBy = "course")
	List<Review> reviews=new ArrayList<Review>();
	
	@ManyToMany
	List<Student> students=new ArrayList<Student>();
	
	
		
	public Course() {
	}
	
	public Course(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReviews(Review reviews) {
		this.reviews.add(reviews);
	}
	
	public void removeReviews(Review reviews) {
		this.reviews.remove(reviews);
	}
	
	

	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student students) {
		this.students.add(students);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	
	
}
