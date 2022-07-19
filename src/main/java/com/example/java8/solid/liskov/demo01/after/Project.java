package com.example.java8.solid.liskov.demo01.after;

import java.util.List;

public class Project {

	public void start(List<WorkingEmployee> employees) {
		employees.forEach(item -> item.work());
	}
}