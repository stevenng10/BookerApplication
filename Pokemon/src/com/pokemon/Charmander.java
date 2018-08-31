package com.pokemon;

public class Charmander extends Pokemon {
	
	@Override
	public void initializeMoves() {
		MoveBean scratch = new MoveBean("Scratch", "Normal", 10, 1);
		MoveBean ember = new MoveBean("Ember", "Fire", 25, 5);
		MoveBean blast = new MoveBean("Blast Burn", "Fire", 50, 15);
		MoveDef sumb = new MoveDef("Sumbong Sa Nanay", 10);
		
		moveBean[0] = scratch;
		moveBean[1] = ember;
		moveBean[2] = blast;
		moveBean[3] = sumb;
	}

}
