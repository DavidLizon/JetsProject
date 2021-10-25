package com.skilldistillery.jets.app;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.skilldistillery.jets.entities.AirField;

public class JetsApplication {

	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication jetApp = new JetsApplication();
		jetApp.launch();
	}

	private void launch() {

		AirField field = new AirField();
		// Generates AirField and loads with aircraft from txt file.
		System.out.println("Talk to me mother goose.\n");
		field.getField();

		userInteraction(field);

		System.out.println("\nYou broke my will, but what a thrill\n"
				+ "Goodness gracious, great balls of fire\nda na na na nah");
		cleanUp();
	}

	private void userInteraction(AirField field) {
		boolean continueProgram = true;
		int userChoice = 0;

		do {
			displayUserMenu();
			System.out.print("What option would youlike to select? ");
			
			boolean gotValidInput = false;
			while (!gotValidInput) {
				try {
					userChoice = kb.nextInt();
					if (userChoice > 0 || userChoice < 10) {
						gotValidInput = true;
						kb.nextLine();
						break;
					} else {
						System.out.println("\nThat input was incorrect. Please enter a number form the list:\n");
					}
				} catch (InputMismatchException e) {
					System.out.println("\nThat input was incorrect. Please enter a number form the list:\n");
					displayUserMenu();
					kb.nextLine();
				}
				
			}
			continueProgram = switchStatement(userChoice, field, continueProgram);

		} while (continueProgram == true);
	}

	private boolean switchStatement(int userChoice, AirField field, boolean continueProgram) {

		switch (userChoice) {
		case 1: // list fleet
			field.displayJets();
			System.out.println("Nice lookin' fleet ya' have there.");
			System.out.println();
			break;
		case 2: // fly all jets
			System.out.println("\nSorry Goose, but it's time to buzz the Tower.");
			field.flyAllJets();
			break;
		case 3: // view fastest jet
			System.out.println("\nI feel the need… The need for speed!!!");
			field.findFastestJet();
			break;
		case 4: // view jet with longest range
			field.findLongestRange();
			System.out.println("You can be my wingman any time\n");
			break;
		case 5: // load all cargo jets
			System.out.println("\nLooks like we're flying a load out of Hong Kong");
			field.loadCargoJets();
			break;
		case 6: // dog fight!
			field.sendTheFighters();
			System.out.println("FIRE THE MISS-ILES!!!!");
			System.out.println("But I'm le tired..");
			System.out.println(".....");
			System.out.println("Well, take a nap and then FIRE THE MISS-ILES!!!!\n");
			break;
		case 7: // add a jet to fleet
			System.out.println("\nWe're writing checks our body can't cash...");
			userAddJet(field);
			break;
		case 8: // remove a jet from fleet
			userRemoveJet(field);
			break;
		case 9: // quit
			continueProgram = false;
			break;
		default:
			System.out.println("That was not an option. Please choose a number from the options provided.");
		}

		return continueProgram;
	}

	private void userRemoveJet(AirField field) {
		field.displayJets();
		System.out.print("Enter the number of the jet you like to remove: ");
		int numToRemove = kb.nextInt() - 1;
		kb.nextLine(); // clears return char
		System.out.println("\nSad to see that one get turned into a paperwieght...");
		field.removeJet(numToRemove);
		field.displayJets();
	}

	private void userAddJet(AirField field) {
		int speed = 0;
		int range = 0;
		long price = 0;
		boolean ValidInput = false;

		System.out.print("\nWhat type of jet are we adding? (Cargo, Fighter, Default, or a Custom jet?)" +
				"\nIf custom, enter the type: ");
		String type = kb.nextLine();
		System.out.print("What model is it? ");
		String model = kb.nextLine();
		System.out.print("How about the top speed? ");

		speed = errorCatchIntExpectedJet(speed);

		System.out.print("The range? ");
		range = errorCatchIntExpectedJet(range);

		System.out.print("And the cost? ");
		while (!ValidInput) {
			try {
				price = kb.nextLong();
				kb.nextLine();
				if (price >= 0) {
					ValidInput = true;
					break;
				} else {
					System.out.print("Enter a whole number equal to or above 0. ");
				}
			} catch (InputMismatchException e) {
				System.out.print("Enter a whole number equal to or above 0. ");
				kb.nextLine();
			}
		}

		field.setJet(type, model, speed, range, price);

		System.out.println();
		field.displayJets();
	}

	public int errorCatchIntExpectedJet(int attribute) {
		boolean gotValidInput = false;

		while (!gotValidInput) {
			try {
				attribute = kb.nextInt();
				if (attribute > 0) {
					gotValidInput = true;
					kb.nextLine();
					break;
				} else {
					System.out.print("Please enter a whole number above 0. ");
				}
			} catch (InputMismatchException e) {
				System.out.print("Please enter a whole number above 0. ");
				kb.nextLine();
			}
		}
		return attribute;
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
