package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AirField {

	private List<Jet> jets = new ArrayList<>();

	private void readFromFile() {
		String fileName = "jets.txt";

		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
//				System.out.println(line);
				String[] jetInfo = line.split(",");
				String type = jetInfo[0];
				String model = jetInfo[1];
				int speed = Integer.parseInt(jetInfo[2]);
				int range = Integer.parseInt(jetInfo[3]);
				double price = Double.parseDouble(jetInfo[4]);

				if (type.equals("Fighter")) {
					Jet newJet = new FighterPlane(type, model, speed, range, price);
					jets.add(newJet);
				} else if (type.equals("Cargo")) {
					Jet newJet = new CargoPlane(type, model, speed, range, price);
					jets.add(newJet);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void getField() {
		readFromFile();
	}

	public void displayJets() {
		// REMOVE BEFORE SUMITTING ======================================================================================================================
		System.out.println(jets.size());

		Iterator<Jet> it = jets.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void setJet(String type, String model, int speed, int range, double price) {
		BasicPlane basicPlane = new BasicPlane(type, model, speed, range, price);
		basicPlane.getNewPlane();
//		Jet newJet = new CargoPlane("Cargo", "To-Mater", 150, 300, 100000);
		jets.add(basicPlane);
	}

	public void removeJet() {
		Jet newJet = new CargoPlane("Cargo", "To-Mater", 150, 300, 100000);
		jets.remove(5);
	}
}


////	 DELETE USED FOR TESTING
//	public static void main(String[] args) {
//		AirField af = new AirField();
//
//		af.readFromFile();
//		af.displayJets();
//
//		af.addJet();
//		af.displayJets();
//		
//		af.removeJet();
//		af.displayJets();
//		
//
//	}
