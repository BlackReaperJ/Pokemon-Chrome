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
	WelcomeBG("Pictures/Menu/MainMenu/WelcomeBG.png"), PokemonTitleMenuBG(
			"Pictures/Menu/MainMenu/PokemonTitleMenuBG.png"), PokemonMenuAll(
			"Pictures/Menu/PokemonMenu/PokemonMenuAll.png"), PokemonMenuContinue(
			"Pictures/Menu/PokemonMenu/PokemonMenuContinue.png"), PokemonMenuContinueSelected(
			"Pictures/Menu/PokemonMenu/PokemonMenuContinueSelected.png"), PokemonMenuAllSelected(
			"Pictures/Menu/PokemonMenu/PokemonMenuAllSelected.png"), TitleScreen(
			"Pictures/Menu/MainMenu/TitleScreen.png"),

	Professor("Pictures/Menu/NPC/Professor.png"), ProfessorFlip(
			"Pictures/Menu/NPC/ProfessorFlip.png"),

	FriendGirl("Pictures/Menu/PlayerPictures/FriendGirl.png"), FriendBoy(
			"Pictures/Menu/PlayerPictures/FriendBoy.png"), PlayerBoy(
			"Pictures/Menu/PlayerPictures/PlayerBoy.png"), PlayerGirl(
			"Pictures/Menu/PlayerPictures/PlayerGirl.png"), Male(
			"Pictures/Menu/PlayerPictures/Male.png"), Female(
			"Pictures/Menu/PlayerPictures/Female.png"), Credits(
			"Pictures/Menu/MainMenu/Credits.png"), Gender(
			"Pictures/Menu/PlayerPictures/Gender.png"),

	// Player sprites

	PlayerDown("Pictures/Sprites/Player/Down.png"), PlayerDown1(
			"Pictures/Sprites/Player/Down1.png"), PlayerDown2(
			"Pictures/Sprites/Player/Down2.png"), PlayerLeft(
			"Pictures/Sprites/Player/Left.png"), PlayerLeft1(
			"Pictures/Sprites/Player/Left1.png"), PlayerLeft2(
			"Pictures/Sprites/Player/Left2.png"), PlayerRight(
			"Pictures/Sprites/Player/Right.png"), PlayerRight1(
			"Pictures/Sprites/Player/Right1.png"), PlayerRight2(
			"Pictures/Sprites/Player/Right2.png"), PlayerUp(
			"Pictures/Sprites/Player/Up.png"), PlayerUp1(
			"Pictures/Sprites/Player/Up1.png"), PlayerUp2(
			"Pictures/Sprites/Player/Up2.png"),

	// NPC Sprites
	DadDown("Pictures/Sprites/NPC/Dad/DadDown.png"), DadRight(
			"Pictures/Sprites/NPC/Dad/DadRight.png"), BoyLeft(
			"Pictures/Sprites/NPC/Boy/BoyLeft.png"), BoyRight(
			"Pictures/Sprites/NPC/Boy/BoyRight.png"), BoyRight1(
			"Pictures/Sprites/NPC/Boy/BoyRight1.png"), BoyRight2(
			"Pictures/Sprites/NPC/Boy/BoyRight2.png"), BoyUp(
			"Pictures/Sprites/NPC/Boy/BoyUp.png"), BoyUp1(
			"Pictures/Sprites/NPC/Boy/BoyUp1.png"), BoyUp2(
			"Pictures/Sprites/NPC/Boy/BoyUp2.png"), DadUp(
			"Pictures/Sprites/NPC/Dad/DadUp.png"), DadLeft(
			"Pictures/Sprites/NPC/Dad/DadLeft.png"),

	GirlDown("Pictures/Sprites/NPC/Girl/GirlDown.png"), GirlRight(
			"Pictures/Sprites/NPC/Girl/GirlRight.png"), GirlLeft(
			"Pictures/Sprites/NPC/Girl/GirlLeft.png"), GateDown(
			"Pictures/Sprites/NPC/Gate/GateDown.png"), GateLeft(
			"Pictures/Sprites/NPC/Gate/GateLeft.png"), GateLeft1(
			"Pictures/Sprites/NPC/Gate/GateLeft1.png"), GateLeft2(
			"Pictures/Sprites/NPC/Gate/GateLeft2.png"), GateRight(
			"Pictures/Sprites/NPC/Gate/GateRight.png"), GateRight1(
			"Pictures/Sprites/NPC/Gate/GateRight1.png"), GateRight2(
			"Pictures/Sprites/NPC/Gate/GateRight2.png"), BoyDown(
			"Pictures/Sprites/NPC/Boy/BoyDown.png"),
			
	OldManDown("Pictures/Sprites/NPC/OldMan/OldManDown.png"),

	// NPC Effects
	Exclamation("Pictures/Sprites/Misc/Exclamation.png"),

	// Maps (the background, base thing)
	Exitium(MAPS_PATH + "/Exitium.png"), Route1(MAPS_PATH + "/Route1.png"), House1Top(
			MAPS_PATH + "House1Top.png"), House1Bot(
			MAPS_PATH + "House1Bot.png"), MiracleForest1(
			MAPS_PATH + "/MiracleForest1.png"), MiracleForest2(
			MAPS_PATH + "/MiracleForest2.png"),MapleLodge(
			MAPS_PATH + "/MapleLodge.png"),Route2(
			MAPS_PATH + "/Route2.png"), MiracleForest4(
			MAPS_PATH + "/MiracleForest4.png"), MiracleForest3(
			MAPS_PATH + "/MiracleForest3.png"), MiracleForest5(
			MAPS_PATH + "/MiracleForest5.png"), MiracleForest6(
			MAPS_PATH + "/MiracleForest6.png"), MiracleForest7(
			MAPS_PATH + "/MiracleForest7.png"),


	// Map decorations (the stuff you code on top of the map!)
	House1Overlay("Pictures/Sprites/Structures/House1Overlay.png"), House2Overlay(
			"Pictures/Sprites/Structures/House2Overlay.png"), House3Overlay(
			"Pictures/Sprites/Structures/House3Overlay.png"), House4Overlay(
			"Pictures/Sprites/Structures/House4Overlay.png"), Lamppost(
			"Pictures/Sprites/Structures/Lamppost.png"), MailBox(
			"Pictures/Sprites/Structures/MailBox.png"), MailBox2(
			"Pictures/Sprites/Structures/MailBox2.png"), ColumnTrees(
			"Pictures/Sprites/Structures/ColumnTrees.png"), Sign(
			"Pictures/Sprites/Misc/Sign.png"), GreenColumnTrees(
			"Pictures/Sprites/Structures/GreenColumnTrees.png"), GreenColumnTrees2(
			"Pictures/Sprites/Structures/GreenColumnTrees2.png"), GreenColumnTrees3(
			"Pictures/Sprites/Structures/GreenColumnTrees3.png"), ForestEntrance(
			"Pictures/Sprites/Structures/ForestEntrance.png"), GreenTreeOverlay(
			"Pictures/Sprites/Structures/GreenTreeOverlay.png"), LeftEntrance(
			"Pictures/Sprites/Structures/LeftEntrance.png"), RightEntrance(
			"Pictures/Sprites/Structures/RightEntrance.png"), FlashScreen(
			"Pictures/Sprites/Structures/FlashScreen.png"),	HorizontalLog(
			"Pictures/Sprites/Structures/HorizontalLog.png"), VerticalLog(
			"Pictures/Sprites/Structures/VerticalLog.png"),

	// GUI Things???
	Arrow("Pictures/Sprites/Misc/Arrow.png"), Hand(
			"Pictures/Sprites/Misc/Hand.png"), DialogBox(
			"Pictures/Sprites/Misc/DialogBox.png"), DialogBox2(
			"Pictures/Sprites/Misc/DialogBox2.png"), DialogBox3(
			"Pictures/Sprites/Misc/DialogBox3.png"), DialogBox4(
			"Pictures/Sprites/Misc/DialogBox4.png"),

	// I dont even know
	MainBattleBack("Pictures/Sprites/Battle/BattleStart/MainBattleBack.png"), Vs2(
			"Pictures/Sprites/Battle/BattleStart/Vs2.png"), MainHead(
			"Pictures/Sprites/Battle/BattleStart/MainHead.png"),

	// Battle Menu GUI things??
	GreenBackground("Pictures/Sprites/Battle/BattleMenu/GreenBackground.png"), BattleMenu2(
			"Pictures/Sprites/Battle/BattleMenu/BattleMenu2.png"), HpBarAlly(
			"Pictures/Sprites/Battle/BattleMenu/HpBarAlly.png"), HpBarEnemy(
			"Pictures/Sprites/Battle/BattleMenu/HpBarEnemy.png"), MoveMenu2(
			"Pictures/Sprites/Battle/BattleMenu/MoveMenu2.png"),

	// Natalie

	Natalie(NPC_MENU_PATH + "/Natalie.png"), NatalieHead(START_BATTLE_PATH
			+ "/NatalieHead.png"), NatalieBattleBack(MENU_BATTLE_PATH
			+ "/NatalieBattleBack.png"),

	PlayerFlashNormal(START_BATTLE_PATH
			+ "/BattleStart/Player_flash_normal.gif"), OpponentFlashNormal(
			START_BATTLE_PATH + "/Battle/BattleStart/Opponent_flash_normal.gif"),

	MainThrow(PLAYER_SPRITE_PATH + "/MainThrow.png"), MainThrow1(
			PLAYER_SPRITE_PATH + "/MainThrow1.png"), MainThrow2(
			PLAYER_SPRITE_PATH + "/MainThrow2.png"),

	Tackle(SPRITE_ATTACK_PATH + "/Tackle.png"), BlackBack(SPRITE_ATTACK_PATH
			+ "/BlackBack.png"), Growl(SPRITE_ATTACK_PATH + "/Growl.png"), Leer(
			SPRITE_ATTACK_PATH + "/Leer.png"),

	Cosmet(SPRITES_PATH + "/Cosmet.png"), CosmetB(POKEMONB_SPRITES_PATH
			+ "/CosmetB.png"), CosmetStart(STARTERS_MENU_PATH
			+ "/CosmetStart.png"),

	Tykepol(POKEMON_SPRITES_PATH + "/Tykepol.png"), TykepolB(
			POKEMONB_SPRITES_PATH + "/TykepolB.png"), TykepolStart(
			STARTERS_MENU_PATH + "/TykepolStart.png"),

	Embite(POKEMON_SPRITES_PATH + "/Embite.png"), EmbiteB(POKEMONB_SPRITES_PATH
			+ "/EmbiteB.png"), EmbiteStart(STARTERS_MENU_PATH
			+ "/EmbiteStart.png"),

	Pokeball(SPRITES_MISC_PATH + "/Pokeball.png"), Pokeball4(SPRITES_MISC_PATH
			+ "/Pokeball4.gif"),

	Outline1(MENU_BATTLE_PATH + "/Outline1.png"), Outline2(MENU_BATTLE_PATH
			+ "/Outline2.png"), Outline3(MENU_BATTLE_PATH + "/Outline3.png"), Outline4(
			MENU_BATTLE_PATH + "/Outline4.png"),
;
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
