package com.cvgstudios.pokemonchrome;

import java.util.Random;

public class CompAI {
	Random r = new Random();
	public static int ai, enemyAtkPower;
	public String enemyAtkType;
	public static String enemyStatChange;

	public void compAi(int battle) {
		if (battle == 1) {
			ai = r.nextInt(2);
		}

		if (GameFile.enemy1MoveSet[ai].equals("Tackle")) {
			// Changed base atk of tackle from 50 to  40
			enemyAtkPower = 40;
			enemyAtkType = "Normal";
		} else if (GameFile.enemy1MoveSet[ai].equals("Growl")
				|| GameFile.enemy1MoveSet[ai].equals("Tail Whip")
				|| GameFile.enemy1MoveSet[ai].equals("Leer")) {
			enemyAtkPower = 0;
		}

		if (GameFile.enemy1MoveSet[ai].equals("Growl")) {
			enemyStatChange = "Attack";
		} else if (GameFile.enemy1MoveSet[ai].equals("Tail Whip")
				|| GameFile.enemy1MoveSet[ai].equals("Leer")) {
			enemyStatChange = "Defense";
		}
	}
}