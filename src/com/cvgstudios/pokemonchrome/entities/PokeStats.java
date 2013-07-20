package com.cvgstudios.pokemonchrome.entities;

public enum PokeStats {

	/*
	 * The current level of the Pokemon.
	 */
	LEVEL,
	/*
	 * The maximum health points a Pokemon has.
	 */
	MAX_HP,

	/*
	 * The current amount of health points a Pokemon has.
	 */
	CURRENT_HP,

	/*
	 * The Attack stat determines how much damage a Pokemon can deal using a
	 * physical move
	 */
	ATTACK,

	/*
	 * The Defense stat determines how much damage a Pokemon receives when it is
	 * hit with a physical move
	 */
	DEFENSE,

	/*
	 * The Special Attack stat determines how much damage a Pokemon can deal
	 * using a special move
	 */
	SPECIAL_ATTACK,

	/*
	 * The Special Defense stat determines how much damage a Pokemon receives
	 * when it is hit with a special move
	 */
	SPECIAL_DEFENSE,

	/*
	 * The Speed stat determines how quickly a Pokemon can act in battle
	 */
	SPEED(),

	/*
	 * The type the Pokemon is.
	 * 
	 * 1 = Fire, 2 = Water, 3 = Grass
	 */
	TYPE;
	private PokeStats() {

	}
	
	
	
}
