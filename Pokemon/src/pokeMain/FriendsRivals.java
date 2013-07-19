package pokeMain;

import javax.swing.JFrame; 
import java.awt.*;
import java.net.URL;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class FriendsRivals extends JFrame implements ActionListener{
	ClassLoader cl = FriendsRivals.class.getClassLoader();

	private Image dbImage;
	private Graphics dbg;//double buffer
	int sceneX, sceneY, trainerX, trainerY, pokeballX, pokeballY, flashX, throwX, throwY;//Timer Variables for animations
	static int battle =0; 
	int speechTrainer = 0, speechFriend =0, speechWild =0, friendEnemy =0, pkThrow =0, speechThrow =0, handPosition =0, attackPosition= 0;
	Image cosmet, tykepol, embite, greenBackGround, battleMenu, hpBarAlly, hpBarEnemy, tykepolB, dialog4, natalie, pokeball4,flash, playFlash, mainThrow, mainThrow1,mainThrow2, outline1, moveMenu, leer;//Image Variables
	Image cosmetB, embiteB, tackle, blackBack, growl, outline2, outline3, outline4;
	String type, enemyType, atkType, enemyAtkType, statChange = "", enemyStatChange;
	int baseHp, baseAtk, baseDef, baseSpAtk, baseSpDef, baseSpeed;//Pokemon Base Stats
	int statAtk, statDef, statSpAtk, statSpDef, statSpeed;//Pokemon Final Stats
	int enemyStatHp,enemyHp, enemyStatAtk, enemyStatDef, enemyStatSpAtk, enemyStatSpDef, enemyStatSpeed;//May need take out
	int enemyStgAtk =0, enemyStgDef =0, enemyStgSpAtk =0, enemyStgSpDef =0, enemyStgSpeed =0;//May need to take out
	int atkPower, critical, pokeDmg, dmg, enemyDmg =0, enemyAtkPower,dmgTake,enemyCritical;
	double stab, typeEffect, modifier, enemyStab, enemyTypeEffect, enemyModifier;//Criteria for the damage formulas
	int stgAtk =0, stgDef =0, stgSpAtk =0, stgSpDef =0, stgSpeed =0;
	double atkPercent = 1, defPercent = 1, spAtkPercent =1, spDefPercent =1, speedPercent=1;
	int ai, animation, animationEnemy =0, pokemonAnimation =0, enemyAnimation =0, expType =0, expGain, expReq, enemyExp, experience;
	int tackleX, tailWhipY, leerX, leerY,growlX; //Pokemon Attacks
	int enemyTackleX, enemyLeerX, enemyLeerY, enemyTailWhipX, enemyGrowlX; //Enemy Attacks
	double battleExp =0;
	Random r = new Random();
	File f = new File("PokemonFont.ttf");
	FileInputStream in = new FileInputStream(f);
	Font dFont = Font.createFont(Font.TRUETYPE_FONT, in);//Allows the font to change to Pokemon Font
	Font f1 = dFont.deriveFont(35f), f2 = dFont.deriveFont(50f), f3 = dFont.deriveFont(33f);//Changes the size of the font
	Timer tmrScene = new Timer (10, this);//Creates a timer variable
	EnemyStats enemyStats = new EnemyStats();//Creates a variable for the EnemeyStats Class
	PokemonStats pokemonStats = new PokemonStats();
	PokeExperience pokeExperience = new PokeExperience();
	PokemonDmg pokemonDmg = new PokemonDmg();
	CompAi compAi = new CompAi();
	EnemyDmg enemyDmgs = new EnemyDmg();

	public static boolean battleDone = false;
	static FriendsRivals theBattleScreen;
	
	
	public static void main(String[ ] args) throws Exception{
		renameThisMethodJuliusUsingAltShiftR();
	}

	public static void renameThisMethodJuliusUsingAltShiftR() throws Exception{
		theBattleScreen = new FriendsRivals();
//
//		//I DONT KNOW WHAT IM DOING
//				while (true){
//					if(GameFile.iLocation ==2 && battle ==6){
//						Exitium go =  new Exitium();
//						mainMenu.setVisible(false);
//						GameFile.iaGameVars[3] = 13;
//						GameFile.iaGameVars[4] = 1;
//						break;
//					}
//				}
//			

	}
	
	public static void tearItDoooooooooooown(){
		theBattleScreen.setVisible(false);
		theBattleScreen.removeAll();
		theBattleScreen = null;
	}

	public FriendsRivals()throws Exception{//Constructor for FriendsRivals
		cosmet = Images.Cosmet.getImage();
		tykepol = Images.Tykepol.getImage();
		embite = Images.Embite.getImage();
		greenBackGround = Images.GreenBackground.getImage();
		battleMenu = Images.BattleMenu2.getImage();
		hpBarAlly = Images.HpBarAlly.getImage();
		hpBarEnemy = Images.HpBarEnemy.getImage();
		tykepolB = Images.TykepolB.getImage();
		dialog4 = Images.DialogBox4.getImage();
		natalie = Images.Natalie.getImage();
		pokeball4 = Images.Pokeball4.getImage();
		flash = Images.OpponentFlashNormal.getImage();
		mainThrow = Images.MainThrow.getImage();
		mainThrow1 = Images.MainThrow1.getImage();
		mainThrow2 = Images.MainThrow2.getImage();
		outline1 = Images.Outline1.getImage();
		moveMenu = Images.MoveMenu2.getImage();
		leer = Images.Leer.getImage();
		cosmetB = Images.CosmetB.getImage();
		embiteB = Images.EmbiteB.getImage();
		tackle = Images.Tackle.getImage();
		blackBack = Images.BlackBack.getImage();
		growl = Images.Growl.getImage();
		playFlash = Images.PlayerFlashNormal.getImage();
		outline2 = Images.Outline2.getImage();
		outline3 = Images.Outline3.getImage();
		outline4 = Images.Outline4.getImage();

		addKeyListener(new AL());
		setTitle("Pokemon Chrome");//Sets the Title
		setSize(700, 700);//Size of Window
		setResizable(false);//Cannot resize the window
		setVisible(true);//Makes it visible
		setBackground(Color.BLACK);//Sets background colour to black
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new musicPlayPoke("Music/Shingeki.wav").start();

		GameFile.loadFile();//Loads the GameFile

		GameFile.pokemonParty[0] = "";
		GameFile.enemyParty[0] = "";
		GameFile.enemy1MoveSet[ai] = "";
		GameFile.pokemon1MoveSet[attackPosition] = "";
		enemyType = "";// i PUT THIS
		GameFile.strTrainerName = "";
		GameFile.loadFile();//Loads the GameFile

	} 
	public void actionPerformed(ActionEvent e){
		if(battle == 0 && sceneX < 700) {//Moving Background
			sceneX = sceneX +10;
			sceneY = sceneY +5; 
		}

		if(speechFriend ==3 && trainerX <50) {//Moving Enemy Trainer
			trainerX = trainerX + 5;
			trainerY = trainerY + 5;
		}
		if(speechFriend ==4 && pokeballX <100){//Moving Pokeball
			pokeballX = pokeballX + 10;
			pokeballY = pokeballY + 15; 
		}
		if(speechFriend ==5 && flashX <300 || speechFriend ==6 && flashX <600){//Flash Image
			flashX = flashX + 5;
		}
		if(pkThrow ==1 && speechThrow <=3){//Throwing Animation
			throwX = throwX + 2;
		}
		if(speechThrow ==4){//Throwing Pokeball parabola animation
			throwX = throwX + 2;
			throwY = (120- (int)((0.1) * (throwX - 50)* (throwX - 50)));
			//      throwX = throwX + 1;
			//      throwY = (120- (int)((0.05) * (throwX - 50)*2 (throwX - 50)));
			if(speechThrow ==4 && flashX <300 && throwX >= 600){
				flashX = flashX + 5;
			}
		}
		if(speechThrow ==5 && flashX < 450){//Another flash image
			flashX = flashX + 5;
		}

		if(pokemonAnimation >=0 && battle ==2 && enemyStats.enemyStatSpeed <= pokemonStats.statSpeed || pokemonAnimation >=0 && battle ==3 && enemyStats.enemyStatSpeed > pokemonStats.statSpeed){//Pokemon Attack Animation
			animation = animation  + 1;
		}
		if(enemyAnimation >=0 && battle ==2 && enemyStats.enemyStatSpeed > pokemonStats.statSpeed || enemyAnimation >=0 && battle ==3 && enemyStats.enemyStatSpeed <= pokemonStats.statSpeed){//Enemy Attack Animation
			animationEnemy = animationEnemy  + 1;
		}
		if(GameFile.enemy1MoveSet[compAi.ai].equals("Tackle") && enemyAnimation ==1 && enemyTackleX <30){
			enemyTackleX = enemyTackleX + 3;
		}
		if(GameFile.enemy1MoveSet[compAi.ai].equals("Tackle") && enemyAnimation ==3 && enemyTackleX >0){
			enemyTackleX = enemyTackleX - 3;
		}
		if(GameFile.enemy1MoveSet[compAi.ai].equals("Leer") && enemyAnimation ==1 && enemyLeerX <15){
			enemyLeerX = enemyLeerX +1;
			enemyLeerY = enemyLeerY +2;
		}
		if(GameFile.enemy1MoveSet[compAi.ai].equals("Growl") && enemyAnimation ==1 && enemyGrowlX <100){
			enemyGrowlX = enemyGrowlX +5;
		} 
		if(GameFile.enemy1MoveSet[compAi.ai].equals("Tail Whip") && enemyAnimation ==1 && enemyTailWhipX < 720){
			enemyTailWhipX = enemyTailWhipX + 30;
		}
		if(attackPosition != 4 && attackPosition !=5){
			if(GameFile.pokemon1MoveSet[attackPosition].equals("Tackle") && pokemonAnimation ==1 && tackleX <30){
				tackleX = tackleX + 6;
			}
			if(GameFile.pokemon1MoveSet[attackPosition].equals("Tackle") && pokemonAnimation ==3 && tackleX >0){
				tackleX = tackleX - 6;
			}

			//      if(GameFile.pokemon1MoveSet[attackPosition].equals("Tail Whip") && pokemonAnimation ==1 && tailWhipX < 180){
			//        tailWhipX = tailWhipX + 30;
			//      }
			if(GameFile.pokemon1MoveSet[attackPosition].equals("Tail Whip") && pokemonAnimation ==1 && tailWhipY < 720){
				tailWhipY = tailWhipY + 30;
			}
			if(GameFile.pokemon1MoveSet[attackPosition].equals("Leer") && pokemonAnimation ==1 && leerX <15){
				leerX = leerX +1;
				leerY = leerY +2;
			} 
			if(GameFile.pokemon1MoveSet[attackPosition].equals("Growl") && pokemonAnimation ==1 && growlX <100){
				growlX = growlX +5;
			} 
		}
	}
	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e){ 
			int keyCode = e.getKeyCode();//Get key preseed
			if (keyCode ==e.VK_S) {//The Chat Key

				if(battle ==0 && speechFriend >=1 && speechFriend <=2 && GameFile.iBattle == 3 ){
					speechFriend = speechFriend +1;
				}
				if(battle ==5 && enemyStatHp ==0){
					battle =6;
				}
				if(battle ==1 && handPosition <=3){
					handPosition = handPosition +4;
				}
				else if(battle ==1 && handPosition ==7 && GameFile.iBattle >=2 || battle ==1 && handPosition ==5){
					handPosition = handPosition -4;
				}
				else if (battle ==1 && attackPosition ==2 && GameFile.pokemon1MoveSet[2].equals("null") || battle ==1 && attackPosition ==3 && GameFile.pokemon1MoveSet[3].equals("null")){

				}
				else if (battle ==1 && handPosition ==4 && attackPosition >=0 && attackPosition <=3){
					battle =2;
				}
				else if (battle ==1 && attackPosition ==5 || attackPosition ==4){
					handPosition =0;
					attackPosition = 0;
				}
			}
			if (keyCode ==e.VK_LEFT) {//moves object left
				if(battle ==1 && handPosition >=0 && handPosition <=1){
					handPosition = (handPosition + 1) %2;
				}
				else if (battle ==1 && handPosition >=2 && handPosition <=3){
					handPosition = ((handPosition + 1) %2) + 2;
				}
				else if (battle ==1 && attackPosition >=0 && attackPosition <=1 && handPosition ==4){
					attackPosition = (attackPosition +1) %2;
				}
				else if (battle ==1 && attackPosition >=2 && attackPosition <=3 && handPosition ==4){
					attackPosition = ((attackPosition + 1) %2) + 2;
				}
			}
			else if (keyCode ==e.VK_RIGHT) {//moves object right
				if(battle ==1 && handPosition >=0 && handPosition <=1){
					handPosition = (handPosition + 1) %2;
				}
				else if (battle ==1 && handPosition >=2 && handPosition <=3){
					handPosition = ((handPosition + 1) %2) + 2;
				}
				else if (battle ==1 && attackPosition >=0 && attackPosition <=1 && handPosition ==4){
					attackPosition = (attackPosition + 1) %2;
				}
				else if (battle ==1 && attackPosition >=2 && attackPosition <=3 && handPosition ==4){
					attackPosition = ((attackPosition + 1) %2) + 2;
				}
			}
			else if (keyCode ==e.VK_UP) {//moves object up
				if(battle ==1 && handPosition >=2 && handPosition <=3){
					handPosition = (handPosition + 2) %2;
				}
				else if (battle ==1 && handPosition >=0 && handPosition <=1){
					handPosition = ((handPosition + 2) %2) + 2;
				}
				else if (battle ==1 && attackPosition >=2 && attackPosition <=3 && handPosition ==4){
					attackPosition = attackPosition -2;
				}
				else if (battle ==1 && attackPosition >=0 && attackPosition <=1 && handPosition ==4){
					attackPosition = attackPosition + 4;
				}
				else if (battle ==1 && attackPosition >=4 && attackPosition <= 5 && handPosition ==4){
					attackPosition = attackPosition - 2;
				}
			}
			else if (keyCode ==e.VK_DOWN) {//moves object down
				if(battle ==1 && handPosition >=2 && handPosition <=3){
					handPosition = (handPosition + 2) %2;
				}
				else if (battle ==1 && handPosition >=0 && handPosition <=1){
					handPosition = ((handPosition + 2) %2) + 2;
				}
				else if (battle ==1 && attackPosition >=0 && attackPosition <=1 && handPosition ==4){
					attackPosition = attackPosition +2;
				}
				else if (battle ==1 && attackPosition >=2 && attackPosition <=3 && handPosition ==4){
					attackPosition = attackPosition + 2;
				}
				else if (battle ==1 && attackPosition >= 4 && attackPosition <= 5 && handPosition ==4){
					attackPosition = attackPosition % 2;
				}
			}




			
		}
	}

	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage,0,0,this);
		repaint();
	}

	public void wildPokemon(Graphics g) {
		battleExp = 1.0;
	}

	public void trainerBattles(Graphics g) {
		battleExp = 1.5;
	}

	public void friendsAndGyms(Graphics g) {
		if (GameFile.strTrainerName.equals("Natalie") && speechFriend <=3){ 
			g.drawImage(natalie, -200 + sceneX + trainerX, 399 - sceneY - trainerY,this);
		}
		if (sceneX >=700 && speechFriend ==0){
			speechFriend = 1;
			tmrScene.stop();
		}
		if(speechFriend >=1 && speechFriend <=2) {
			g.drawImage(dialog4, 0, 340,this);
			if(speechFriend ==1){
				g.drawString("You are challenged by", 7, 372);
				g.drawString("Pokemon Trainer " + GameFile.strTrainerName + "!", 7, 399);
			}
			else  if ( speechFriend ==2){
				g.drawString("Pokemon Trainer " + GameFile.strTrainerName + " sent", 7, 372);
				g.drawString("out " + GameFile.enemyParty[0] , 7, 399);
			}
		}

		if(speechFriend >=3 && speechFriend <=5) {
			if(speechFriend ==3){
				tmrScene.start();
			}
			g.drawImage(pokeball4, 600 - pokeballX, 40 + pokeballY, this);

			if(trainerX ==50 && speechFriend ==3 || pokeballX == 100 && speechFriend ==4 || flashX == 225 && speechFriend ==5){
				speechFriend = speechFriend +1; 
			}

			if(speechFriend ==4){
				tmrScene.start();
			}
			else if(speechFriend ==5){
				tmrScene.start();
				g.drawImage(flash, 0, 0, this);
			}
			else if(speechFriend ==6){
				friendEnemy = 1;
			}
		}
		battleExp = 1.5;
	}

	public void enemyPokemon(Graphics g) {
		if(attackPosition != 4 && attackPosition !=5){
			if((GameFile.pokemon1MoveSet[attackPosition].equals("Leer") && pokemonAnimation == 1) || (GameFile.enemy1MoveSet[compAi.ai].equals("Leer") && enemyAnimation == 1)){
				g.drawImage(blackBack,0,0,this);
			}
		}

		if(GameFile.enemyParty[0].equals("Cosmet")){
			g.drawImage(cosmet, 450 - enemyTackleX, 80+ enemyTackleX,this);
			enemyExp = 62;
		}
		else if(GameFile.enemyParty[0].equals("Tykepol")){
			g.drawImage(tykepol, 450- enemyTackleX - (int)(Math.cos(Math.toRadians(enemyTailWhipX)) * 45 -45), 80+ enemyTackleX - (int)(Math.sin(Math.toRadians(enemyTailWhipX)) * 50),this);
			enemyExp = 62;
		}
		else if(GameFile.enemyParty[0].equals("Embite")){
			g.drawImage(embite, 450- enemyTackleX, 80+ enemyTackleX,this);
			enemyExp = 62;
		}

		if(GameFile.enemyParty[0].equals("Cosmet") || GameFile.enemyParty[0].equals("Embite") || GameFile.enemyParty[0].equals("Tykepol")){
			expType = 4;
		}

		if(speechFriend ==6){
			tmrScene.start();

			if(flashX >=450){
				speechFriend =7;
				tmrScene.stop();
			}
		}
		else if(speechFriend ==7){
			pkThrow =1;
		}
	}

	public void pokemonThrow(Graphics g) {
		tmrScene.start();


		if(flashX >=225 && speechThrow ==5){
			speechThrow =6;
		}
		else if(throwY <= -135 && speechThrow ==4){
			speechThrow =5;
			flashX =0;
		}
		else if(throwX >=25 && speechThrow <=3){
			speechThrow =4;
			throwX =0;
		}
		else if(throwX >=23 && speechThrow <=3){
			speechThrow =3;
		}
		else if(throwX >= 19 && speechThrow <=3){
			speechThrow =2;
		}
		else if(throwX >= 8 && speechThrow <=3){
			speechThrow =1;
			flashX =0;
		}

		if(speechThrow ==1){
			g.drawImage(mainThrow, 20, 140, this);
		}
		else if (speechThrow ==2){
			g.drawImage(mainThrow1, 20, 140, this);
		}
		else if (speechThrow >=3 && speechThrow <=4){
			g.drawImage(mainThrow2, 20- flashX, 180 + flashX, this);
		}

		if(speechThrow >=4 && speechThrow <=5){
			g.drawImage(pokeball4, 115 + throwX,180 - throwY,this);
		}
		if(speechThrow ==5){
			g.drawImage(playFlash, 0, 0,this);
		}
		if(speechThrow >= 0 && speechThrow <=1){
			g.drawImage(dialog4, 0, 340,this);
			g.drawString("Go! " + GameFile.pokemonParty[0] + "!", 7, 372);
		}

		if(speechThrow ==6){
			if(GameFile.pokemonParty[0].equals("Tykepol")){
				g.drawImage(tykepolB, 90 + tackleX  - (int)(Math.cos(Math.toRadians(tailWhipY)) * 45 -45), 240 - tackleX - (int)(Math.sin(Math.toRadians(tailWhipY)) * 50), this);
			}
			else if(GameFile.pokemonParty[0].equals("Cosmet")){
				g.drawImage(cosmetB, 90 + tackleX, 240 - tackleX, this);
			}
			else if(GameFile.pokemonParty[0].equals("Embite")){
				g.drawImage(embiteB, 90 + tackleX, 240 - tackleX, this);
			}
			if(battle == 0){
				battle =1;
			}
		}
	}

	public void choiceSelection(Graphics g) {
		if(handPosition %4 ==0){
			g.drawImage(outline1, 222, 429,this);
		}
		else if(handPosition %4 ==1){
			g.drawImage(outline2, 347, 429,this);
		}
		else if(handPosition %4 ==2){
			g.drawImage(outline3, 222, 556,this);
		}
		else if(handPosition %4 ==3){
			g.drawImage(outline4, 347, 556,this);
		}

		if(handPosition ==4){
			g.drawImage(moveMenu, 0,400,this);
			g.drawString(GameFile.pokemon1MoveSet[0], 200, 500);
			g.drawString(GameFile.pokemon1MoveSet[1], 400, 500);

			if(attackPosition ==0){
				g.drawImage(outline1, 260, 410,this);
			}
			else if(attackPosition ==1){
				g.drawImage(outline2, 450, 410,this);
			}
			else if(attackPosition ==2){
				g.drawImage(outline3, 260, 535,this);
			}
			else if(attackPosition ==3){
				g.drawImage(outline4, 450, 535,this);
			}
			else if(attackPosition ==4 || attackPosition ==5){
				g.drawImage(outline1, 372, 640,this);
				g.drawImage(outline2, 372, 640,this);
				g.drawImage(outline3, 372, 640,this);
				g.drawImage(outline4, 372, 640,this);
			}
		}

		if(handPosition ==5 && GameFile.iaGameVars[3] == 12){
			g.drawImage(dialog4, 0, 340,this);
			g.drawString("You have no items currently in the bag",7,372);
		}

		if(handPosition ==6){
			handPosition =2;
		}

		if(handPosition ==7 && GameFile.iBattle >=2){
			g.drawImage(dialog4, 0, 340,this);
			g.drawString("No! There is no running",7,372);
			g.drawString("from a Trainer battle!",7,399);
		}

	}

	public void pokemonAtkAnimation(Graphics g){
		tmrScene.start();

		switch(animation){
		case(30): pokemonAnimation = 1; break;
		case(60): pokemonAnimation = 2; break;
		case(90): pokemonAnimation = 3; break;
		case(120): pokemonAnimation = 4; break;
		case(150): pokemonAnimation = 4; break;
		}

		if(pokemonAnimation ==0){
			g.drawImage(dialog4, 0, 340,this);
			g.drawString(GameFile.pokemonParty[0] + " used",7,372);
			g.drawString(GameFile.pokemon1MoveSet[attackPosition]  +  "!",7,399);
		}
		else if (pokemonAnimation ==1){//1-4 is the corner to bottom corner, 5-8 is the actual iamge
			if(GameFile.pokemon1MoveSet[attackPosition].equals("Leer")){
				g.drawImage(leer,200 - leerX,250 - leerY,255 + leerX, 325 + leerY,0,0,56,84,this);
			}
			else if(GameFile.pokemon1MoveSet[attackPosition].equals("Growl")){
				g.drawImage(growl,165 - growlX,250 - growlX,215 + growlX, 300 + growlX,0,0,230,249,this);
				g.drawImage(growl,190 - (int)(growlX/2),270 - (int)(growlX/2),191 + (int)(growlX/2), 280 + (int)(growlX/2),0,0,230,249,this);
			}
		}
		else if (pokemonAnimation ==2){
			if(GameFile.pokemon1MoveSet[attackPosition].equals("Tackle")){
				g.drawImage(tackle, 500, 80,this);
			} 
		}
		else if(pokemonAnimation ==3){
			if(pokemonDmg.atkPower ==0){
				statChange = pokemonDmg.statChange;
				g.drawImage(dialog4, 0, 340,this);
				g.drawString("The foes " + GameFile.enemyParty[0] + " " + statChange,7,372);
				g.drawString("fell!",7,399);
			}
			else if(pokemonDmg.critical == 2){
				g.drawImage(dialog4, 0, 340,this);
				g.drawString("A critical hit!!",7,372);
			}
		}
		else if(pokemonAnimation ==4){
			//        pokemonDmg(g);
		}
	}

	public void enemyAtkAnimation(Graphics g){
		tmrScene.start();

		switch(animationEnemy){
		case(30): enemyAnimation = 1; break;
		case(60): enemyAnimation = 2; break;
		case(90): enemyAnimation = 3; break;
		case(120): enemyAnimation = 4; break;
		}

		if(enemyAnimation ==0){
			g.drawImage(dialog4, 0, 340,this);
			g.drawString("The foes "+ GameFile.enemyParty[0] + " used",7,372);
			g.drawString(GameFile.enemy1MoveSet[compAi.ai]  +  "!",7,399);
		}
		else if (enemyAnimation ==1){
			if(GameFile.enemy1MoveSet[compAi.ai].equals("Leer")){
				g.drawImage(leer,530 - enemyLeerX,60 - enemyLeerY,585 + enemyLeerX, 135 + enemyLeerY,0,0,56,84,this);
			}
			else if(GameFile.enemy1MoveSet[compAi.ai].equals("Growl")){
				g.drawImage(growl,500 - enemyGrowlX,110 - enemyGrowlX,550 + enemyGrowlX, 160 + enemyGrowlX,0,0,230,249,this);
				g.drawImage(growl,525 - (int)(enemyGrowlX/2),130 - (int)(enemyGrowlX/2),526 + (int)(enemyGrowlX/2), 140 + (int)(enemyGrowlX/2),0,0,230,249,this);
			}
		}
		else if (enemyAnimation ==2){
			if(GameFile.enemy1MoveSet[compAi.ai].equals("Tackle")){
				g.drawImage(tackle, 100, 210,this);
			}
		}
		else if (enemyAnimation ==3){
			if(compAi.enemyAtkPower ==0){
				g.drawImage(dialog4, 0, 340,this);
				g.drawString( GameFile.pokemonParty[0] + " " + compAi.enemyStatChange,7,372);
				g.drawString("fell!",7,399);
			}
			else if(enemyDmgs.enemyCritical == 2){
				g.drawImage(dialog4, 0, 340,this);
				g.drawString("A critical hit!!",7,372);
			}
			else if(enemyAnimation ==4){
				//enemyDmgs.enemyDmg(enemyStats.enemyType, enemyDmgs.enemyAtkType, pokemonStats.type, compAi.enemyAtkPower, enemyStats.enemyStatAtk, pokemonStats.statDef, compAi.ai, animationEnemy);
			}
		}
	}
	public void paintComponent(Graphics g) {

		g.setFont(f1);
		Color smokeyWhite = new Color (241, 241, 241);  //creates your new color
		g.setColor(smokeyWhite);  //accesses your new color 
		g.drawImage(greenBackGround, - 700 + sceneX, 372 - sceneY ,this);
		g.drawImage(battleMenu, 0, 400,this);
		tmrScene.start();

		if(GameFile.iBattle ==1) {
			wildPokemon(g);
		}
		else if(GameFile.iBattle ==2) {
			trainerBattles(g);
		}
		else if(GameFile.iBattle ==3) {
			friendsAndGyms(g);
		}            

		if(friendEnemy ==1){
			enemyPokemon(g);
		}

		if(pkThrow == 1){
			pokemonThrow(g);
		}
		if( battle >=0) {
			pokemonStats.pokemonStats();//Gets Pokemon Base Stats
			enemyStats.enemyStats();//Gets Enemy Base Stats
			pokemonDmg.attackPower(attackPosition);//Gets attack power and attack type
			pokemonDmg.pokemonDmg(pokemonStats.type, pokemonDmg.atkType, enemyStats.enemyType, pokemonDmg.atkPower, pokemonStats.statAtk, enemyStats.enemyStatDef, attackPosition, animation);
			compAi.compAi(battle);
			pokemonStats.statStages(pokemonStats.stgAtk, pokemonStats.stgDef);
			enemyStats.enemyStatStages(enemyStats.enemyStgAtk, enemyStats.enemyStgDef);
			enemyDmgs.enemyDmg(enemyStats.enemyType, enemyDmgs.enemyAtkType, pokemonStats.type, compAi.enemyAtkPower, enemyStats.enemyStatAtk, pokemonStats.statDef, compAi.ai, animationEnemy);
			pokemonStats.pokemonFinalStats(enemyDmgs.pokemonDmg, pokemonStats.atkPercent, pokemonStats.defPercent);
			enemyStats.enemyFinalStats(pokemonDmg.enemyDmg, enemyStats.enemyAtkPercent, enemyStats.enemyDefPercent);
			//            pokeExperience.pokemonExpTypes();
			g.drawImage(hpBarEnemy, 3, 30,this);
			g.drawImage(hpBarAlly, 498, 325,this);

			if(enemyStats.enemyStatHp <= enemyStats.enemyHp/4){
				g.setColor(Color.RED);
			}
			else if(enemyStats.enemyStatHp <= enemyStats.enemyHp /2){
				g.setColor(Color.YELLOW);
			}
			else{
				g.setColor(Color.GREEN);
			}
			g.fillRect(56,52, (int)((double)(122 *enemyStats.enemyStatHp/enemyStats.enemyHp)),7);//Enemy Hp Bar

			if(GameFile.pokemonHp[0] <= GameFile.pokemonFullHp[0]/4){
				g.setColor(Color.RED);
			}
			else if(GameFile.pokemonHp[0] <= GameFile.pokemonFullHp[0] /2){
				g.setColor(Color.YELLOW);
			}
			else{
				g.setColor(Color.GREEN);
			}
			g.fillRect(566, 351, (int)((double)(120 *GameFile.pokemonHp[0]/GameFile.pokemonFullHp[0])),7);//Pokemon Hp Bar
			g.setColor(Color.CYAN);
			//            g.fillRect(520, 385,(int)((double)(149* GameFile.pokemonExp[0] / expReq)), 4);//need to work on expReg was 44 for snivy at lvl 5
			g.setColor(Color.BLACK);
			g.setFont(f3);
			g.drawString(GameFile.pokemonLevels[0] +"", 565, 348);
			g.drawString(GameFile.enemyLevels[0]+"", 160, 89);
			g.setFont(f1);
			g.setColor(smokeyWhite);

			if(animation >=120){
				animation =0;
				battle = battle +1; 
			}

			if(animationEnemy >=120){
				animationEnemy =0;
				battle = battle +1; 
			}

			if(battle ==1){
				g.drawImage(dialog4, 0, 340,this);
				g.drawString("What will " + GameFile.pokemonParty[0] + " do?",7,372);
				choiceSelection(g);
				animation =0;
				enemyAnimation =0;
				animationEnemy =0;
				pokemonAnimation =0;
				tailWhipY =0;
				leerX =0;
				leerY =0;
				enemyLeerX =0;
				enemyLeerY =0;
				growlX=0;
				enemyGrowlX =0;
				enemyTailWhipX =0;
			}

			if(enemyStats.enemyStatHp <=0 || GameFile.pokemonHp[0] <=0){
				battle =4;
			}
			else if(battle ==4 && enemyStats.enemyStatHp >0 && GameFile.pokemonHp[0] >0){
				battle =1;
			}

			//            if(enemyStats.enemyStatHp <=0){
			//              battle =4;
			//            }
			//            else{
			//              battle = battle +1; 
			//              handPosition =0;
			//            }

			if(battle ==2){
				if(enemyStats.enemyStatSpeed > pokemonStats.statSpeed){
					enemyAtkAnimation(g);
				}
				else {
					pokemonAtkAnimation(g);
				}
			}

			if(battle ==3){
				if(enemyStats.enemyStatSpeed > pokemonStats.statSpeed){
					pokemonAtkAnimation(g);
				}
				else {
					enemyAtkAnimation(g);
				}
			}

			//          if(battle ==4 && GameFile.pokemonHp[0] ==0 ||  battle ==4 && enemyStatHp==0){
			//            battle =5;
			//          }
			//          else if ( battle ==4){
			//            battle =1;
			//          }
			//          
			//          if(battle ==5){
			//            if(enemyStatHp == 0){
			//              g.drawImage(dialog4, 0, 340,this);
			//              g.drawString(GameFile.pokemonParty[0] +" gained " + expGain + " experience",7,372);
			//            } 
			//            battle =6;
			//          }
			//          
			//          if(battle ==6){
			//            if(GameFile.pokemonHp[0] ==0){
			//              GameFile.iWin = 1;
			//            }
			//            else if(enemyStatHp==0){
			//              GameFile.iWin = 2;
			//            }
			//          }

			if(enemyStatHp <0){//May put back in enemystats class
				enemyStatHp =0;
			}
			//          if(GameFile.pokemonHp[0] <=0){
			//            battle =4;
			//          }
			//          else{
			//            battle = battle +1; 
			//          }
		}
		//In between battle the traier says something Cheneren Sadi: Ive finally become a trainer. My time is now!
		g.drawString("Hp " + "Atk " + "Def " + "SpAtk " + "SpDef " + "Spd ", 10,170);
		g.drawString("Pokemon Stats" + " " + GameFile.pokemonHp[0] + " " + pokemonStats.statAtk + " " + pokemonStats.statDef + " " + pokemonStats.statSpAtk + " " + pokemonStats.statSpDef + " " + pokemonStats.statSpeed + " ", 10,200);
		g.drawString("Enemy Stats" + "    " + enemyStats.enemyStatHp + " " + enemyStats.enemyStatAtk + " " + enemyStats.enemyStatDef + " " + enemyStats.enemyStatSpAtk + " " + enemyStats.enemyStatSpDef + " " + enemyStats.enemyStatSpeed + " " + enemyAnimation +" "+ animationEnemy + " " + pokemonDmg.critical + " " + enemyDmgs.enemyCritical + " " + battle, 10,250);
		repaint();
		
	}

}