package com.example.java8.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.example.java8.springcore.assignment.implementation",
            "com.example.java8.springcore.assignment.services"})
@ComponentScan(basePackageClasses = {com.example.java8.springcore.assignment.beans.Vehicle.class,
		com.example.java8.springcore.assignment.beans.Person.class})
public class MyConfig {

//	@Bean
//	Vehicle vehicle1() {
//		return new Vehicle("honda 1");
//	}
//	
//	@Bean
//	Vehicle vehicle2() {
//		return new Vehicle("honda 2");
//	}
//	
//	@Bean
//	Vehicle vehicle3() {
//		return new Vehicle("honda 3");
//	}
	
//	@Bean
//	@Primary
//	Employee employee(Vehicle vehicle) {
//		Employee emp = new Employee("dev");
//		emp.setVehicle(vehicle);
//		return emp;
//	}
//	
//	@Bean(name = "anotherEmployee")
//	Employee employee1() {
//		Employee emp = new Employee("test");
//		emp.setVehicle(vehicle());
//		return emp;
//	}
	
//	@Bean
//	@Primary
//	Person person() {
//		return new Person(1, "test", "", "", "", 15);
//	}
//	
//	@Bean
//	Person person1() {
//		return new Person(1, "test1", "", "", "", 15);
//	}
//	
//	@Bean(value = "person2Bean")
//	Person person2() {
//		return new Person(1, "test2", "", "", "", 15);
//	}
//	
//	@Bean
//	String hello() {
//		return "hello bean";
//	}
//	
//	@Bean
//	Integer number() {
//		return 16;
//	}
}

