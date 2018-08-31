package com.pw.io.booker.repository.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pw.io.booker.model.TravelPackage;

public class TravelPackageRepositoryMap {

	private Map<Integer, TravelPackage> travelPackageMap = new HashMap<>();
	private int travelPackageIdGenerator = 1000;

	public List<TravelPackage> findAll() {
		return new ArrayList<>(travelPackageMap.values());
	}

	public TravelPackage find(int id) {
		return travelPackageMap.get(id);
	}

	public TravelPackage save(TravelPackage model) {
		if (find(model.getTravelPackageId()) != null) {
			travelPackageMap.put(model.getTravelPackageId(), model);
			return model;
		}
		model.setTravelPackageId(travelPackageIdGenerator++);
		travelPackageMap.put(model.getTravelPackageId(), model);
		return model;
	}

	public TravelPackage delete(TravelPackage model) {
		return travelPackageMap.remove(model.getTravelPackageId());
	}

}
