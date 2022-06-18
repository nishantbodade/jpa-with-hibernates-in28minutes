package com.in28minutes.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class Review {


	@Id
	@GeneratedValue
	private Long id;

	private String rating;

	private String description;
	
	@ManyToOne
	private Employee course;

	protected Review() {
	}

	public Review(String rating, String description) {
		this.rating = rating;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}
	

	public Employee getCourse() {
		return course;
	}

	public void setCourse(Employee course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return String.format("Review[%s %s]", rating, description);
	}


	
	
	
	
	
	
	
	
}
