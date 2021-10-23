package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {

	private List<Jet> jets = new ArrayList<>();

	private void readFromFile() {
		String fileName = "jets.txt";

		try (BufferedReader bufIn = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
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

	// Accessible from JetsApplication to generate planes from file
	public void getField() {
		readFromFile();
	}

	public void displayJets() {
//		int i = 1;
//		Iterator<Jet> it = jets.iterator();
//		while (it.hasNext()) {
//			System.out.print(i + ": ");
//			System.out.println(it.next());
//			i++;
//	}

		System.out.println();
		for (int i = 0; i < jets.size(); i++) {
			System.out.println((i + 1) + ": " + jets.get(i));
		}
		System.out.println();

	}

	public void setJet(String type, String model, int speed, int range, double price) {
		Jet basicPlane = new BasicPlane(type, model, speed, range, price);
		((BasicPlane) basicPlane).getNewPlane();
		jets.add(basicPlane);
	}

	public void removeJet(int number) {
		jets.remove(number);
	}

	public void findFastestJet() {
		Jet fastest = jets.get(0);
		int fast = jets.get(0).getSpeed();
		int arrSize = jets.size();

		for (int i = 0; i < jets.size(); i++) {
			int arrInFor = jets.size();
			if (fast < jets.get(i).getSpeed()) {
				fast = jets.get(i).getSpeed();
				fastest = jets.get(i);
			}
		}
		System.out.println("\nThe fastest jet is:\n" + fastest + "\n");
	}

	public void findLongestRange() {
		Jet longestRange = jets.get(0);
		int range = jets.get(0).getRange();

		for (int i = 0; i < jets.size(); i++) {
			if (range < jets.get(i).getRange()) {
				longestRange = jets.get(i);
			}
		}

		System.out.println("\nThe jet with the longest range is: " + longestRange + "\n");

	}

}
