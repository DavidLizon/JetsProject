package com.skilldistillery.jets.entities;

public abstract class Jet {

	private String type;
	private String model;
	private int speed;
	private int range;
	private double price;

	public Jet(String type, String model, int speed, int range, double price) {
		this.type = type;
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	// Prints out the jet details and the amount of time the jet can fly until it
	// runs out of fuel (based on speed and range).
	public void fly() {
		double timeAbleToFly;
		timeAbleToFly = range / speed;
		System.out.println(toString() + timeAbleToFly );
	}

	public double getSpeedInMach(int speed) {
		double machNum = 767.269;
		machNum = this.speed / machNum;
		return machNum;
	}
	
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Jet Type: " + type + "\tModel: " + model + "\tSpeed: " + speed + "\tRange: " + range + "\tPrice: "
		+ price;
	}

	
	
//// prints out formatted output
//	@Override
//	public String toString() {
//		if (type.equals("Cargo")) {
//			return "Jet Type: " + type + "\t\tModel: " + model + "\t\tSpeed: " + speed + "\tRange: " + range
//					+ "\tPrice: " + price;
//		} else {
//			return "Jet Type: " + type + "\tModel: " + model + "\tSpeed: " + speed + "\tRange: " + range + "\tPrice: "
//					+ price;
//		}
//	}

}
