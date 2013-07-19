package com.cvgstudios.pokemonchrome.images;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Method to import Images.
 * 
 * @param needs
 *            to be in the Pictures folder at least for the image to be imported
 *            must be an operation that has registered itself with the object
 * @return imported Images that are imported
 */
public enum Images implements ImgPathConstants {

	// Menu stuff. I don't know how to organize it. You do it.
	WelcomeBG(MAIN_MENU_PATH + "/WelcomeBG.png"), PokemonTitleMenuBG(
			MAIN_MENU_PATH + "/PokemonTitleMenuBG.png"), PokemonMenuAll(
			POKE_MENU_PATH + "/PokemonMenuAll.png"), PokemonMenuContinue(
			POKE_MENU_PATH + "/PokemonMenuContinue.png"), PokemonMenuContinueSelected(
			POKE_MENU_PATH + "/PokemonMenuContinueSelected.png"), PokemonMenuAllSelected(
			POKE_MENU_PATH + "/PokemonMenuAllSelected.png"), TitleScreen(
			MAIN_MENU_PATH + "/TitleScreen.png"),

	Professor(NPC_MENU_PATH + "/Professor.png"), ProfessorFlip(NPC_MENU_PATH
			+ "/ProfessorFlip.png"),

	FriendGirl(PPICS_MENU_PATH + "/FriendGirl.png"), FriendBoy(PPICS_MENU_PATH
			+ "/FriendBoy.png"), PlayerBoy(PPICS_MENU_PATH + "/PlayerBoy.png"), PlayerGirl(
			PPICS_MENU_PATH + "/PlayerGirl.png"), Male(PPICS_MENU_PATH
			+ "/Male.png"), Female(PPICS_MENU_PATH + "/Female.png"), Credits(
			MAIN_MENU_PATH + "/Credits.png"), Gender(PPICS_MENU_PATH
			+ "/Gender.png"),

	// Player sprites

	PlayerDown(PLAYER_SPRITE_PATH + "/Down.png"), PlayerDown1(
			PLAYER_SPRITE_PATH + "/Down1.png"), PlayerDown2(PLAYER_SPRITE_PATH
			+ "/Down2.png"), PlayerLeft(PLAYER_SPRITE_PATH + "/Left.png"), PlayerLeft1(
			PLAYER_SPRITE_PATH + "/Left1.png"), PlayerLeft2(PLAYER_SPRITE_PATH
			+ "/Left2.png"), PlayerRight(PLAYER_SPRITE_PATH + "/Right.png"), PlayerRight1(
			PLAYER_SPRITE_PATH + "/Right1.png"), PlayerRight2(
			PLAYER_SPRITE_PATH + "/Right2.png"), PlayerUp(PLAYER_SPRITE_PATH
			+ "/Up.png"), PlayerUp1(PLAYER_SPRITE_PATH + "/Up1.png"), PlayerUp2(
			PLAYER_SPRITE_PATH + "/Up2.png"),

	// NPC Sprites
	DadDown(DAD_NPC_SPRITES_PATH + "/DadDown.png"), DadRight(
			DAD_NPC_SPRITES_PATH + "/DadRight.png"), BoyLeft(
			BOY_NPC_SPRITES_PATH + "/BoyLeft.png"), BoyRight(
			BOY_NPC_SPRITES_PATH + "/BoyRight.png"), BoyRight1(
			BOY_NPC_SPRITES_PATH + "/BoyRight1.png"), BoyRight2(
			BOY_NPC_SPRITES_PATH + "/BoyRight2.png"), BoyUp(
			BOY_NPC_SPRITES_PATH + "/BoyUp.png"), BoyUp1(BOY_NPC_SPRITES_PATH
			+ "/BoyUp1.png"), BoyUp2(BOY_NPC_SPRITES_PATH + "/BoyUp2.png"), DadUp(
			DAD_NPC_SPRITES_PATH + "/DadUp.png"), DadLeft(DAD_NPC_SPRITES_PATH
			+ "/DadLeft.png"),

	GirlDown(GIRL_NPC_SPRITES_PATH + "/GirlDown.png"), GirlRight(
			GIRL_NPC_SPRITES_PATH + "/GirlRight.png"), GirlLeft(
			GIRL_NPC_SPRITES_PATH + "/GirlLeft.png"), GateDown(
			GATE_NPC_SPRITES_PATH + "/GateDown.png"), GateLeft(
			GATE_NPC_SPRITES_PATH + "/GateLeft.png"), GateLeft1(
			GATE_NPC_SPRITES_PATH + "/GateLeft1.png"), GateLeft2(
			GATE_NPC_SPRITES_PATH + "/GateLeft2.png"), GateRight(
			GATE_NPC_SPRITES_PATH + "/GateRight.png"), GateRight1(
			GATE_NPC_SPRITES_PATH + "/GateRight1.png"), GateRight2(
			GATE_NPC_SPRITES_PATH + "/GateRight2.png"), BoyDown(
			BOY_NPC_SPRITES_PATH + "/BoyDown.png"),

	// NPC Effects
	Exclamation(MISC_SPRITES_PATH + "/Exclamation.png"),

	// Maps (the background, base thing)
	Exitium(MAP_PATH + "/Exitium.png"), Route1(MAP_PATH + "/Route1.png"), House1Top(
			MAP_PATH + "/House1Top.png"), House1Bot(MAP_PATH + "/House1Bot.png"), MiracleForest1(
			MAP_PATH + "/MiracleForest1.png"), MiracleForest2(MAP_PATH
			+ "/MiracleForest2.png"), MapleLodge("MapleLodge.png"),

	// Map decorations (the stuff you code on top of the map!)
	House1Overlay(STUCTURES_SPRITES_PATH + "/House1Overlay.png"), House2Overlay(
			STUCTURES_SPRITES_PATH + "/House2Overlay.png"), House3Overlay(
			STUCTURES_SPRITES_PATH + "/House3Overlay.png"), House4Overlay(
			STUCTURES_SPRITES_PATH + "/House4Overlay.png"), Lamppost(
			STUCTURES_SPRITES_PATH + "/Lamppost.png"), MailBox(
			STUCTURES_SPRITES_PATH + "/MailBox.png"), MailBox2(
			STUCTURES_SPRITES_PATH + "/MailBox2.png"), ColumnTrees(
			STUCTURES_SPRITES_PATH + "/ColumnTrees.png"),

	Sign(MISC_SPRITES_PATH + "/Sign.png"),

	GreenColumnTrees(STUCTURES_SPRITES_PATH + "/GreenColumnTrees.png"), GreenColumnTrees2(
			STUCTURES_SPRITES_PATH + "/GreenColumnTrees2.png"), GreenColumnTrees3(
			STUCTURES_SPRITES_PATH + "/GreenColumnTrees3.png"), ForestEntrance(
			STUCTURES_SPRITES_PATH + "/ForestEntrance.png"), GreenTreeOverlay(
			STUCTURES_SPRITES_PATH + "/GreenTreeOverlay.png"), LeftEntrance(
			STUCTURES_SPRITES_PATH + "/LeftEntrance.png"), RightEntrance(
			STUCTURES_SPRITES_PATH + "/RightEntrance.png"),

	// GUI Things???
	Arrow(MISC_SPRITES_PATH + "/Arrow.png"), Hand(MISC_SPRITES_PATH
			+ "/Hand.png"), DialogBox(MISC_SPRITES_PATH + "/DialogBox.png"), DialogBox2(
			MISC_SPRITES_PATH + "/DialogBox2.png"), DialogBox3(
			MISC_SPRITES_PATH + "/DialogBox3.png"), DialogBox4(
			MISC_SPRITES_PATH + "/DialogBox4.png"),

	// I dont even know
	MainBattleBack(START_BATTLE_PATH + "/MainBattleBack.png"), Vs2(
			START_BATTLE_PATH + "/Vs2.png"), MainHead(START_BATTLE_PATH
			+ "/MainHead.png"),

	// Battle Menu GUI things??
	GreenBackground(MENU_BATTLE_PATH + "/GreenBackground.png"), BattleMenu2(
			MENU_BATTLE_PATH + "/BattleMenu2.png"), HpBarAlly(MENU_BATTLE_PATH
			+ "/HpBarAlly.png"), HpBarEnemy(MENU_BATTLE_PATH
			+ "/HpBarEnemy.png"), MoveMenu2(MENU_BATTLE_PATH + "/MoveMenu2.png"),

	// Natalie

	Natalie(NPC_MENU_PATH + "/Natalie.png"), NatalieHead(START_BATTLE_PATH
			+ "/NatalieHead.png"), NatalieBattleBack(START_BATTLE_PATH
			+ "/NatalieBattleBack.png"),

	PlayerFlashNormal(START_BATTLE_PATH + "/Player_flash_normal.gif"), OpponentFlashNormal(
			START_BATTLE_PATH + "/Opponent_flash_normal.gif"),

	MainThrow(PLAYER_SPRITE_PATH + "/MainThrow.png"), MainThrow1(
			PLAYER_SPRITE_PATH + "/MainThrow1.png"), MainThrow2(
			PLAYER_SPRITE_PATH + "/MainThrow2.png"),

	Tackle(SPRITE_ATTACK_PATH + "/Tackle.png"), BlackBack(SPRITE_ATTACK_PATH
			+ "/BlackBack.png"), Growl(SPRITE_ATTACK_PATH + "/Growl.png"), Leer(
			SPRITE_ATTACK_PATH + "/Leer.png"),

	Cosmet(POKEMON_SPRITES_PATH + "/Cosmet.png"), CosmetB(POKEMONB_SPRITES_PATH
			+ "/CosmetB.png"), CosmetStart(STARTERS_MENU_PATH
			+ "/CosmetStart.png"),

	Tykepol(POKEMON_SPRITES_PATH + "/Tykepol.png"), TykepolB(
			POKEMONB_SPRITES_PATH + "/TykepolB.png"), TykepolStart(
			STARTERS_MENU_PATH + "/TykepolStart.png"),

	Embite(POKEMON_SPRITES_PATH + "/Embite.png"), EmbiteB(POKEMONB_SPRITES_PATH
			+ "/EmbiteB.png"), EmbiteStart(STARTERS_MENU_PATH
			+ "/EmbiteStart.png"),

	Pokeball(MISC_SPRITES_PATH + "/Pokeball.png"), Pokeball4(MISC_SPRITES_PATH
			+ "/Pokeball4.gif"),

	Outline1(MENU_BATTLE_PATH + "/Outline1.png"), Outline2(MENU_BATTLE_PATH
			+ "/Outline2.png"), Outline3(MENU_BATTLE_PATH + "/Outline3.png"), Outline4(
			MENU_BATTLE_PATH + "/Outline4.png");

	private String filePath;
	private Image image;
	private boolean imageLoaded;

	private Images(String imagePath) {
		filePath = imagePath;
		imageLoaded = false;

	}

	public Image getImage() {
		if (!imageLoaded) {
			loadImage();
		}
		return image;

	}

	public void loadImage() {
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.err.println("Failed to load image!");
			e.printStackTrace();
		}
		imageLoaded = true;
	}
}
