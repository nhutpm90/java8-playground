package com.example.java8.entity;

public class Employee {

	private String name = "dev";

	private Vehicle vehicle;

	public Employee(Vehicle vehicle) {
		System.out.print("creating employeeBean::");
		this.vehicle = vehicle;
	}
	
	public Employee() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", vehicle=" + vehicle + "]";
	}

}
