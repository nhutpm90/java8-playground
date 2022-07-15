package com.example.java8.springcore.assignment.implementation;

import org.springframework.stereotype.Component;

import com.example.java8.springcore.assignment.interfaces.Speakers;

@Component
public class BoseSpeakers implements Speakers {

	public String makeSound() {
		return "Playing music with Bose speakers";
	}

}