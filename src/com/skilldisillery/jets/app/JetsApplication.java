package com.skilldisillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import com.skilldisillery.jets.entity.AirField;
import com.skilldisillery.jets.entity.CargoPlane;
import com.skilldisillery.jets.entity.FighterJet;
import com.skilldisillery.jets.entity.Jet;
import com.skilldisillery.jets.entity.JetImpl;

public class JetsApplication {
	
	private AirField airField;
	private Scanner kb;
	
	public static void main(String[] args) {
	
		JetsApplication app = new JetsApplication();
		
		app.launch();

	}

	private void launch() {
		kb = new Scanner(System.in);
		airField = new AirField();
		int menuChoice = 0;
		
		buildAirField();
		
		printWelcomeHeader();
		do {			
			printMainMenu();
			
			menuChoice = intInputValidator(1);
			
			switchOnMenuChoice(menuChoice);
			
			pauseBeforeContinuing();
		} while (menuChoice != 9);
		
		fareWell();
		
		kb.close();
	}

	private void buildAirField() {
		BufferedReader file = null;
		
		try {
			file = new BufferedReader(new FileReader("jets.txt") );
			String line; //String variable to hold line read in from file
			while ((line = file.readLine()) != null) {
				String[] lineSplit = line.split(",");
				airField.addJet(createJet(lineSplit));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (file != null) {
				try {
					file.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		} // close brace finally
	}

	private Jet createJet(String[] lineSplit) {		
		String jetSubClass = lineSplit[0];
		String model = lineSplit[1];
		int speed = Integer.valueOf(lineSplit[2]);
		int range = Integer.valueOf(lineSplit[3]);
		double price = Double.valueOf(lineSplit[4]);
		
		if(jetSubClass.equals("JetImpl")) {
			JetImpl jet = new JetImpl(model, speed, range, price);
			return jet;
		} else if(jetSubClass.equals("FighterJet")) {
			FighterJet jet = new FighterJet(model, speed, range, price);			
			return jet;
		} else if(jetSubClass.equals("CargoPlane")) {
			CargoPlane jet = new CargoPlane(model, speed, range, price);	
			return jet;
		} else {
			Jet jet = null;
			return jet;
		}
		
	}

	private int switchOnMenuChoice(int menuChoice) {
		
		switch(menuChoice) {
			case 1:
				airField.displayFleet();
				break;
			case 2:
				airField.flyAllJets();
				break;
			case 3:
				airField.searchAndSetFastestJet();
				airField.printFastestJet();
				break;
			case 4:
				airField.searchAndSetLongestRangeJet();
				airField.printLongestRangeJet();
				break;
			case 5:
				airField.loadCargoPlanes();
				break;
			case 6:				
				airField.deployFighterJets();
				break;
			case 7:
				createJetSubMenu();
				break;
			case 8:
				jetRemovalSubMenu();
				break;
			case 9:
				fareWell();
				System.exit(0);
		}
		return menuChoice;
	}

	private void jetRemovalSubMenu() {
		System.out.println("\n------------------------------------------------------------------");
		System.out.println("                      -Jet Remova; Sub-Menu-");
		System.out.println("\nWhich jet would you like to remove?: ");
		System.out.println();
		
		List<Jet> jets = airField.getJets();
		
		int itr = 1;
		for (Jet jet : jets) {
			System.out.println(itr + ") " + jet.toString());
			itr++;
		}
		
		System.out.print("\nPlease enter your selection as a number: ");
		itr = intInputValidator(0);
		airField.removeJetFromFleet((itr - 1));
		System.out.println("\nJet " + itr + " removed. Action Complete.");
	}

	private void createJetSubMenu() {
		String[] jetInfo = new String[5];
		
		System.out.println("\n------------------------------------------------------------------");
		System.out.println("                      -Jet Creation Sub-Menu-");
		System.out.println("\nWhich type of jet would you like to create?: ");
		jetInfo[0] = chooseJetTypes();

		System.out.print("What is the jet model?: ");
		kb.nextLine();
		jetInfo[1] = kb.nextLine().trim();

		System.out.print("What is the maximum speed of the jet?(as an integer): ");
		jetInfo[2] = kb.nextLine().trim();

		System.out.print("What is the maximum range of the jet?(as an integer): ");
		jetInfo[3] = kb.nextLine().trim();
		
		System.out.print("What is the price of the jet?(as an integer): ");
		jetInfo[4] = kb.nextLine().trim();
		
		airField.addJet(createJet(jetInfo));
		
		System.out.println("\nJet successfully added to fleet. Action Complete.");
	}

	private String chooseJetTypes() {
		int userChoice = 0;
		
		do {
			System.out.println("Please select a Jet type:");
			System.out.println("\n\t1) JetImpl");
			System.out.println("\t2) Fighter Jet");
			System.out.println("\t3) Cargo Plane");
			System.out.print("\nPlease select a number from 1 - 3: ");
			userChoice = intInputValidator(2);
			if (userChoice == 1) {
				return "JetImpl";
			} else if (userChoice == 2) {
				return "FighterJet";
			} else if (userChoice == 3) {
				return "CargoPlane";
			} else {
				System.out.println("That was not a valid choice. Try again.");
			} 
		} while (userChoice != 1 && userChoice != 2 && userChoice != 3);
		
		return "JetImpl";
	}

	private int intInputValidator(int whichMenu) {
		boolean isInt = false;
		int number = 0;

		do {
						
			if(kb.hasNextInt()) {
				number = kb.nextInt();
				isInt = true;
			} else {
				System.err.println("\nInvalid input type. Repeating instructions.");
				if(whichMenu == 1) {
					System.out.print("\nPlease only enter a number between 1 - 9: ");					
				} else {
					System.out.print("\\nPlease only enter a number: ");
				}
				kb.next();
			}
		} while (!(isInt));
		
		return number;
	}

	private void printMainMenu() {
		System.out.println("Please choose an option from the following selections:");
		System.out.println("\n\t1) List fleet");
		System.out.println("\t2) Fly all Jets");
		System.out.println("\t3) View fastest Jet");
		System.out.println("\t4) View Jet with longest range");
		System.out.println("\t5) Load all Cargo Jets");
		System.out.println("\t6) Dogfight!");
		System.out.println("\t7) Add a jet to Fleet");
		System.out.println("\t8) Remove a jet from Fleet");
		System.out.println("\t9) Quit");
		System.out.print("\nEnter your selection as a number:  ");
	}

	private void printWelcomeHeader() {
		System.out.println("****************************** Jets ******************************");
		System.out.println("------------------------------------------------------------------");
		System.out.println("          -Welcome to the AirField Management Interface-\n");
		
	}
	
	private void pauseBeforeContinuing() {
		System.out.print("\nInput any letter or number to continue...");
		String userInput = kb.next();
		System.out.println("------------------------------------------------------------------");
	}

	private void fareWell() {
		System.out.println("------------------------------------------------------------------");
		System.out.println("**************************** Farewell ****************************");
	}	
}
