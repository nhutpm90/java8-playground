package com.example.java8.entity;

public class Vehicle {

	private String name = "honda";

	private Employee employee;

	public Vehicle() {
		super();
	}

//	public Vehicle(String name) {
//		super();
//		this.name = name;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Vehicle [name=" + name + "]";
	}

}
