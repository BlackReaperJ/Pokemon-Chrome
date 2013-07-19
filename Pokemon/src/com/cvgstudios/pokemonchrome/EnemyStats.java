package com.cvgstudios.pokemonchrome;

public class EnemyStats {
	public static int enemyBaseHp, enemyBaseAtk, enemyBaseDef, enemyBaseSpAtk,
			enemyBaseSpDef, enemyBaseSpeed;// Enemy Pokemon Stats
	public static String enemyType;
	public static int enemyStatHp, enemyHp, enemyStatAtk, enemyStatDef,
			enemyStatSpAtk, enemyStatSpDef, enemyStatSpeed;// Enemy Final Stats
	public static int enemyStgAtk = 0, enemyStgDef = 0, enemyStgSpAtk = 0,
			enemyStgSpDef = 0, enemyStgSpeed = 0;
	double enemyAtkPercent = 1, enemyDefPercent = 1, enemySpAtkPercent = 1,
			enemySpDefPercent = 1, enemySpeedPercent = 1;
	int enemyDmg;

	public void enemyStats() {// Initializes the enemy pokemons stats
		if (GameFile.enemyParty[0].equals("Tykepol")) {// Using Turtwig base
														// stats
			enemyType = "Fight";
			enemyBaseHp = 55;
			enemyBaseAtk = 68;
			enemyBaseDef = 64;
			enemyBaseSpAtk = 45;
			enemyBaseSpDef = 55;
			enemyBaseSpeed = 31;
		} else if (GameFile.enemyParty[0].equals("Cosmet")) {// Using Modified
																// Hp +5 Def +3
																// Treecko base
																// stats
			enemyType = "Psychic";
			enemyBaseHp = 45;
			enemyBaseAtk = 45;
			enemyBaseDef = 38;
			enemyBaseSpAtk = 65;
			enemyBaseSpDef = 55;
			enemyBaseSpeed = 70;
		} else if (GameFile.enemyParty[0].equals("Embite")) {// Using Torchic
																// base stats
			enemyType = "Dark";
			enemyBaseHp = 45;
			enemyBaseAtk = 60;
			enemyBaseDef = 40;
			enemyBaseSpAtk = 70;
			enemyBaseSpDef = 50;
			enemyBaseSpeed = 45;
		}
	}

	public void enemyStatStages(int enemyStgAtk, int enemyStgDef) {
		switch (enemyStgAtk) {
		case (-6):
			enemyAtkPercent = 0.25;
			break;
		case (-5):
			enemyAtkPercent = 0.29;
			break;
		case (-4):
			enemyAtkPercent = 0.33;
			break;
		case (-3):
			enemyAtkPercent = 0.40;
			break;
		case (-2):
			enemyAtkPercent = 0.50;
			break;
		case (-1):
			enemyAtkPercent = 0.67;
			break;
		case (0):
			enemyAtkPercent = 1;
			break;
		case (1):
			enemyAtkPercent = 1.5;
			break;
		case (2):
			enemyAtkPercent = 2.0;
			break;
		case (3):
			enemyAtkPercent = 2.5;
			break;
		case (4):
			enemyAtkPercent = 3.0;
			break;
		case (5):
			enemyAtkPercent = 3.5;
			break;
		case (6):
			enemyAtkPercent = 4.0;
			break;
		}

		switch (enemyStgDef) {
		case (-6):
			enemyDefPercent = 0.25;
			break;
		case (-5):
			enemyDefPercent = 0.29;
			break;
		case (-4):
			enemyDefPercent = 0.33;
			break;
		case (-3):
			enemyDefPercent = 0.40;
			break;
		case (-2):
			enemyDefPercent = 0.50;
			break;
		case (-1):
			enemyDefPercent = 0.67;
			break;
		case (0):
			enemyDefPercent = 1;
			break;
		case (1):
			enemyDefPercent = 1.5;
			break;
		case (2):
			enemyDefPercent = 2.0;
			break;
		case (3):
			enemyDefPercent = 2.5;
			break;
		case (4):
			enemyDefPercent = 3.0;
			break;
		case (5):
			enemyDefPercent = 3.5;
			break;
		case (6):
			enemyDefPercent = 4.0;
			break;
		}
	}

	public void enemyFinalStats(int enemyDmg, double enemyAtkPercent,
			double enemyDefPercent) {
		enemyHp = (int) (((double) ((GameFile.enemy1Ivs[0] + (2 * enemyBaseHp) + 100) * GameFile.enemyLevels[0]) / 100) + 10);
		enemyStatAtk = (int) ((((double) ((GameFile.enemy1Ivs[1] + (2 * enemyBaseAtk)) * GameFile.enemyLevels[0]) / 100) + 5) * enemyAtkPercent);
		enemyStatDef = (int) ((((double) ((GameFile.enemy1Ivs[2] + (2 * enemyBaseDef)) * GameFile.enemyLevels[0]) / 100) + 5) * enemyDefPercent);
		enemyStatSpAtk = (int) ((((double) ((GameFile.enemy1Ivs[3] + (2 * enemyBaseSpAtk)) * GameFile.enemyLevels[0]) / 100) + 5) * enemySpAtkPercent);
		enemyStatSpDef = (int) ((((double) ((GameFile.enemy1Ivs[4] + (2 * enemyBaseSpDef)) * GameFile.enemyLevels[0]) / 100) + 5) * enemySpDefPercent);
		enemyStatSpeed = (int) ((((double) ((GameFile.enemy1Ivs[5] + (2 * enemyBaseSpeed)) * GameFile.enemyLevels[0]) / 100) + 5) * enemySpeedPercent);
		enemyStatHp = (int) (((double) ((GameFile.enemy1Ivs[0]
				+ (2 * enemyBaseHp) + 100) * GameFile.enemyLevels[0]) / 100) + 10)
				- enemyDmg;

	}
}