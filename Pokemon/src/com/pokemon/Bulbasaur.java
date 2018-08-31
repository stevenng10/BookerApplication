package com.pokemon;

public class Bulbasaur extends Pokemon {

	@Override
	public void initializeMoves() {
		MoveBean tackle = new MoveBean("Tackle", "Normal", 10, 1);
		MoveBean vine = new MoveBean("Vine Whip", "Grass", 25, 5);
		MoveBean frenzy = new MoveBean("Frenzy Plant", "Grass", 50, 15);
		MoveDef growth = new MoveDef("Growth", 10);
		
		moveBean[0] = tackle;
		moveBean[1] = vine;
		moveBean[2] = frenzy;
		moveBean[3] = growth;
	}
}
