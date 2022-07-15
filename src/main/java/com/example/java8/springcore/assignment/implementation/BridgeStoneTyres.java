package com.example.java8.springcore.assignment.implementation;

import org.springframework.stereotype.Component;

import com.example.java8.springcore.assignment.interfaces.Tyres;

@Component
public class BridgeStoneTyres implements Tyres {

	public String rotate() {
		return "Vehicle moving with BridgeStone tyres";
	}
}
