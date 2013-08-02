package com.cvgstudios.pokemonchrome;

import java.io.File;
import java.util.Vector;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleBindings;

/**
 * It's going to execute JavaScript!
 * Yeah! Totally!
 */
public class JSExecutor {
	
	private static String moduleDirectory;
	private static FileLister lister;
	
	private static JSPokemonEngineHandler pokemonHandler;
	
	private static JSPokemonHandler entityHandlerTHIS;
	
	private static Vector<String> meterNames;
	private static ScriptEngine jsEngine;
	private static Bindings binds;
	
	private static boolean executorInitialized = false;
	
	public static void initializeExecutor(){
		
		jsEngine = new ScriptEngineManager().getEngineByName("javascript");
		pokemonHandler = new JSPokemonEngineHandler();
		binds = new SimpleBindings();
		
		binds.put("pokemon", pokemonHandler);
		
		executorInitialized = true;
	}
	
	public static void evaluate(String eval){
		if (!executorInitialized){
			initializeExecutor();
		}
		
		try {
			jsEngine.eval(eval , binds);
		} catch (ScriptException e) {
			System.out.println("Javascript error. Javascript error. Javascript error.");
			e.printStackTrace();
		}
		
	}
	
	public static void loadPokemon(){
		FileLister fl = new FileLister("res/pokemon");
		File[] pokemonFiles = fl.getFiles();
	}
	
	public static void setBind(String bindString, Object bindTo){
		binds.put(bindString, bindTo);
	}
	
}
