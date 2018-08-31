package com.pokemon;

public class MoveBean {

	String name;
	String type;
	int damage;
	int pp;
	
	public MoveBean(String name, String type, int damage, int pp) {
		this.name = name;
		this.type = type;
		this.damage = damage;
		this.pp = pp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}
}
