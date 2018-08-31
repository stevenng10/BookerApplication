package com.animalshelter.main;

import com.animalshelter.presentation.CatUI;
import com.animalshelter.presentation.DogUI;
import com.animalshelter.presentation.HomePage;
import com.animalshelter.presentation.ParrotUI;

public class AnimalShelterMain {

	public static void main(String[] args) {
		
		boolean isDone = false;
		HomePage home = new HomePage();
		
		while(!isDone) {
			
			switch(home.initializeMenu()) {
				case 1: DogUI dog = new DogUI();
					dog.initializeDogMenu();
					break;
				case 2: CatUI cat = new CatUI();
					cat.initializeCatMenu();
					break;
				case 3: ParrotUI parrot = new ParrotUI();
					parrot.initializeParrotMenu();
					break;
				case 4: isDone = true;
					break;
				default: System.out.println("Invalid Input!");	
			}
			
		}
	}

}
