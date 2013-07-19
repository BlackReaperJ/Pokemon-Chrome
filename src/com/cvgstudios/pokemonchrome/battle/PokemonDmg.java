package com.cvgstudios.pokemonchrome.battle;

import com.cvgstudios.pokemonchrome.EnemyStats;
import com.cvgstudios.pokemonchrome.GameFile;

public class PokemonDmg {
	public static int atkPower, critical, dmg, enemyDmg;
	public static String atkType = "", statChange;
	public static double stab, typeEffect, modifier;
	EnemyStats enemyStats = new EnemyStats();// Creates a variable for the
												// EnemeyStats Class

	public void attackPower(int attackPosition) {
		if (attackPosition <= 3) {
			if (GameFile.pokemon1MoveSet[attackPosition].equals("Tackle")) {
				// Changed base atk of tackle from 50 to 40
				atkPower = 40;
				atkType = "Normal";
			} else if (GameFile.pokemon1MoveSet[attackPosition].equals("Growl")
					|| GameFile.pokemon1MoveSet[attackPosition]
							.equals("Tail Whip")
					|| GameFile.pokemon1MoveSet[attackPosition].equals("Leer")) {
				atkPower = 0;
			}
			if (GameFile.pokemon1MoveSet[attackPosition].equals("Growl")) {
				statChange = "Attack";
			} else if (GameFile.pokemon1MoveSet[attackPosition]
					.equals("Tail Whip")
					|| GameFile.pokemon1MoveSet[attackPosition].equals("Leer")) {
				statChange = "Defense";
			}
		}
	}

	/**
	 * Level - Attacker level Attack - Attacker attack stat Defense - Defender's
	 * defense stat Base - Attack's base damage The rest - Self explanatory
	 */
	public void pokemonDmg(String type, String atkType, String enemyType,
			int atkPower, int statAtk, int enemyStatDef, int attackPosition,
			int animation) {
		if (animation >= 120) {
			if (type.equals(atkType)) {
				stab = 1.5;
			} else {
				stab = 1;
			}

			if (atkType.equals("Normal")
					&& (enemyType.equals("Dark") || enemyType.equals("Psychic") || (enemyType
							.equals("Fight")))) {
				// Type Effectiveness
				typeEffect = 1;
			}

			double crit = Math.random() * 100.00 + 1.00;

			if (crit >= 94.25) {
				critical = 2;
			} else {
				critical = 1;
			}

			if (atkPower > 0) {
				modifier = stab * typeEffect * critical
						* (Math.random() * 0.16 + 0.85);
				dmg = (int) ((((2.0 * GameFile.pokemonLevels[0] + 10.0) / 250.0)
						* ((double) statAtk / (double) enemyStatDef)
						* (double) (atkPower) + 2) * modifier); // Base
				enemyDmg = enemyDmg + dmg;
			} else if (GameFile.pokemon1MoveSet[attackPosition].equals("Leer")
					|| GameFile.pokemon1MoveSet[attackPosition]
							.equals("Tail Whip")) {
				enemyStats.enemyStgDef = enemyStats.enemyStgDef - 1;
			} else if (GameFile.pokemon1MoveSet[attackPosition].equals("Growl")) {
				EnemyStats.enemyStgAtk = EnemyStats.enemyStgAtk - 1;
			}

			// enemyStats.enemyStatStages(enemyStgAtk, enemyStgDef);
			// enemyStats.enemyFinalStats();
		}
	}
}