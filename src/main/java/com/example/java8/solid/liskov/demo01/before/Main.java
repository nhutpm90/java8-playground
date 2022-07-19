package com.example.java8.solid.liskov.demo01.before;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Employee> employees = new ArrayList<>();
		employees.add(new EmployeeOnVacation("aaa"));
		employees.add(new Employee("bbb"));

		Project project = new Project();
		project.start(employees);
	}
}

