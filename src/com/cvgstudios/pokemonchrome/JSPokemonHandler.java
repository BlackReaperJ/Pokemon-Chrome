package com.cvgstudios.pokemonchrome;

import com.cvgstudios.pokemonchrome.entities.BetterPokemon;

public class JSPokemonHandler {
	
	BetterPokemon handledPokemon;
	
	public void setHandle(BetterPokemon handlingPokemon){
		handledPokemon = handlingPokemon;
	}
	
	public JSPokemonHandler(){
		
	}
	
	public void set_type(String type){
		handledPokemon.setType(type);
	}
	
	public void set_iv_hp(int hp){
		handledPokemon.setIvHP(hp);
	}
	public void set_iv_attack(int attack){
		handledPokemon.setIvAttack(attack);
	}
	public void set_iv_defense(int defense){
		handledPokemon.setIvDefense(defense);
	}
	public void set_iv_sp_attack(int spAttack){
		handledPokemon.setIvSpAttack(spAttack);
	}
	public void set_iv_sp_defense(int spDefense){
		handledPokemon.setIvSpDefense(spDefense);
	}
	public void set_iv_speed(int speed){
		handledPokemon.setIvSpeed(speed);
	}
	
	
	
	
	
}
