package com.skilldistillery.jets.entities;

public class FighterPlane extends Jet implements CombatReady{

	public FighterPlane(String type, String model, int speed, int range, double price) {
		super(type, model, speed, range, price);
	}
	
public void fight() {
	
	System.out.println("LOADING MISS-ILES!!!!");
		
	}
	
}
