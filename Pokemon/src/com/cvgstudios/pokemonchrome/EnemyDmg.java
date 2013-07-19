package com.cvgstudios.pokemonchrome;

import com.cvgstudios.pokemonchrome.battle.PokemonStats;

public class EnemyDmg {
	public static int enemyCritical, dmgTake, pokemonDmg;
	public static String enemyAtkType = "", statChange;
	public static double enemyStab, enemyTypeEffect, enemyModifier;
	PokemonStats pokemonStats = new PokemonStats();// Creates a variable for the
													// EnemeyStats Class
	CompAI compAi = new CompAI();

	public void enemyDmg(String enemyType, String enemyAtkType, String type,
			int enemyAtkPower, int enemyStatAtk, int statDef, int ai,
			int animationEnemy) {
		if (animationEnemy >= 120) {
			if (enemyType.equals(compAi.enemyAtkType)) {
				enemyStab = 1.5;
			} else {
				enemyStab = 1;
			}

			if (compAi.enemyAtkType.equals("Normal")
					&& (type.equals("Dark") || type.equals("Psychic") || (type
							.equals("Fight")))) {// Type Effectiveness
				enemyTypeEffect = 1;
			}

			double enemyCrit = Math.random() * 100.00 + 1.00;

			if (enemyCrit >= 94.25) {
				enemyCritical = 2;
			} else {
				enemyCritical = 1;
			}

			if (compAi.enemyAtkPower > 0) {
				enemyModifier = enemyStab * enemyTypeEffect * enemyCritical
						* (Math.random() * 0.16 + 0.85);
				dmgTake = (int) ((((2.0 * GameFile.enemyLevels[0] + 10.0) / 250.0)
						* ((double) enemyStatAtk / (double) statDef)
						* (double) (compAi.enemyAtkPower) + 2) * enemyModifier); // Base
				pokemonDmg = pokemonDmg + dmgTake;
			} else if (GameFile.enemy1MoveSet[ai].equals("Leer")
					|| GameFile.enemy1MoveSet[ai].equals("Tail Whip")) {
				pokemonStats.stgDef = pokemonStats.stgDef - 1;
			} else if (GameFile.enemy1MoveSet[ai].equals("Growl")) {
				pokemonStats.stgAtk = pokemonStats.stgAtk - 1;
			}
		}
	}
}