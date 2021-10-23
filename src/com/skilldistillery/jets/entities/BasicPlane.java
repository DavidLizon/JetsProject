package com.skilldistillery.jets.entities;

public class BasicPlane extends Jet	{

	public BasicPlane(String type, String model, int speed, int range, double price) {
		super(type, model, speed, range, price);
	}

	Jet newPlane;

	public Jet getNewPlane() {
		return newPlane;
	}

	public void setNewPlane(Jet newPlane) {
		this.newPlane = newPlane;
	}

}
