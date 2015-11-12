package com.youngcapital.tineke.form;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;


public class FormBean {
	@NotEmpty
	private String name;
	
	@Min(10)
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
