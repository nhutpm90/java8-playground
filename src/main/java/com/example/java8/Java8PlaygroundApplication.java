package com.example.java8;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.java8.config.MyConfig;
import com.example.java8.entity.Employee;
import com.example.java8.entity.Person;
import com.example.java8.entity.Vehicle;

@SpringBootApplication
public class Java8PlaygroundApplication {

	public static void main(String[] args) {
		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//		Person personBean = context.getBean(Person.class);
//		System.out.println("\nperson bean:: " + personBean);
		
//		Person personBean = context.getBean("person2Bean", Person.class);
//		System.out.println("\nperson bean:: " + personBean);
		
//		Person personBean = context.getBean("person1", Person.class);
//		System.out.println("person bean:: " + personBean);
//		
//		String helloBean = context.getBean(String.class);
//		System.out.println("hello bean:: " + helloBean);
//		
//		Integer integerBean = context.getBean(Integer.class);
//		System.out.print("integer bean:: " + integerBean);
		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//		Vehicle vehicle = context.getBean(Vehicle.class);
//		System.out.println("vehicle bean name:: " + vehicle.getName());
//		
//		System.out.println("vehicle bean:: run:: " + vehicle.run());
//		context.close();
		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//		context.registerBean("employeeBean", Employee.class, () -> new Employee("dev"));
//		
//		Employee employee = null;
//		try {
//			employee = context.getBean("test", Employee.class);
//		} catch(NoSuchBeanDefinitionException ex) {
//			System.out.println("not found test bean");
//		}
//		
//		employee = context.getBean("employeeBean", Employee.class);
//		System.out.println("employeeBean:: " + employee);
		
//		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
//		Employee emp = context.getBean(Employee.class);
//		Vehicle vehicle1 = context.getBean("vehicle1", Vehicle.class);
		
		
//		System.out.println("employeeBean:: " + emp);
//		System.out.println("vehicleBean:: " + vehicle1);
		
//		Employee anotherEmp = context.getBean("anotherEmployee", Employee.class);
//		System.out.println("anotherEmployeeBean:: " + anotherEmp);
//		
//		vehicle.setName("yamaha");
//		System.out.println("after change vehicle name to yamaha");
//		System.out.println("employeeBean:: " + emp);
//		System.out.println("anotherEmployeeBean:: " + anotherEmp);
		SpringApplication.run(Java8PlaygroundApplication.class, args);
	}

}
