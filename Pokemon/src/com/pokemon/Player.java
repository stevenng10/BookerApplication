package com.pokemon;

public class Player {
	
	String name;
	Pokemon pokemon;
	
	public Player(String name, Pokemon pokemon) {
		this.name = name;
		this.pokemon = pokemon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}
	
	public static void gameOver(Player p) {
		System.out.println(p.getName() + " has lost.");
	}
}
