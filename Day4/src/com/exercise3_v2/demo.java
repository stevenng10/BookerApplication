package com.exercise3_v2;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class demo {

	public static void main(String[] args) {
		
		List<String> lists = new ArrayList<String>();
		
		lists.add("A");
		lists.add("B");
		lists.add("C");
		
		for(String list : lists) {
			System.out.println(list);
		}
		
		ListIterator<String> litr = lists.listIterator();
		
		while(litr.hasNext()) {
			litr.next();
			litr.remove();
		}
		
		for(String list : lists) {
			System.out.println(list);
		}
		
	}

}
