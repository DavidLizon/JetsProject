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

		AirField field = new AirField();
		// Generates AirField and loads with aircraft from file.
		field.getField();

		userInteraction(field);

//		field.removeJet();
//		field.displayJets();
		System.out.println("PROGRAM ENDED!!!!");
		cleanUp();
	}

	private void userInteraction(AirField field) {
		boolean continueProgram = true;
		int userChoice;

		do {
			displayUserMenu();
			System.out.print("Which option would you like to select? ");
			userChoice = kb.nextInt();
			kb.nextLine(); // Clear return char
			continueProgram = switchStatement(userChoice, field, continueProgram);

		} while (continueProgram == true);
	}

	private boolean switchStatement(int userChoice, AirField field, boolean continueProgram) {

		switch (userChoice) {
		case 1: // list fleet
			field.displayJets();
			System.out.println();
			break;
		case 2: // fly all jets
			break;
		case 3: // view fastest jet
			break;
		case 4: // view jet with longest range
			break;
		case 5: // load all cargo jets
			break;
		case 6: // dog fight!
			break;
		case 7: // add a jet to fleet
			userInputJet(field);
			break;
		case 8: // remove a jet from fleet
			break;
		case 9: // quit
			continueProgram = false;
			break;
		default:

		}

		return continueProgram;
	}

	private void userInputJet(AirField field) {
		System.out.println("Thanks for adding a jet to the airfield!");
		System.out.print("What type of plane are you adding? (Cargo, Fighter, or Default) ");
		String type = kb.nextLine();
		System.out.print("What model of plane are you adding? ");
		String model = kb.nextLine();
		System.out.print("What is the top speed? ");
		int speed = kb.nextInt();
		kb.nextLine();
		System.out.print("What is the max range? ");
		int range = kb.nextInt();
		kb.nextLine();
		System.out.print("What is the cost? ");
		int price = kb.nextInt();
		kb.nextLine();

		field.setJet(type, model, speed, range, price);

	}

	private void displayUserMenu() {
		System.out.println("1: List fleet\n" + "2: Fly all jets\n" + "3: View fastest jet\n"
				+ "4: View jet with longest range\n" + "5: Load all Cargo Jets\n" + "6: Dogfight!\n"
				+ "7: Add a jet to Fleet\n" + "8: Remove a jet from Fleet\n" + "9: Quit");
	}

	private void cleanUp() {
		kb.close();
	}

}
