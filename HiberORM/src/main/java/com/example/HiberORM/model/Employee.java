package com.example.HiberORM.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//ctrl+shift+O -- shortcut key to import all the packages at once
@Entity
public class Employee {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  
    private String name;
    @Column(unique=true)
    private String email;
    
    //No Args based Constructor
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Args based Constructor
	public Employee(Long id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	//Args based Constructor
	public Employee(String name, String email) {
		super();
		this.name = name;
	    this.email = email;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
	}
    
	

}