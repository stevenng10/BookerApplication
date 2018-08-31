package com.animalshelter.manager;

import java.util.List;
import java.util.Map;

import com.animalshelter.DAO.ShelterDAO;
import com.animalshelter.beans.Animal;
import com.animalshelter.beans.Dog;
import com.animalshelter.beans.InputBeans;

public class DogManager {

	String name;

	public boolean addDog(InputBeans bean) {

		Animal dog = new Dog(bean.getName(), bean.getAge(), bean.getGender());
		boolean isAdded = false;

		if (ShelterDAO.hmap.get("dog") == null || ShelterDAO.hmap.get("dog").size() < 5) {
			ShelterDAO.dogList.add(dog);
			ShelterDAO.hmap.put("dog", ShelterDAO.dogList);
			isAdded = true;
		} else {
			isAdded = false;
		}
		return isAdded;
	}

	public String showDogs() {

		String animalList = "Meet our lovely dog friends!\n";

		for (Map.Entry<String, List<Animal>> entry : ShelterDAO.hmap.entrySet()) {
			String animalType = entry.getKey();
			List<Animal> animals = entry.getValue();
			if (animalType.equals("dog")) {
				for (Animal animal : animals) {
					animalList += animal.getId() + ": arf arf arf ... Hi I'm " + animal.getName() + " the Dog, "
							+ animal.getAge() + " years old.\n";
				}
			}
		}
		return animalList;
	}

	public boolean removeDog(int id) {

		boolean isSuccessful = false;

		for (int i = 0; i < ShelterDAO.hmap.get("dog").size(); i++) {
			if (id == ShelterDAO.hmap.get("dog").get(i).getId()) {
				ShelterDAO.hmap.get("dog").remove(i);
				isSuccessful = true;
			}
		}
		return isSuccessful;
	}

	public boolean feedDogs(int id) {

		boolean isFound = false;

		for (int i = 0; i < ShelterDAO.hmap.get("dog").size(); i++) {
			if (id == ShelterDAO.hmap.get("dog").get(i).getId()) {
				isFound = true;
				name = ShelterDAO.hmap.get("dog").get(i).getName();
			}
		}

		return isFound;
	}

	public String getName() {
		return name;
	}
}
