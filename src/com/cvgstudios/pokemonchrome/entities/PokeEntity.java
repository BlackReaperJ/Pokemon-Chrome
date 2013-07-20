package com.cvgstudios.pokemonchrome.entities;

public enum PokeEntity {

	/*
	 * The maximum health points a Pokémon has.
	 */
	MAX_HP,

	/*
	 * The current amount of health points a Pokémon has.
	 */
	CURRENT_HP,

	/*
	 * The Attack stat determines how much damage a Pokémon can deal using a
	 * physical move
	 */
	ATTACK,

	/*
	 * The Defense stat determines how much damage a Pokémon receives when it is
	 * hit with a physical move
	 */
	DEFENSE,

	/*
	 * The Special Attack stat determines how much damage a Pokémon can deal
	 * using a special move
	 */
	SPECIAL_ATTACK,

	/*
	 * The Special Defense stat determines how much damage a Pokémon receives
	 * when it is hit with a special move
	 */
	SPECIAL_DEFENSE,

	/*
	 * The Speed stat determines how quickly a Pokémon can act in battle
	 */
	SPEED,

	/*
	 * The type the Pokémon is.
	 * 
	 * 1 = Fire, 2 = Water, 3 = Grass
	 */
	TYPE;
}
