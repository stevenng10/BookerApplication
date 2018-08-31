package com.mincat.manager;

public class MincatManager {

	public String minCat(String a, String b) {
		
		String result;
		
		if(a.length() > b.length()) {
			result = a.substring(a.length() - b.length(), a.length()) + b;
		} else if(a.length() < b.length()) {
			result = a + b.substring(b.length() - a.length(), b.length());
		} else {
			result = a + b;
		}
		return result;	
	}
}
