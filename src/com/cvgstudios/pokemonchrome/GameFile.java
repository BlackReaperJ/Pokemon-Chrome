/* Save File handling mechanism for Pokemon Chrome
 * Its all static, just call it iwth SaveFile.whatevermethod();
 */

/* SAVEFILE FORMATTING:
 * 
 * Name(GG)
 * Gender(Male)
 * TimePlayed(103347856)
 * Location(7)
 * Badge(Ultimate Pokeperson)
 * Badge(Chromium Poisoning)
 * Badge(Haxx Mode User)
 * Badge(I don't know what badges are, I assume they are like acheivements)
 * Badge(You can have as many badges as you like.)
 * Badge(Yeeeah)
 * Pokemon(Slowpoke)
 * PokemonLevel(2)
 */

package com.cvgstudios.pokemonchrome;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GameFile {

	static String newline = System.getProperty("line.separator");

	static long LOLTIME = 0;

	static long lLastCalledAt = 0;
	static final long L_MIN_TIME_BETWEEN_FILEOP = 1000000000;
	static final String STR_SAVEFILE_NAME = "PlayerSaveFile.txt";
	static final int GAME_VAR_AMOUNT = 5;
	/*
	 * 0 - Your initial pokemon, decides friends' pokemons 1 - meeting
	 * frien,Jayce at start 2 - talking to your dad at start 3 - talking to your
	 * friends 4 - The Gate Blockers
	 */

	static final int POKEMON_PARTY_AMOUNT = 6;
	/*
	 * 1st,2nd,3rd,4th,5th,6th pokemon in your party
	 */

	static final int POKEMON_LEVELS_AMOUNT = 6;
	/*
	 * 1st,2nd,3rd,4th, 5th,and 6th levels of your pokemon
	 */

	static final int POKEMON_EXP_AMOUNT = 6;
	/*
	 * 1st,2nd,3rd,4th, 5th,and 6th experience of your pokemon
	 */

	static final int POKEMON_MOVES1_AMOUNT = 4;
	/*
	 * 1st,2nd,3rd,4th attack move of pokemon party 1
	 */

	static final int POKEMON1_IVS_AMOUNT = 6;
	/*
	 * POKEMON 1 1VS STATS- Order - Hp, Atk, Def, Sp.Atk, Sp.Def, Speed
	 */

	static final int POKEMON_HP_AMOUNT = 6;
	/*
	 * POKEMON 1 Current HP - Pokemon 1- 6
	 */

	static final int POKEMON_FULLHP_AMOUNT = 6;
	/*
	 * POKEMON 1 FullHP - Pokemon 1- 6
	 */

	static final int ENEMY_PARTY_AMOUNT = 6;
	/*
	 * 1st,2nd,3rd,4th,5th,6th pokemon in enemy party
	 */

	static final int ENEMY_LEVELS_AMOUNT = 6;
	/*
	 * 1st,2nd,3rd,4th,5th,6th leves in enemy party
	 */

	static final int ENEMY_MOVES1_AMOUNT = 4;
	/*
	 * 1st,2nd,3rd,4th attack move of enemy party 1
	 */

	static final int ENEMY1_IVS_AMOUNT = 6;
	/*
	 * ENEMY 1 1VS STATS- Order - Hp, Atk, Def, Sp.Atk, Sp.Def, Speed
	 */

	public static String strPlayerName;
	public static String strPlayerGender;
	public static long lTimePlayed;
	public static int iLocation;
	public static int iLocX;
	public static int iLocY;
	public static int iWin;
	public static int iBattle;// 1- Wild Pokemon, 2-Trainers, 3-Friends and
								// Gyms, 4- Double Battles
	public static String strTrainerName;

	public static ArrayList<String> stralBadges = new ArrayList<String>();
	public static int[] iaGameVars = new int[GAME_VAR_AMOUNT];
	public static String[] pokemonParty = new String[POKEMON_PARTY_AMOUNT];
	public static int[] pokemonLevels = new int[POKEMON_LEVELS_AMOUNT];
	public static int[] pokemonExp = new int[POKEMON_EXP_AMOUNT];
	public static String[] pokemon1MoveSet = new String[POKEMON_MOVES1_AMOUNT];
	public static int[] pokemon1Ivs = new int[POKEMON1_IVS_AMOUNT];
	public static int[] pokemonHp = new int[POKEMON_HP_AMOUNT];
	public static int[] pokemonFullHp = new int[POKEMON_FULLHP_AMOUNT];
	public static String[] enemyParty = new String[ENEMY_PARTY_AMOUNT];
	public static int[] enemyLevels = new int[ENEMY_LEVELS_AMOUNT];
	public static String[] enemy1MoveSet = new String[ENEMY_MOVES1_AMOUNT];
	public static int[] enemy1Ivs = new int[ENEMY1_IVS_AMOUNT];

	static String strPokemonName;

	public static void newGame() {
		if (System.nanoTime() - lLastCalledAt > L_MIN_TIME_BETWEEN_FILEOP) {
			// LOLTIME = System.nanoTime();
			strPlayerName = "";
			strPlayerGender = "";
			strTrainerName = "";
			lTimePlayed = 0;
			iLocation = 0;
			iLocX = 0;
			iLocY = 0;
			iBattle = 0;
			iWin = 0;
			ArrayList<String> stralBadges = new ArrayList<String>();
			iaGameVars = new int[GAME_VAR_AMOUNT];
			pokemonParty = new String[POKEMON_PARTY_AMOUNT];
			pokemonLevels = new int[POKEMON_LEVELS_AMOUNT];
			pokemonExp = new int[POKEMON_EXP_AMOUNT];
			pokemon1MoveSet = new String[POKEMON_MOVES1_AMOUNT];
			pokemon1Ivs = new int[POKEMON1_IVS_AMOUNT];
			pokemonHp = new int[POKEMON_HP_AMOUNT];
			pokemonFullHp = new int[POKEMON_FULLHP_AMOUNT];
			enemyParty = new String[ENEMY_PARTY_AMOUNT];
			enemyLevels = new int[ENEMY_LEVELS_AMOUNT];
			enemy1MoveSet = new String[ENEMY_MOVES1_AMOUNT];
			enemy1Ivs = new int[ENEMY1_IVS_AMOUNT];
			// LOLTIME = System.nanoTime() - LOLTIME;
			// System.out.println(LOLTIME);
		}
		lLastCalledAt = System.nanoTime();
	}

	public static void loadFile() {
		// System.out.println("I AM LOADING!");
		try {
			File readFile = new File(STR_SAVEFILE_NAME);
			System.out.println(readFile.getAbsolutePath());
			Scanner fileReader;
			fileReader = new Scanner(readFile);
			boolean bNameGot = false;
			boolean bGenderGot = false;
			boolean bTimeGot = false;
			boolean bLocationGot = false;
			boolean bPokemonNameGot = false;
			boolean bLocXGot = false;
			boolean bLocYGot = false;
			boolean bWin = false;
			boolean bBattleGot = false;
			boolean bTrainerNameGot = false;
			ArrayList<String> stralBadgesInFile = new ArrayList<String>();

			int iuDataAt = 0;// GameVar
			int iuDataAt1 = 0;// Pokemon Party
			int iuDataAt2 = 0;// Enemy Party
			int iuDataAt3 = 0;// Pokemon 1 MoveSet
			int iuDataAt4 = 0;// Pokemon Party Levels
			int iuDataAt5 = 0;// Enemy Pokemon Levels
			int iuDataAt6 = 0;// Pokemon1 IVS Stats
			int iuDataAt7 = 0;// Enemy 1 MoveSet
			int iuDataAt8 = 0;// Enemy1 IVS Stats
			int iuDataAt9 = 0;// Pokemon Current Hp
			int iuDataAt10 = 0;// Pokemon Full Hp
			int iuDataAt11 = 0;// Pokemon Experience

			String struLineParsing = "";
			while (fileReader.hasNextLine()) {
				struLineParsing = fileReader.nextLine().trim();
				if (!bNameGot && struLineParsing.startsWith("Name(")
						&& struLineParsing.endsWith(")")) {
					strPlayerName = struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')'));
					bNameGot = true;
				} else if (!bGenderGot && struLineParsing.startsWith("Gender(")
						&& struLineParsing.endsWith(")")) {
					strPlayerGender = struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')'));
					bGenderGot = true;
				} else if (!bTimeGot
						&& struLineParsing.startsWith("TimePlayed(")
						&& struLineParsing.endsWith(")")) {
					lTimePlayed = Long.parseLong(struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')')));
					bTimeGot = true;
				} else if (!bLocationGot
						&& struLineParsing.startsWith("Location(")
						&& struLineParsing.endsWith(")")) {
					iLocation = Integer.parseInt(struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')')));
					bLocationGot = true;
				} else if (!bBattleGot && struLineParsing.startsWith("Battle(")
						&& struLineParsing.endsWith(")")) {
					iBattle = Integer.parseInt(struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')')));
					bBattleGot = true;
				} else if (!bPokemonNameGot
						&& struLineParsing.startsWith("PokemonName(")
						&& struLineParsing.endsWith(")")) {
					strPokemonName = struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')'));
					bPokemonNameGot = true;
				} else if (struLineParsing.startsWith("Badge(")
						&& struLineParsing.endsWith(")")) {
					stralBadgesInFile.add(struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')')));
				} else if (struLineParsing.startsWith("GameVar(")
						&& struLineParsing.endsWith(")")
						&& iuDataAt < GAME_VAR_AMOUNT) {
					iaGameVars[iuDataAt] = (Integer.parseInt(struLineParsing
							.substring(struLineParsing.indexOf('(') + 1,
									struLineParsing.indexOf(')'))));
					iuDataAt++;
				} else if (struLineParsing.startsWith("PokemonLevels(")
						&& struLineParsing.endsWith(")")
						&& iuDataAt4 < POKEMON_LEVELS_AMOUNT) {
					pokemonLevels[iuDataAt4] = (Integer
							.parseInt(struLineParsing.substring(
									struLineParsing.indexOf('(') + 1,
									struLineParsing.indexOf(')'))));
					iuDataAt4++;
				} else if (struLineParsing.startsWith("PokemonParty(")
						&& struLineParsing.endsWith(")")
						&& iuDataAt1 < POKEMON_PARTY_AMOUNT) {
					pokemonParty[iuDataAt1] = struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')'));
					iuDataAt1++;
				} else if (struLineParsing.startsWith("PokemonExp(")
						&& struLineParsing.endsWith(")")
						&& iuDataAt11 < POKEMON_EXP_AMOUNT) {
					pokemonExp[iuDataAt11] = (Integer.parseInt(struLineParsing
							.substring(struLineParsing.indexOf('(') + 1,
									struLineParsing.indexOf(')'))));
					iuDataAt11++;
				} else if (struLineParsing.startsWith("Pokemon1IVsStats(")
						&& struLineParsing.endsWith(")")
						&& iuDataAt6 < POKEMON1_IVS_AMOUNT) {
					pokemon1Ivs[iuDataAt6] = (Integer.parseInt(struLineParsing
							.substring(struLineParsing.indexOf('(') + 1,
									struLineParsing.indexOf(')'))));
					iuDataAt6++;
				} else if (struLineParsing.startsWith("PokemonCurrentHp(")
						&& struLineParsing.endsWith(")")
						&& iuDataAt9 < POKEMON_HP_AMOUNT) {
					pokemonHp[iuDataAt9] = (Integer.parseInt(struLineParsing
							.substring(struLineParsing.indexOf('(') + 1,
									struLineParsing.indexOf(')'))));
					iuDataAt9++;
				} else if (struLineParsing.startsWith("PokemonFullHp(")
						&& struLineParsing.endsWith(")")
						&& iuDataAt10 < POKEMON_FULLHP_AMOUNT) {
					pokemonFullHp[iuDataAt10] = (Integer
							.parseInt(struLineParsing.substring(
									struLineParsing.indexOf('(') + 1,
									struLineParsing.indexOf(')'))));
					iuDataAt10++;
				} else if (struLineParsing.startsWith("Enemy1IVsStats(")
						&& struLineParsing.endsWith(")")
						&& iuDataAt8 < ENEMY1_IVS_AMOUNT) {
					enemy1Ivs[iuDataAt8] = (Integer.parseInt(struLineParsing
							.substring(struLineParsing.indexOf('(') + 1,
									struLineParsing.indexOf(')'))));
					iuDataAt8++;
				} else if (struLineParsing.startsWith("Pokemon1MoveSet(")
						&& struLineParsing.endsWith(")")
						&& iuDataAt3 < POKEMON_MOVES1_AMOUNT) {
					pokemon1MoveSet[iuDataAt3] = struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')'));
					iuDataAt3++;
				} else if (struLineParsing.startsWith("Enemy1MoveSet(")
						&& struLineParsing.endsWith(")")
						&& iuDataAt7 < ENEMY_MOVES1_AMOUNT) {
					enemy1MoveSet[iuDataAt7] = struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')'));
					iuDataAt7++;
				} else if (struLineParsing.startsWith("EnemyParty(")
						&& struLineParsing.endsWith(")")
						&& iuDataAt2 < ENEMY_PARTY_AMOUNT) {
					enemyParty[iuDataAt2] = struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')'));
					iuDataAt2++;
				} else if (struLineParsing.startsWith("EnemyLevels(")
						&& struLineParsing.endsWith(")")
						&& iuDataAt5 < ENEMY_LEVELS_AMOUNT) {
					enemyLevels[iuDataAt5] = (Integer.parseInt(struLineParsing
							.substring(struLineParsing.indexOf('(') + 1,
									struLineParsing.indexOf(')'))));
					iuDataAt5++;
				} else if (!bTrainerNameGot
						&& struLineParsing.startsWith("TrainerName(")
						&& struLineParsing.endsWith(")")) {
					strTrainerName = struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')'));
					bTrainerNameGot = true;
				} else if (!bWin && struLineParsing.startsWith("Win(")
						&& struLineParsing.endsWith(")")) {
					iWin = Integer.parseInt(struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')')));
					bWin = true;
				} else if (!bLocXGot
						&& struLineParsing.startsWith("XLocation(")
						&& struLineParsing.endsWith(")")) {
					iLocX = Integer.parseInt(struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')')));
					bLocXGot = true;
				} else if (!bLocYGot
						&& struLineParsing.startsWith("YLocation(")
						&& struLineParsing.endsWith(")")) {
					iLocY = Integer.parseInt(struLineParsing.substring(
							struLineParsing.indexOf('(') + 1,
							struLineParsing.indexOf(')')));
					bLocYGot = true;
				}

			}
			fileReader.close();

			stralBadges = stralBadgesInFile;
		} catch (IOException e) {
			System.err.println("SaveFile class has errified on itself.");
			e.printStackTrace();
		}
	}

	public static void saveFile() {
		if (System.nanoTime() - lLastCalledAt > L_MIN_TIME_BETWEEN_FILEOP) {
			// LOLTIME = System.nanoTime();
			String strToOutput = "";
			try {
				File saveFile = new File(STR_SAVEFILE_NAME);
				if (!saveFile.exists()) {
					saveFile.delete();
					saveFile.createNewFile();
				}
				// LOLTIME = System.nanoTime() - LOLTIME;
				// System.out.println("Time for Exist check: " + LOLTIME);
				// LOLTIME = System.nanoTime();
				PrintStream ps = new PrintStream(saveFile);
				strToOutput += ("Name(" + strPlayerName + ")" + newline);
				strToOutput += ("Gender(" + strPlayerGender + ")" + newline);
				strToOutput += ("TimePlayed(" + lTimePlayed + ")" + newline);
				strToOutput += ("Location(" + iLocation + ")" + newline);
				strToOutput += ("XLocation(" + iLocX + ")" + newline);
				strToOutput += ("YLocation(" + iLocY + ")" + newline);
				strToOutput += ("Battle(" + iBattle + ")" + newline);
				strToOutput += ("TrainerName(" + strTrainerName + ")" + newline);
				strToOutput += ("Win(" + iWin + ")" + newline);

				for (String output : pokemonParty) {
					strToOutput += ("PokemonParty(" + output + ")" + newline);
				}
				for (Integer output : pokemonLevels) {
					strToOutput += ("PokemonLevels(" + output + ")" + newline);
				}
				for (Integer output : pokemonExp) {
					strToOutput += ("PokemonExp(" + output + ")" + newline);
				}
				for (String output : pokemon1MoveSet) {
					strToOutput += ("Pokemon1MoveSet(" + output + ")" + newline);
				}
				for (Integer output : pokemon1Ivs) {
					strToOutput += ("Pokemon1IVsStats(" + output + ")" + newline);
				}
				for (Integer output : pokemonHp) {
					strToOutput += ("PokemonCurrentHp(" + output + ")" + newline);
				}
				for (Integer output : pokemonFullHp) {
					strToOutput += ("PokemonFullHp(" + output + ")" + newline);
				}

				for (String output : enemyParty) {
					strToOutput += ("EnemyParty(" + output + ")" + newline);
				}
				for (Integer output : enemyLevels) {
					strToOutput += ("EnemyLevels(" + output + ")" + newline);
				}
				for (String output : enemy1MoveSet) {
					strToOutput += ("Enemy1MoveSet(" + output + ")" + newline);
				}
				for (Integer output : enemy1Ivs) {
					strToOutput += ("Enemy1IVsStats(" + output + ")" + newline);
				}
				for (Integer output : iaGameVars) {
					strToOutput += ("GameVar(" + output + ")" + newline);
				}

				for (String output : stralBadges) {
					strToOutput += ("Badge(" + output + ")" + newline);
				}
				// LOLTIME = System.nanoTime() - LOLTIME;
				System.out.println("Saving...");

				// LOLTIME = System.nanoTime();
				ps.print(strToOutput);
				ps.close();
				// LOLTIME = System.nanoTime() - LOLTIME;
				// System.out.println("Time for PrintStreaming: " + LOLTIME);

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		lLastCalledAt = System.nanoTime();
	}

	/*
	 * public static int ccord(int cord){ return 300 - cord; }
	 */
}