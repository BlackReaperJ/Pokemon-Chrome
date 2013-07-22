package com.cvgstudios.pokemonchrome.images;

public abstract interface ImgPathConstants {

	static final String PIC_FOLDER = "Pictures";

	static final String SPRITES_PATH = PIC_FOLDER + "/Sprites";
	static final String MENU_PATH = PIC_FOLDER + "/Menu";
	static final String MAPS_PATH = PIC_FOLDER + "/Maps";
	
	static final String PLAYER_SPRITE_PATH = SPRITES_PATH + "/Player";
	static final String POKEMON_SPRITES_PATH = SPRITES_PATH + "/Pokemon";
	static final String POKEMONB_SPRITES_PATH = SPRITES_PATH + "/PokemonB";
	static final String SPRITES_MISC_PATH = SPRITES_PATH + "/Misc";
	static final String SPRITES_BATTLE_PATH = SPRITES_PATH + "/Battle";

	static final String NPC_MENU_PATH = MENU_PATH + "/NPC";
	static final String MAIN_MENU_PATH = MENU_PATH + "/MainMenu";
	static final String POKE_MENU_PATH = MENU_PATH + "/PokemonMenu";
	static final String STARTERS_MENU_PATH = MENU_PATH + "/Starters";

	static final String START_BATTLE_PATH = SPRITES_BATTLE_PATH
			+ "/BattleStart";
	static final String MENU_BATTLE_PATH = SPRITES_BATTLE_PATH + "/BattleMenu";
	static final String SPRITE_ATTACK_PATH = SPRITES_BATTLE_PATH + "/Attacks";

}