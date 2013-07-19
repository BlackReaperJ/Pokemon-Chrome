package pokeMain;

public class PokemonStats{
	public static int baseHp, baseAtk, baseDef, baseSpAtk, baseSpDef, baseSpeed;//Pokemon Base Stats
	public static String type = "";
	public static int statAtk, statDef, statSpAtk, statSpDef, statSpeed;//Pokemon Final Stats
	public static double atkPercent = 1, defPercent = 1, spAtkPercent =1, spDefPercent =1, speedPercent=1;
	public static int stgAtk =0, stgDef =0, stgSpAtk =0, stgSpDef =0, stgSpeed =0;

	public void pokemonStats(){//Determines pokemon initial stats and types
		if(GameFile.pokemonParty[0].equals("Tykepol")){//Using Turtwig base stats
			type = "Fight";
			baseHp = 55;
			baseAtk = 68;
			baseDef = 64;
			baseSpAtk = 45;
			baseSpDef = 55;
			baseSpeed = 31;
		}
		else if(GameFile.pokemonParty[0].equals("Cosmet")){//Using Treecko Hp +5 Def +3 base stats
			type = "Psychic";
			baseHp = 45;
			baseAtk = 45;
			baseDef = 38;
			baseSpAtk = 65;
			baseSpDef = 55;
			baseSpeed = 70;
		}
		else if(GameFile.pokemonParty[0].equals("Embite")){//Using Torchic base stats
			type = "Dark";
			baseHp = 45;
			baseAtk = 60;
			baseDef = 40;
			baseSpAtk = 70;
			baseSpDef = 50;
			baseSpeed = 45;
		}
	}

	public void pokemonFinalStats(int pokeDmg, double atkPercent, double defPercent){
		GameFile.pokemonFullHp[0] = (int)(((double)((GameFile.pokemon1Ivs[0] + (2 * baseHp) + 100) * GameFile.pokemonLevels[0]) / 100) + 10);
		statAtk = (int)((((double)((GameFile.pokemon1Ivs[1] + (2 * baseAtk)) * GameFile.pokemonLevels[0]) / 100) + 5) * atkPercent);
		statDef = (int)((((double)((GameFile.pokemon1Ivs[2] + (2 * baseDef)) * GameFile.pokemonLevels[0]) / 100) + 5)  * defPercent);
		statSpAtk = (int)((((double)((GameFile.pokemon1Ivs[3] + (2 * baseSpAtk)) * GameFile.pokemonLevels[0]) / 100) + 5)  * spAtkPercent);
		statSpDef = (int)((((double)((GameFile.pokemon1Ivs[4] + (2 * baseSpDef)) * GameFile.pokemonLevels[0]) / 100) + 5) * spDefPercent) ;
		statSpeed = (int)((((double)((GameFile.pokemon1Ivs[5] + (2 * baseSpeed)) * GameFile.pokemonLevels[0]) / 100) + 5)  * speedPercent);
		GameFile.pokemonHp[0] = GameFile.pokemonFullHp[0] - pokeDmg;
		if(GameFile.pokemonHp[0] <0){
			GameFile.pokemonHp[0] =0;
		}
	}

	public void statStages(int stgAtk, int stgDef){
		switch(stgAtk){
		case(-6): atkPercent = 0.25; break;
		case(-5): atkPercent = 0.29; break;
		case(-4): atkPercent = 0.33; break;
		case(-3): atkPercent = 0.40; break;
		case(-2): atkPercent = 0.50; break;
		case(-1): atkPercent = 0.67; break;
		case(0): atkPercent = 1; break;
		case(1): atkPercent = 1.5; break;
		case(2): atkPercent = 2.0; break;
		case(3): atkPercent = 2.5; break;
		case(4): atkPercent = 3.0; break;
		case(5): atkPercent = 3.5; break;
		case(6): atkPercent = 4.0; break;
		}

		switch(stgDef){
		case(-6): defPercent = 0.25; break;
		case(-5): defPercent = 0.29; break;
		case(-4): defPercent = 0.33; break;
		case(-3): defPercent = 0.40; break;
		case(-2): defPercent = 0.50; break;
		case(-1): defPercent = 0.67; break;
		case(0): defPercent = 1; break;
		case(1): defPercent = 1.5; break;
		case(2): defPercent = 2.0; break;
		case(3): defPercent = 2.5; break;
		case(4): defPercent = 3.0; break;
		case(5): defPercent = 3.5; break;
		case(6): defPercent = 4.0; break;
		}
	}
}