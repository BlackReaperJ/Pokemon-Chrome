package com.cvgstudios.pokemonchrome.entities;

public class BetterPokemon {

	protected BasePokemon theBaseType;

	protected String type;
	
	protected int ivHP;
	protected int ivAttack;
	protected int ivDefense;
	protected int ivSpAttack;
	protected int ivSpDefense;
	protected int ivSpeed;

	public BetterPokemon(BasePokemon pokemonType) {

	}

	public void setIvHP(int hp) {
		ivHP = hp;
	}

	public void setIvAttack(int attack) {
		ivAttack = attack;
	}

	public void setIvDefense(int defense) {
		ivDefense = defense;
	}

	public void setIvSpAttack(int spAttack) {
		ivSpAttack = spAttack;
	}

	public void setIvSpDefense(int spDefense) {
		ivSpDefense = spDefense;
	}

	public void setIvSpeed(int speed) {
		ivSpeed = speed;
	}
	
	public void setType(String theType){
		type = theType;
	}

}
