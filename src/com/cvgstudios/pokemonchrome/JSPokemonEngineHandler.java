package com.cvgstudios.pokemonchrome;

import java.util.Vector;

import com.cvgstudios.pokemonchrome.entities.BasePokemon;

public class JSPokemonEngineHandler {

	private static Vector<JSPokemonTypeHandler> pokemonTypes;
	
	public static void register_pokemon(String pokemonName){
		BasePokemon.addPokemon(pokemonName);
		JSExecutor.evaluate(pokemonName + " = new Object()");
		JSPokemonTypeHandler newTypeHandler = new JSPokemonTypeHandler(BasePokemon.getPokemon(pokemonName));
		pokemonTypes.add(newTypeHandler);
		JSExecutor.setBind(pokemonName , newTypeHandler);
	}
	
}
