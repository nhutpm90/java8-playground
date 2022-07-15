package com.example.java8.springcore.assignment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.java8.springcore.assignment.interfaces.Speakers;
import com.example.java8.springcore.assignment.interfaces.Tyres;

@Component
public class VehicleServices {

	@Autowired
	private Speakers speakers;
	private Tyres tyres;

	public void playMusic() {
		String music = speakers.makeSound();
		System.out.println(music);
	}

	public void moveVehicle() {
		String status = tyres.rotate();
		System.out.println(status);
	}

	public Speakers getSpeakers() {
		return speakers;
	}

	public void setSpeakers(Speakers speakers) {
		this.speakers = speakers;
	}

	public Tyres getTyres() {
		return tyres;
	}

	@Autowired
	public void setTyres(Tyres tyres) {
		this.tyres = tyres;
	}
}