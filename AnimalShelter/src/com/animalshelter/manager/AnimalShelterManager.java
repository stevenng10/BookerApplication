package com.animalshelter.manager;

import com.animalshelter.DAO.ShelterDAO;
import com.animalshelter.beans.Cat;
import com.animalshelter.beans.Dog;
import com.animalshelter.beans.Parrot;

public class AnimalShelterManager {

	public int countDogs() {
		if (ShelterDAO.dogList.size() == 0) {
			return 0;
		} else {
			return ShelterDAO.dogList.size();
		}
	}

	public int countCats() {
		if (ShelterDAO.catList.size() == 0) {
			return 0;
		} else {
			return ShelterDAO.catList.size();
		}
	}

	public int countParrots() {
		if (ShelterDAO.parrotList.size() == 0) {
			return 0;
		} else {
			return ShelterDAO.parrotList.size();
		}
	}

	public boolean isDogFull() {
		if (ShelterDAO.dogList.size() > Dog.maxCount) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isCatFull() {
		if (ShelterDAO.catList.size() > Cat.maxCount) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isParrotFull() {
		if (ShelterDAO.parrotList.size() > Parrot.maxCount) {
			return true;
		} else {
			return false;
		}
	}
}
