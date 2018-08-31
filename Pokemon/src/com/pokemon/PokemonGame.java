package com.pokemon;

import java.util.Scanner;

public class PokemonGame {
	static Player p1;
	static Player p2;
	static boolean isOver;
	
	public static void main(String[] args) {
		
		
		boolean isThru = false;
		
		GAME:
		while(!isThru) {
			
			Scanner in = new Scanner(System.in);
			
			StartGame.gameStart();
			String user_input = in.nextLine().toUpperCase();
			
			if(!user_input.equals("S")) {
				break;
			} 
			
			StartGame.player1Name();
			String plName = in.nextLine();
			StartGame.player1Pokemon();
			String p1pok = in.nextLine();
			
			for (char c : p1pok.toCharArray()) {
				if (!Character.isDigit(c)) {
					break;
				}
			}
			
			StartGame.player2Name();
			String p2Name = in.nextLine();
			StartGame.player2Pokemon();
			String p2pok = in.nextLine();
			
			for (char c : p2pok.toCharArray()) {
				if (!Character.isDigit(c)) {
					break;
				}
			}
			
			p1 = new Player(plName, choosePoke(p1pok));
			p2 = new Player(p2Name, choosePoke(p2pok));
			
			isOver = false;
			int turn = 1;
			
			while(!isOver) {
				
				if(p2.getPokemon().getHealthPoints() <= 0 || 
						p2.getPokemon().getPowerPoints() <= 0) {
					isOver = true;
					Player.gameOver(p2);
				}
				
				if(p1.getPokemon().getHealthPoints() <= 0 || 
						p1.getPokemon().getPowerPoints() <= 0) {
					isOver = true;
					Player.gameOver(p1);
				}
				
				String moveChoice;
				
				if(turn % 2 == 0) {
					pScreen(p2);
					moveChoice = in.nextLine();
					chooseMove(moveChoice, turn);
					turn++;
				} else {
					pScreen(p1);
					moveChoice = in.nextLine();
					chooseMove(moveChoice, turn);
					turn++;
				}		
			}
		}	
	}
	
	public static Pokemon choosePoke(String choice) {
		
		Pokemon poke = null;
		
		switch(choice) {
		
			case "1": poke = new Charmander();
					poke.initializeMoves();
					poke.setBreed("Charmander");
					poke.setElementType("Fire");
					break;
			case "2": poke = new Bulbasaur();
					poke.initializeMoves();
					poke.setBreed("Bulbasaur");
					poke.setElementType("Grass");
					break;
			case "3": poke = new Squirtle();
					poke.initializeMoves();
					poke.setBreed("Squirtle");
					poke.setElementType("Water");
					break;
		}
		
		return poke;
		
	}
	
	public static void pScreen(Player p) {
		
		System.out.println("P1 " + p.getName() + "'s " + p.getPokemon().getBreed() + ":");
		System.out.println("HP:" + p.getPokemon().getHealthPoints());
		System.out.println("PP:" + p.getPokemon().getPowerPoints() + "\n");
		System.out.println("\tP1 " + p.getName() + "'s Move:");
		System.out.println("\t[1] Attack");
		System.out.println("\t[2] Use Potion");
		System.out.println("\t[3] Run");
		System.out.println("\tEnter Choice:");

	}
	
	public static void chooseMove(String moveChoice, int turn) {
		
		switch(moveChoice) {
			case "1": 
				if(turn % 2 == 0) {
					MoveBean current = p2.getPokemon().doMove();
					p1.getPokemon().reduceHealth(current.getDamage());
				} else {
					MoveBean current = p1.getPokemon().doMove();
					p2.getPokemon().reduceHealth(current.getDamage());
				}
				break;
			case "2": 
				if(turn % 2 == 0) {
					p2.getPokemon().usePotion();
				} else {
					p1.getPokemon().usePotion();
				}
				break;
			case "3": 
				if(turn % 2 == 0) {
					isOver = true;
					Player.gameOver(p1);
				} else {
					isOver = true;
					Player.gameOver(p2);
				}	
				break;
		}
	}
}