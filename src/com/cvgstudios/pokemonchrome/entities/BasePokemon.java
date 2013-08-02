package com.cvgstudios.pokemonchrome.entities;

import java.util.Vector;

public class BasePokemon {

	static Vector<BasePokemon> theBasePokemon;

	String baseName;

	int baseHP;
	int baseAttack;
	int baseDefense;
	int baseSpAttack;
	int baseSpDefense;
	int baseSpeed;

	public BasePokemon(String basePokemonName) {
		baseName = basePokemonName;
	}

	
	public String getBaseName(){
		return baseName;
	}
	
	public void setHP(int hp) {
		baseHP = hp;
	}

	public void setAttack(int attack) {
		baseAttack = attack;
	}

	public void setDefense(int defense) {
		baseDefense = defense;
	}

	public void setSpAttack(int spAttack) {
		baseSpAttack = spAttack;
	}

	public void setSpDefense(int spDefense) {
		baseSpDefense = spDefense;
	}

	public void setSpeed(int speed) {
		baseSpeed = speed;
	}

	public static void addPokemon(String pokemonName) {
		if (theBasePokemon == null){
			theBasePokemon = new Vector<BasePokemon>();
		}
		
		theBasePokemon.add(new BasePokemon(pokemonName));
	}
	
	public static BasePokemon getPokemon(String pokemonName){
		
		for (int i = 0; i < theBasePokemon.size(); i ++){
			if (theBasePokemon.get(i).baseName.equals(pokemonName)){
				return theBasePokemon.get(i);
			}
		}
		
		return null;
		
	}

}
