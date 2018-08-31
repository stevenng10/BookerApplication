package com.pokemon;

public class MoveDef extends MoveBean {

	String name;
	String type;
	int def;
	int pp;
	
	public MoveDef(String name, int pp) {
		super(name,"",0,pp);
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

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}
	
	public int randNumber() {
		def = (int) Math.random()*51 + 20;
		return def;
	}
}
