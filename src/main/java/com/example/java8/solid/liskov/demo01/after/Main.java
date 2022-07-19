package com.example.java8.solid.liskov.demo01.after;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<WorkingEmployee> employees = new ArrayList<>();
		employees.add(new WorkingEmployeeImpl("aaa"));
		employees.add(new WorkingEmployeeImpl("bbb"));
		
		Project project = new Project();
		project.start(employees);
	}
}

