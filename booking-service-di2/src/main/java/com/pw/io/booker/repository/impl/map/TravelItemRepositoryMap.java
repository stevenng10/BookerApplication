package com.pw.io.booker.repository.impl.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pw.io.booker.model.TravelItem;
import com.pw.io.booker.repository.TravelItemRepository;

@Repository
public class TravelItemRepositoryMap implements TravelItemRepository {

	private Map<Integer, TravelItem> itemMap = new HashMap<>();
	private int serviceIdGenerator = 1000;

	@Override
	public List<TravelItem> findAll() {
		return new ArrayList<>(itemMap.values());
	}

	@Override
	public TravelItem findById(int id) {
		return itemMap.get(id);
	}

	@Override
	public TravelItem save(TravelItem model) {
		if (findById(model.getItemId()) != null) {
			itemMap.put(model.getItemId(), model);
			return model;
		}
		model.setItemId(serviceIdGenerator++);
		itemMap.put(model.getItemId(), model);
		return model;
	}

	@Override
	public void delete(TravelItem model) {
		itemMap.remove(model.getItemId());
	}

}
