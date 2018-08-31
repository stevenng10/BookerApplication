package com.animalshelter.manager;

import java.util.List;
import java.util.Map;

import com.animalshelter.DAO.ShelterDAO;
import com.animalshelter.beans.Animal;
import com.animalshelter.beans.Cat;
import com.animalshelter.beans.InputBeans;

public class CatManager {

	String name;

	public boolean addCat(InputBeans bean) {

		Animal cat = new Cat(bean.getName(), bean.getAge(), bean.getGender());
		boolean isAdded = false;

		if (ShelterDAO.hmap.get("cat") == null || ShelterDAO.hmap.get("cat").size() < 5) {
			ShelterDAO.catList.add(cat);
			ShelterDAO.hmap.put("cat", ShelterDAO.catList);
			isAdded = true;
		} else {
			isAdded = false;
		}
		return isAdded;
	}

	public String showCats() {

		String animalList = "Meet our lovely cat friends!\n";

		for (Map.Entry<String, List<Animal>> entry : ShelterDAO.hmap.entrySet()) {
			String animalType = entry.getKey();
			List<Animal> animals = entry.getValue();
			if (animalType.equals("cat")) {
				for (Animal animal : animals) {
					animalList += animal.getId() + ": meow meow meow ... Hi I'm " + animal.getName() + " the Cat, "
							+ animal.getAge() + " years old.\n";
				}
			}
		}
		return animalList;
	}

	public boolean removeCat(int id) {

		boolean isSuccessful = false;

		for (int i = 0; i < ShelterDAO.hmap.get("cat").size(); i++) {
			if (id == ShelterDAO.hmap.get("cat").get(i).getId()) {
				ShelterDAO.hmap.get("cat").remove(i);
				isSuccessful = true;
			}
		}
		return isSuccessful;
	}

	public boolean feedCats(int id) {

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
