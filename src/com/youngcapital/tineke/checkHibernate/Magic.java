package com.youngcapital.tineke.checkHibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity
public class Magic {
	private Long id;
	private String name;
	private int count;
	private String tric;

	@Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
	public Long getId() {
		return id;
	}
	public Magic(){}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getTric() {
		return tric;
	}

	public void setTric(String tric) {
		this.tric = tric;
	}
}
