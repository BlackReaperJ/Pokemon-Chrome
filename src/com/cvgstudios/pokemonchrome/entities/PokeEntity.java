package com.cvgstudios.pokemonchrome.entities;

public abstract class PokeEntity {

	/*
	 * The current level of the Pokemon.
	 */
	protected int level;
	/*
	 * The maximum health points a Pokemon has.
	 */
	protected int maxHP;

	/*
	 * The current amount of health points a Pokemon has.
	 */
	protected int currentHP;

	/*
	 * The Attack stat determines how much damage a Pokemon can deal using a
	 * physical move
	 */
	protected int attack;

	/*
	 * The Defense stat determines how much damage a Pokemon receives when it is
	 * hit with a physical move
	 */
	protected int defense;

	/*
	 * The Special Attack stat determines how much damage a Pokemon can deal
	 * using a special move
	 */
	protected int specialAttack;

	/*
	 * The Special Defense stat determines how much damage a Pokemon receives
	 * when it is hit with a special move
	 */
	protected int specialDefense;

	/*
	 * The Speed stat determines how quickly a Pokemon can act in battle
	 */
	protected int speed;

	/*
	 * The type the Pokemon is.
	 */
	protected String type;
	/*
	 * The gender of the Pokemon.
	 */
	protected String gender;

	private PokeEntity() {

	}

}
