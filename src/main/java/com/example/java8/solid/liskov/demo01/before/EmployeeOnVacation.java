package com.example.java8.solid.liskov.demo01.before;

public class EmployeeOnVacation extends Employee {

	public EmployeeOnVacation(String name) {
		super(name);
	}

	public void work() {
		throw new IllegalArgumentException("Employees on vacation should not work");
	}
}

