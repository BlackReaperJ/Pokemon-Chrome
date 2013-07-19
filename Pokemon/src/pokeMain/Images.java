package pokeMain;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum Images{
	//Menu stuff. I don't know how to organize it. You do it.
	WelcomeBG("Pictures/Menu/MainMenu/WelcomeBG.png"),
	PokemonTitleMenuBG("Pictures/Menu/MainMenu/PokemonTitleMenuBG.png"),
	PokemonMenuAll("Pictures/Menu/PokemonMenu/PokemonMenuAll.png"),
	PokemonMenuContinue("Pictures/Menu/PokemonMenu/PokemonMenuContinue.png"),
	PokemonMenuContinueSelected("Pictures/Menu/PokemonMenu/PokemonMenuContinueSelected.png"),
	PokemonMenuAllSelected("Pictures/Menu/PokemonMenu/PokemonMenuAllSelected.png"),
	TitleScreen("Pictures/Menu/MainMenu/TitleScreen.png"),

	Professor("Pictures/Menu/NPC/Professor.png"),
	ProfessorFlip("Pictures/Menu/NPC/ProfessorFlip.png"),

	FriendGirl("Pictures/Menu/PlayerPictures/FriendGirl.png"),
	FriendBoy("Pictures/Menu/PlayerPictures/FriendBoy.png"),
	PlayerBoy("Pictures/Menu/PlayerPictures/PlayerBoy.png"),
	PlayerGirl("Pictures/Menu/PlayerPictures/PlayerGirl.png"),
	Male("Pictures/Menu/PlayerPictures/Male.png"),
	Female("Pictures/Menu/PlayerPictures/Female.png"),
	Credits("Pictures/Menu/MainMenu/Credits.png"),
	Gender("Pictures/Menu/PlayerPictures/Gender.png"),



	//Player sprites
	PlayerDown("Pictures/Sprites/Player/Down.png"),
	PlayerDown1("Pictures/Sprites/Player/Down1.png"),
	PlayerDown2("Pictures/Sprites/Player/Down2.png"),
	PlayerLeft("Pictures/Sprites/Player/Left.png"),
	PlayerLeft1("Pictures/Sprites/Player/Left1.png"),
	PlayerLeft2("Pictures/Sprites/Player/Left2.png"),
	PlayerRight("Pictures/Sprites/Player/Right.png"),
	PlayerRight1("Pictures/Sprites/Player/Right1.png"),
	PlayerRight2("Pictures/Sprites/Player/Right2.png"),
	PlayerUp("Pictures/Sprites/Player/Up.png"),
	PlayerUp1("Pictures/Sprites/Player/Up1.png"),
	PlayerUp2("Pictures/Sprites/Player/Up2.png"),

	//NPC Sprites
	DadDown("Pictures/Sprites/NPC/Dad/DadDown.png"),
	DadRight("Pictures/Sprites/NPC/Dad/DadRight.png"),
	BoyLeft("Pictures/Sprites/NPC/Boy/BoyLeft.png"),
	BoyRight("Pictures/Sprites/NPC/Boy/BoyRight.png"),
	BoyRight1("Pictures/Sprites/NPC/Boy/BoyRight1.png"),
	BoyRight2("Pictures/Sprites/NPC/Boy/BoyRight2.png"),
	BoyUp("Pictures/Sprites/NPC/Boy/BoyUp.png"),
	BoyUp1("Pictures/Sprites/NPC/Boy/BoyUp1.png"),
	BoyUp2("Pictures/Sprites/NPC/Boy/BoyUp2.png"),
	DadUp("Pictures/Sprites/NPC/Dad/DadUp.png"),
	DadLeft("Pictures/Sprites/NPC/Dad/DadLeft.png"),

	GirlDown("Pictures/Sprites/NPC/Girl/GirlDown.png"),
	GirlRight("Pictures/Sprites/NPC/Girl/GirlRight.png"),
	GirlLeft("Pictures/Sprites/NPC/Girl/GirlLeft.png"),
	GateDown("Pictures/Sprites/NPC/Gate/GateDown.png"),
	GateLeft("Pictures/Sprites/NPC/Gate/GateLeft.png"),
	GateLeft1("Pictures/Sprites/NPC/Gate/GateLeft1.png"),
	GateLeft2("Pictures/Sprites/NPC/Gate/GateLeft2.png"),
	GateRight("Pictures/Sprites/NPC/Gate/GateRight.png"),
	GateRight1("Pictures/Sprites/NPC/Gate/GateRight1.png"),
	GateRight2("Pictures/Sprites/NPC/Gate/GateRight2.png"),
	BoyDown("Pictures/Sprites/NPC/Boy/BoyDown.png"),


	//NPC Effects
	Exclamation("Pictures/Sprites/Misc/Exclamation.png"),


	//Maps (the background, base thing)
	Exitium("Pictures/Maps/Exitium.png"),
	Route1("Pictures/Maps/Route1.png"),
	House1Top("Pictures/Maps/House1Top.png"),
	House1Bot("Pictures/Maps/House1Bot.png"),
	MiracleForest1("Pictures/Maps/MiracleForest1.png"),
	
	//Map decorations (the stuff you code on top of the map!)
	House1Overlay("Pictures/Sprites/Structures/House1Overlay.png"),
	House2Overlay("Pictures/Sprites/Structures/House2Overlay.png"),
	House3Overlay("Pictures/Sprites/Structures/House3Overlay.png"),
	House4Overlay("Pictures/Sprites/Structures/House4Overlay.png"),
	Lamppost("Pictures/Sprites/Structures/Lamppost.png"),
	MailBox("Pictures/Sprites/Structures/MailBox.png"),
	MailBox2("Pictures/Sprites/Structures/MailBox2.png"),
	ColumnTrees("Pictures/Sprites/Structures/ColumnTrees.png"),
	Sign("Pictures/Sprites/Misc/Sign.png"),
	GreenColumnTrees("Pictures/Sprites/Structures/GreenColumnTrees.png"),
	ForestEntrance("Pictures/Sprites/Structures/ForestEntrance.png"),
	GreenTreeOverlay("Pictures/Sprites/Structures/GreenTreeOverla.png"),




	//GUI Things???
	Arrow("Pictures/Sprites/Misc/Arrow.png"),
	Hand("Pictures/Sprites/Misc/Hand.png"),
	DialogBox("Pictures/Sprites/Misc/DialogBox.png"),
	DialogBox2("Pictures/Sprites/Misc/DialogBox2.png"),
	DialogBox3("Pictures/Sprites/Misc/DialogBox3.png"),
	DialogBox4("Pictures/Sprites/Misc/DialogBox4.png"),

	//I dont even know
	MainBattleBack("Pictures/Sprites/Battle/BattleStart/MainBattleBack.png"),
	Vs2("Pictures/Sprites/Battle/BattleStart/Vs2.png"),
	MainHead("Pictures/Sprites/Battle/BattleStart/MainHead.png"),

	//Battle Menu GUI things??
	GreenBackground("Pictures/Sprites/Battle/BattleMenu/GreenBackground.png"),
	BattleMenu2("Pictures/Sprites/Battle/BattleMenu/BattleMenu2.png"),
	HpBarAlly("Pictures/Sprites/Battle/BattleMenu/HpBarAlly.png"),
	HpBarEnemy("Pictures/Sprites/Battle/BattleMenu/HpBarEnemy.png"),
	MoveMenu2("Pictures/Sprites/Battle/BattleMenu/MoveMenu2.png"),



	//Natalie
	Natalie("Pictures/Menu/NPC/Natalie.png"),
	NatalieHead("Pictures/Sprites/Battle/BattleStart/NatalieHead.png"),
	NatalieBattleBack("Pictures/Sprites/Battle/BattleStart/NatalieBattleBack.png"),

	//Flashing
	PlayerFlashNormal("Pictures/Sprites/Battle/BattleStart/Player_flash_normal.gif"),
	OpponentFlashNormal("Pictures/Sprites/Battle/BattleStart/Opponent_flash_normal.gif"),

	//Throwing Animation
	MainThrow("Pictures/Sprites/Player/MainThrow.png"),
	MainThrow1("Pictures/Sprites/Player/MainThrow1.png"),
	MainThrow2("Pictures/Sprites/Player/MainThrow2.png"),



	//Attack Effects
	Tackle("Pictures/Sprites/Battle/Attacks/Tackle.png"),
	BlackBack("Pictures/Sprites/Battle/Attacks/BlackBack.png"),
	Growl("Pictures/Sprites/Battle/Attacks/Growl.png"),
	Leer("Pictures/Sprites/Battle/Attacks/Leer.png"),

	//POKEMONS
	Cosmet("Pictures/Sprites/Pokemon/Cosmet.png"),
	CosmetB("Pictures/Sprites/PokemonB/CosmetB.png"),
	CosmetStart("Pictures/Menu/Starters/CosmetStart.png"),

	Tykepol("Pictures/Sprites/Pokemon/Tykepol.png"),
	TykepolB("Pictures/Sprites/PokemonB/TykepolB.png"),
	TykepolStart("Pictures/Menu/Starters/TykepolStart.png"),

	Embite("Pictures/Sprites/Pokemon/Embite.png"),
	EmbiteB("Pictures/Sprites/PokemonB/EmbiteB.png"),
	EmbiteStart("Pictures/Menu/Starters/EmbiteStart.png"),

	//Balls
	Pokeball("Pictures/Sprites/Misc/Pokeball.png"),
	Pokeball4("Pictures/Sprites/Misc/Pokeball4.gif"),

	//Outlines
	Outline1("Pictures/Sprites/Battle/BattleMenu/Outline1.png"),
	Outline2("Pictures/Sprites/Battle/BattleMenu/Outline2.png"),
	Outline3("Pictures/Sprites/Battle/BattleMenu/Outline3.png"),
	Outline4("Pictures/Sprites/Battle/BattleMenu/Outline4.png")

	;











	private String filePath;
	private Image image;
	private boolean imageLoaded;


	private Images(String imagePath){
		filePath = imagePath;
		imageLoaded = false;
	}

	public Image getImage(){
		if (!imageLoaded){
			loadImage();
		}

		return image;

	}

	public void loadImage(){
		try {
			image = ImageIO.read(new File(filePath));
		} catch (IOException e) {
			System.err.println("Failed to load image!");
			e.printStackTrace();
		}
		imageLoaded = true;
	}

}