package com.example.java8.solid.liskov.demo01.before;

import java.util.List;

public class Project {

	public void start(List<Employee> employees) {
		employees.forEach(item -> item.work());
	}
}

