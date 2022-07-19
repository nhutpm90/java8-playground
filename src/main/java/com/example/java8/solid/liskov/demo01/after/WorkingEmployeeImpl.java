package com.example.java8.solid.liskov.demo01.after;

public class WorkingEmployeeImpl extends Employee implements WorkingEmployee {

	public WorkingEmployeeImpl(String name) {
		super(name);
	}

	@Override
	public void work() {
		System.out.println(name + " is working");
	}
}

