package com.skilldistillery.jets.entities;

public class FighterPlane extends Jet implements CombatReady {

	public FighterPlane(String type, String model, int speed, int range, long price) {
		super(type, model, speed, range, price);
	}

	public void fight() {
		System.out.println("LOADING THE MISS-ILES!!!!");
	}

	Jet newPlane;

	public Jet getNewPlane() {
		return newPlane;
	}

	public void setNewPlane(Jet newPlane) {
		this.newPlane = newPlane;
	}


}
