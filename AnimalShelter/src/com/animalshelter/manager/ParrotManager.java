package com.animalshelter.manager;

import java.util.List;
import java.util.Map;

import com.animalshelter.DAO.ShelterDAO;
import com.animalshelter.beans.Animal;
import com.animalshelter.beans.InputBeans;
import com.animalshelter.beans.Parrot;

public class ParrotManager {

	String name;

	public boolean addParrot(InputBeans bean) {

		Animal parrot = new Parrot(bean.getName(), bean.getAge(), bean.getGender());
		boolean isAdded = false;

		if (ShelterDAO.hmap.get("parrot") == null || ShelterDAO.hmap.get("parrot").size() < 5) {
			ShelterDAO.parrotList.add(parrot);
			ShelterDAO.hmap.put("parrot", ShelterDAO.parrotList);
			isAdded = true;
		} else {
			isAdded = false;
		}
		return isAdded;
	}

	public String showParrots() {

		String animalList = "Meet our lovely parrot friends!\n";

		for (Map.Entry<String, List<Animal>> entry : ShelterDAO.hmap.entrySet()) {
			String animalType = entry.getKey();
			List<Animal> animals = entry.getValue();
			if (animalType.equals("parrot")) {
				for (Animal animal : animals) {
					animalList += animal.getId() + ": kroo kroo kroo ... Hi I'm " + animal.getName() + " the Parrot, "
							+ animal.getAge() + " years old.\n";
				}
			}
		}
		return animalList;
	}

	public boolean removeParrot(int id) {

		boolean isSuccessful = false;

		for (int i = 0; i < ShelterDAO.hmap.get("parrot").size(); i++) {
			if (id == ShelterDAO.hmap.get("parrot").get(i).getId()) {
				ShelterDAO.hmap.get("parrot").remove(i);
				isSuccessful = true;
			}
		}
		return isSuccessful;
	}

	public boolean feedParrots(int id) {

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
