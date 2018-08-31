package com.pokemon;

public class Squirtle extends Pokemon {

	@Override
	public void initializeMoves() {
		MoveBean tackle = new MoveBean("Tackle", "Normal", 10, 1);
		MoveBean watergun = new MoveBean("Water Gun", "Water", 25, 5);
		MoveBean hydro = new MoveBean("Hydro Pump", "Water", 50, 15);
		MoveDef protect = new MoveDef("Protect", 10);
		
		moveBean[0] = tackle;
		moveBean[1] = watergun;
		moveBean[2] = hydro;
		moveBean[3] = protect;
	}
}
