package com.example.java8.solid.liskov.demo01.before;

public class Employee {

	private String name;

	public Employee(String name) {
		this.name = name;
	}

	public void work() {
		System.out.println(name + " is working");
	}
}
