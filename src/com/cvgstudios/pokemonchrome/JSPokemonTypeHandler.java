package com.cvgstudios.pokemonchrome;

import com.cvgstudios.pokemonchrome.entities.BasePokemon;

public class JSPokemonTypeHandler {
	
	BasePokemon pokemonType;
	
	public JSPokemonTypeHandler(BasePokemon pokemon){
		pokemonType = pokemon;
	}
	
	public void set_base_hp(int hp){
		pokemonType.setHP(hp);
	}
	public void set_base_attack(int attack){
		pokemonType.setAttack(attack);
	}
	public void set_base_defense(int defense){
		pokemonType.setDefense(defense);
	}
	public void set_base_sp_attack(int spAttack){
		pokemonType.setSpAttack(spAttack);
	}
	public void set_base_sp_defense(int spDefense){
		pokemonType.setSpDefense(spDefense);
	}
	public void set_base_speed(int speed){
		pokemonType.setSpeed(speed);
	}
	
}
