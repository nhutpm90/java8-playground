package com.example.java8.solid.is.demo01.after;

public class JohnDoe implements SwimmingAthlete {

	@Override
	public void compete() {
		System.out.println("John Doe started competing");
	}

	@Override
	public void swim() {
		System.out.println("John Doe started swimming");
	}
}
