package com.in28minutes.jpa.hibernate.demo.entity;

import java.math.BigDecimal;

public class PartTimeEmployee extends Employee{
	
	private BigDecimal hourlywage;
	
	protected PartTimeEmployee() {
		
	}

	public PartTimeEmployee(String  name,BigDecimal hourlywage) {
		super(name);
		this.hourlywage = hourlywage;
	}
	
	

}
