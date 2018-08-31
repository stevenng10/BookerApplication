package com.pokemon;

public abstract class Pokemon {
	
	private String breed;
	private String elementType;
	private int healthPoints = 100;
	private int powerPoints = 40;
	protected MoveBean[] moveBean = new MoveBean[4];
	
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getElementType() {
		return elementType;
	}
	public void setElementType(String elementType) {
		this.elementType = elementType;
	}
	public int getHealthPoints() {
		return healthPoints;
	}
	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}
	public int getPowerPoints() {
		return powerPoints;
	}
	public void setPowerPoints(int powerPoints) {
		this.powerPoints = powerPoints;
	}
	
	public MoveBean doMove() {
		
		int randNum = (int) (Math.random() * 3) ;
		reducePP(moveBean[randNum].getPp());
		return moveBean[randNum];
		
	}
	
	public void reduceHealth(int damage) {
		
		healthPoints = healthPoints - damage;
	}
	
	public void reducePP(int pp) {
		
		powerPoints = powerPoints - pp;
	} 
	
	public void usePotion() {
		
		int randNum = (int) (Math.random() * 31 ) + 20;
		
		if(healthPoints < 100) {
			
			healthPoints += randNum;
			
			if(healthPoints > 100) {
				healthPoints = 100;
			}
			
		} else {
			healthPoints = 100;
		}
	}
	
	public abstract void initializeMoves();
	
	public void makeSound() {
		
	}
}
