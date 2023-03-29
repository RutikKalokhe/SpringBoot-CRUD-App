package com.example.firstproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "persons")
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotBlank
	private String name;
	
	

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	public void setId(int id) {
		this.id = id;
	}
}
