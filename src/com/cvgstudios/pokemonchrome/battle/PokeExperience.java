package com.cvgstudios.pokemonchrome.battle;

import com.cvgstudios.pokemonchrome.GameFile;

public class PokeExperience {
	public static int expType = 0, expGain, expReq, enemyExp, experience;
	public static double battleExp;

	public void pokemonExpTypes() {
		if (expType == 1) {// Erratic Exp
			expReq = (int) (double) ((GameFile.pokemonLevels[0]
					* GameFile.pokemonLevels[0] * GameFile.pokemonLevels[0] * (100 - GameFile.pokemonLevels[0])) / 50);
		} else if (expType == 2) {// Fast Exp
			expReq = (int) (double) ((4 * GameFile.pokemonLevels[0]
					* GameFile.pokemonLevels[0] * GameFile.pokemonLevels[0]) / 5);
		} else if (expType == 3) {// Medium Fast Exp
			expReq = (int) (double) (GameFile.pokemonLevels[0]
					* GameFile.pokemonLevels[0] * GameFile.pokemonLevels[0]);
		} else if (expType == 4) {// Medium Slow Exp
			expReq = (int) (double) ((6 / 5) * GameFile.pokemonLevels[0]
					* GameFile.pokemonLevels[0] * GameFile.pokemonLevels[0]
					- 15
					* (GameFile.pokemonLevels[0] * GameFile.pokemonLevels[0])
					+ (100 * GameFile.pokemonLevels[0]) - 140);
		} else if (expType == 5) {// Slow Exp
			expReq = (int) (double) ((5 * GameFile.pokemonLevels[0]
					* GameFile.pokemonLevels[0] * GameFile.pokemonLevels[0]) / 4);
		} else if (expType == 6) {// Fluctuating Exp
			expReq = (int) (double) (GameFile.pokemonLevels[0]
					* GameFile.pokemonLevels[0] * GameFile.pokemonLevels[0] * ((((GameFile.pokemonLevels[0] + 1) / 3) + 24) / 50));
		}
	}

	public int experienceGain() {
		experience = (int) (double) (((battleExp * enemyExp * GameFile.enemyLevels[0]) / 5)
				* (Math.pow((2 * GameFile.enemyLevels[0] + 10), 2.5) / (Math
						.pow((GameFile.enemyLevels[0]
								+ GameFile.pokemonLevels[0] + 10), 2.5))) + 1);
		return (experience);
	}

	public void pokemonExperience() {
		expGain = experienceGain();
		GameFile.pokemonExp[0] = GameFile.pokemonExp[0] + expGain;

		while (GameFile.pokemonExp[0] >= expReq) {
			GameFile.pokemonLevels[0] = GameFile.pokemonLevels[0] + 1;
		}
	}
}