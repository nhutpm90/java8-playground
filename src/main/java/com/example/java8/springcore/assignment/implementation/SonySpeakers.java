package com.example.java8.springcore.assignment.implementation;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.java8.springcore.assignment.interfaces.Speakers;

@Component
@Primary
public class SonySpeakers implements Speakers {

	public String makeSound() {
		return "Playing music with Sony speakers";
	}

}