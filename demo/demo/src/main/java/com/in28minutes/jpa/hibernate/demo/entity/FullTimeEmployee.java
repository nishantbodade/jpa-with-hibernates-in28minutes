package com.in28minutes.jpa.hibernate.demo.entity;

import java.math.BigDecimal;

public class FullTimeEmployee extends Employee{
	
	private BigDecimal salary;
	
	protected FullTimeEmployee() {
		
	}

	public FullTimeEmployee(String  name,BigDecimal salary) {
		super(name);
		this.salary = salary;
	}
	
	

}
