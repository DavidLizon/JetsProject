package com.skilldistillery.jets.app;

import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {

	private AirField airField;
	private Scanner kb = new Scanner(System.in); 
	
	
	public static void main(String[] args) {

		JetsApplication jetApp = new JetsApplication();
		
		jetApp.launch();
	}

	private void launch() {
		
		displayUserMenu();
		AirField field = new AirField();
		
		

		field.getField();
		field.displayJets();

		field.setJet();
		field.displayJets();
		
		field.removeJet();
		field.displayJets();
		
	
	}
	
	private void displayUserMenu() {
	
		
		
	}
	
	
}
