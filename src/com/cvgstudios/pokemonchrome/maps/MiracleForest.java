package com.cvgstudios.pokemonchrome.maps;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.cvgstudios.pokemonchrome.GameFile;
import com.cvgstudios.pokemonchrome.images.Images;
import com.cvgstudios.pokemonchrome.maps.MapleLodge.Boundaries;

public class MiracleForest extends JFrame implements ActionListener {

	final long KEYDELAY = 1000000;
	long lSystime;
	long lTimeL;
	long lTimeU;
	long lTimeR;
	long lTimeD;
	int mapChange = 6, forest = 1, oldMan = 0, boyY =0, velY =2, psyTalk =0;//remeber to switch old man to 0
	private Image dbImage;//
	private Graphics dbg;// double buffer
	String name = "Dixon";
	int downStep = -1, upStep = 0, leftStep = -1, rightStep = -1;
	Timer tmrOldMan = new Timer(10, this);
	int[] party;
	Image miracleForest1, down, down1, down2, left, left1, left2, right,
	right1, right2, up, up1, up2, greenColumnTrees, greenColumnTrees2,
	forestEntrance, greenTreeOverlay, leftEntrance, rightEntrance,
	greenColumnTrees3, miracleForest2, miracleForest4, miracleForest3, miracleForest5, 
	flashScreen, horizontalLog, verticalLog, miracleForest6, miracleForest7, oldManDown, 
	dialog, exclam, cutTree, miracleForest8, fionaDown, sakura, flowersDeath, photoFrame, tombstone,
	niko, gabriel, dixon, arvin, tommy;
	File f = new File("PokemonFont.ttf");
	FileInputStream in = new FileInputStream(f);
	Font dFont = Font.createFont(Font.TRUETYPE_FONT, in);
	Font f1 = dFont.deriveFont(40f), f2 = dFont.deriveFont(50f);

	public static void main(String[] args) throws Exception {
		MiracleForest mainMenu = new MiracleForest();
	}

	public MiracleForest() throws Exception {
		Boundaries.initializeBoundaries();
		miracleForest1 = Images.MiracleForest1.getImage();
		down = Images.PlayerDown.getImage();
		down1 = Images.PlayerDown1.getImage();
		down2 = Images.PlayerDown2.getImage();
		left = Images.PlayerLeft.getImage();
		left1 = Images.PlayerLeft1.getImage();
		left2 = Images.PlayerLeft2.getImage();
		right = Images.PlayerRight.getImage();
		right1 = Images.PlayerRight1.getImage();
		right2 = Images.PlayerRight2.getImage();
		up = Images.PlayerUp.getImage();
		up1 = Images.PlayerUp1.getImage();
		up2 = Images.PlayerUp2.getImage();
		greenColumnTrees = Images.GreenColumnTrees.getImage();
		greenColumnTrees2 = Images.GreenColumnTrees2.getImage();
		greenColumnTrees3 = Images.GreenColumnTrees3.getImage();
		forestEntrance = Images.ForestEntrance.getImage();
		greenTreeOverlay = Images.GreenTreeOverlay.getImage();
		leftEntrance = Images.LeftEntrance.getImage();
		rightEntrance = Images.RightEntrance.getImage();
		miracleForest2 = Images.MiracleForest2.getImage();
		miracleForest3 = Images.MiracleForest3.getImage();
		miracleForest4 = Images.MiracleForest4.getImage();
		miracleForest5 = Images.MiracleForest5.getImage();
		miracleForest6 = Images.MiracleForest6.getImage();
		miracleForest7 = Images.MiracleForest7.getImage();
		miracleForest8 = Images.MiracleForest8.getImage();
		flashScreen = Images.FlashScreen.getImage();
		horizontalLog = Images.HorizontalLog.getImage();
		verticalLog = Images.VerticalLog.getImage();
		oldManDown = Images.OldManDown.getImage();
		exclam = Images.Exclamation.getImage();
		dialog = Images.DialogBox.getImage();
		cutTree = Images.CutTree.getImage();
		fionaDown = Images.FionaDown.getImage();
		flowersDeath = Images.FlowerDeath.getImage();
		photoFrame = Images.PhotoFrame.getImage();
		sakura = Images.Sakura.getImage();
		tombstone = Images.Tombstone.getImage();
		arvin = Images.Arvin.getImage();
		dixon = Images.Dixon.getImage();
		gabriel = Images.Gabriel.getImage();
		niko = Images.Niko.getImage();
		tommy = Images.Tommy.getImage();
		
		addKeyListener(new AL());
		setTitle("Pokemon Chrome");// Sets the Title
		setSize(600, 600);// Size of Window
		setResizable(false);// Cannot resize the window
		setVisible(true);// Makes it visible
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// new musicPlayPoke("Music/NimbasaCity.wav").start();
	}

	public void actionPerformed(ActionEvent e) {
		if(forest ==1 && oldMan ==0){
			boyY = boyY + velY;
		}
		if(forest ==1 && oldMan ==1){
			GameFile.iLocY = GameFile.iLocY + velY;
		}
	}

	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();// Get key preseed
			
			if (forest ==2){
				//Boundaries.RightFence.getBox().setBoundaryPrevention(false);
			}
			
			if (keyCode == e.VK_S) {
				if(oldMan >=2 && forest ==1 && oldMan <=8){
					oldMan = oldMan +1;
				}
				else if(forest ==8  && GameFile.iLocX <= 15848 && GameFile.iLocX >= 15824 && GameFile.iLocY>= 15864 && GameFile.iLocY <= 15896 || forest ==9  && GameFile.iLocX <= 15848 && GameFile.iLocX >= 15824 && GameFile.iLocY>= 15864 && GameFile.iLocY <= 15896){
					psyTalk = psyTalk +1;
				}
			}
			long nanoTime = System.nanoTime();
			if (keyCode == e.VK_LEFT && nanoTime - lTimeU > KEYDELAY
					&& nanoTime - lTimeD > KEYDELAY) {// moves object left
				if (forest ==2 && GameFile.iLocX >= 1008 && GameFile.iLocY <= 1064
						&& GameFile.iLocY >= 960) {
					forest = 1;
					GameFile.iLocX = -360;
					GameFile.iLocY = 468;
				} 
				else if(forest ==1 && GameFile.iLocX >= 392 && GameFile.iLocX <= 416 && GameFile.iLocY >= 420 && GameFile.iLocY <= 524){
					forest = 3;
					GameFile.iLocX = 3000;
					GameFile.iLocY = 3000;
				}
				else if(forest ==5 && GameFile.iLocX >= 9968 && GameFile.iLocX <= 10008 && GameFile.iLocY >= 9168 && GameFile.iLocY <= 9240){
					forest = 6;
					GameFile.iLocX = 13000;
					GameFile.iLocY = 13000;
				}
				else if(forest ==2 && GameFile.iLocX >= 1008 && GameFile.iLocX <= 1024 && GameFile.iLocY >= 1536 && GameFile.iLocY <= 1640){
					forest = 5;
					GameFile.iLocX = 8736;
					GameFile.iLocY = 9592;
				}
				else if(forest ==4 && GameFile.iLocX >= 4632 && GameFile.iLocX <= 4640 && GameFile.iLocY >= 4376 && GameFile.iLocY <= 4488){
					forest = 2;
					GameFile.iLocX = 264;
					GameFile.iLocY = 1008;
				}
				else if(forest ==3 && GameFile.iLocX >= 3600 && GameFile.iLocX <= 3640 && GameFile.iLocY >= 2960 && GameFile.iLocY <= 3064){
					forest = 7;
					GameFile.iLocX = 7000;
					GameFile.iLocY = 7000;
				}
				else if(forest ==1 && GameFile.iLocX >= 392 && GameFile.iLocX <= 416 && GameFile.iLocY >= 420 && GameFile.iLocY <= 524){
					forest = 3;
					GameFile.iLocX = 3000;
					GameFile.iLocY = 3000;
				}
				else if(forest ==7 && GameFile.iLocX >= 8016 && GameFile.iLocX <= 8032 && GameFile.iLocY >= 6704 && GameFile.iLocY <= 6816){
					forest = 2;
					GameFile.iLocX = 256;
					GameFile.iLocY = 1576;
				}
				else if(forest ==5 && GameFile.iLocX >= 10008 && GameFile.iLocX <= 10016 && GameFile.iLocY >= 9960 && GameFile.iLocY <= 10048){
					forest = 7;
					GameFile.iLocX = 7000;
					GameFile.iLocY = 6272;
				}
				else if(oldMan <=8 || psyTalk >=1 && psyTalk <=5){

				}
				else if (BoundaryBox.isMovePossible(GameFile.iLocX, GameFile.iLocY,
						Direction.LEFT, Boundaries.getBoxes())) {
					GameFile.iLocX = GameFile.iLocX + 8;
					upStep = -1;
					downStep = -1;
					rightStep = -1;
					leftStep = leftStep + 1;
					lTimeL = nanoTime;
				}
				else{
					upStep = -1;
					downStep = -1;
					rightStep = -1;
					leftStep = leftStep + 1;
					lTimeL = nanoTime;
				}
			}
			if (keyCode == e.VK_RIGHT && nanoTime - lTimeU > KEYDELAY
					&& nanoTime - lTimeD > KEYDELAY) {// moves object right



				if (forest ==1 && GameFile.iLocX <= -368 && GameFile.iLocY <= 536
						&& GameFile.iLocY >= 424) {
					forest = 2;
					GameFile.iLocX = 1000;
					GameFile.iLocY = 1000;
				} 
				else if(forest ==3 && GameFile.iLocX >= 2984 && GameFile.iLocX <= 2992 && GameFile.iLocY >= 2960 && GameFile.iLocY <= 3056){
					forest = 1;
					GameFile.iLocX = 384;
					GameFile.iLocY = 468;
				}
				else if(forest ==5 && GameFile.iLocX >= 8704 && GameFile.iLocX <= 8720 && GameFile.iLocY >= 9568 && GameFile.iLocY <= 9640){
					forest = 2;
					GameFile.iLocX = 992;
					GameFile.iLocY = 1576;
				}
				else if(forest ==2 && GameFile.iLocX >= 232 && GameFile.iLocX <= 240 && GameFile.iLocY >= 1528 && GameFile.iLocY <= 1640){
					forest = 7;
					GameFile.iLocX = 8000;
					GameFile.iLocY = 6752;
				}
				else if (forest ==7 && GameFile.iLocX <= 6984 && GameFile.iLocX >= 6976 && GameFile.iLocY <= 6336
						&& GameFile.iLocY >= 6224) {
					forest = 5;
					GameFile.iLocX = 10000;
					GameFile.iLocY = 10000;
				}else if (forest ==2 && GameFile.iLocX <= 248 && GameFile.iLocX >= 240 && GameFile.iLocY <= 1064
						&& GameFile.iLocY >= 960) {
					forest = 4;
					GameFile.iLocX = 4616;
					GameFile.iLocY = 4416;
				}
				else if(forest ==6 && GameFile.iLocX >= 12984 && GameFile.iLocX <= 12992 && GameFile.iLocY >= 12952 && GameFile.iLocY <= 13056){
					forest = 5;
					GameFile.iLocX = 9952;
					GameFile.iLocY = 9192;
				}
				else if(forest ==7 && GameFile.iLocX >= 6976 && GameFile.iLocX <= 6984 && GameFile.iLocY >= 6960 && GameFile.iLocY <= 7056){
					forest = 3;
					GameFile.iLocX = 3584;
					GameFile.iLocY = 3008;
				}
				else if(forest ==6 && GameFile.iLocX >= 12824 && GameFile.iLocX <= 12848 && GameFile.iLocY >= 11992 && GameFile.iLocY <= 12064){
					forest = 8;
					GameFile.iLocX = 16000;
					GameFile.iLocY = 16000;
				}else if(oldMan <=8 || psyTalk >=1 && psyTalk <=5){

				}
				else if (BoundaryBox.isMovePossible(GameFile.iLocX, GameFile.iLocY,
						Direction.RIGHT, Boundaries.getBoxes())) {
					GameFile.iLocX = GameFile.iLocX - 8;
					upStep = -1;
					leftStep = -1;
					downStep = -1;
					rightStep = rightStep + 1;
					lTimeR = nanoTime;
				}
				else {
					upStep = -1;
					leftStep = -1;
					downStep = -1;
					rightStep = rightStep + 1;
					lTimeR = nanoTime;
				}
			}
			if (keyCode == e.VK_UP && nanoTime - lTimeL > KEYDELAY
					&& nanoTime - lTimeR > KEYDELAY) {// moves object up
				if(forest ==2 && GameFile.iLocX >= 496 && GameFile.iLocX <= 664 && GameFile.iLocY >= 1720 && GameFile.iLocY <= 1728){
					forest = 4;
					GameFile.iLocX = 5136;
					GameFile.iLocY = 4352;
				}
				else if(forest ==4 && GameFile.iLocX >= 4960 && GameFile.iLocX <= 5056 && GameFile.iLocY >= 5024 && GameFile.iLocY <= 5032){
					forest = 3;
					GameFile.iLocX = 3232;
					GameFile.iLocY = 2368;
				}
				else if(oldMan <=8 || psyTalk >=1 && psyTalk <=5){

				}
				else if (BoundaryBox.isMovePossible(GameFile.iLocX, GameFile.iLocY,
						Direction.UP, Boundaries.getBoxes())) {
					GameFile.iLocY = GameFile.iLocY + 8;
					leftStep = -1;
					downStep = -1;
					rightStep = -1;
					upStep = upStep + 1;
					lTimeU = nanoTime;
				}
				else {
					leftStep = -1;
					downStep = -1;
					rightStep = -1;
					upStep = upStep + 1;
					lTimeU = nanoTime;
				}
			}
			if (keyCode == e.VK_DOWN && nanoTime - lTimeL > KEYDELAY
					&& nanoTime - lTimeR > KEYDELAY) {// moves object down

				if (forest ==3 && GameFile.iLocX <= 3280 && GameFile.iLocX >= 3176 && GameFile.iLocY <= 2360
						&& GameFile.iLocY >= 2328) {
					forest = 4;
					GameFile.iLocX = 5000;
					GameFile.iLocY = 5000;
				}else if(forest ==4 && GameFile.iLocX >= 5088 && GameFile.iLocX <= 5184 && GameFile.iLocY >= 4336 && GameFile.iLocY <= 4344){
					forest = 2;
					GameFile.iLocX = 584;
					GameFile.iLocY = 1704;
				} 
				else if(oldMan <=8 || psyTalk >=1 && psyTalk <=5){

				}
				else if (BoundaryBox.isMovePossible(GameFile.iLocX, GameFile.iLocY,
						Direction.DOWN, Boundaries.getBoxes())) {
					GameFile.iLocY = GameFile.iLocY - 8;
					upStep = -1;
					leftStep = -1;
					rightStep = -1;
					downStep = downStep + 1;
					lTimeD = nanoTime;
				}
				else {
					upStep = -1;
					leftStep = -1;
					rightStep = -1;
					downStep = downStep + 1;
					lTimeD = nanoTime;
				}
			}
		}
	}

	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
		repaint();
	}


	
	public void paintComponent(Graphics g) {
		g.setFont(f1);
		leftStep = leftStep % 18;
		upStep = upStep % 18;
		rightStep = rightStep % 18;
		downStep = downStep % 18;

		if (mapChange == 6 && forest == 1) {
			g.drawImage(greenColumnTrees2, GameFile.iLocX - 814,
					GameFile.iLocY - 390, this);
			g.drawImage(greenColumnTrees2, GameFile.iLocX + 650,
					GameFile.iLocY - 390, this);
			g.drawImage(miracleForest1, GameFile.iLocX - 100,
					GameFile.iLocY - 290, this);
			g.drawImage(greenColumnTrees, GameFile.iLocX - 814,
					GameFile.iLocY - 35, this);
			g.drawImage(greenColumnTrees, GameFile.iLocX - 814,
					GameFile.iLocY - 1398, this);
			g.drawImage(greenColumnTrees, GameFile.iLocX - 814,
					GameFile.iLocY - 1398, this);
			g.drawImage(greenColumnTrees, GameFile.iLocX - 156,
					GameFile.iLocY - 1398, this);
			g.drawImage(greenColumnTrees, GameFile.iLocX + 502,
					GameFile.iLocY - 1398, this);
			g.drawImage(greenColumnTrees, GameFile.iLocX + 650,
					GameFile.iLocY - 35, this);
			g.drawImage(oldManDown, GameFile.iLocX + 300, GameFile.iLocY + 75, this);
		} else if (mapChange == 6 && forest == 2) {
			g.drawImage(miracleForest2, GameFile.iLocX - 1060,
					GameFile.iLocY - 1682, this);
		}
		else if (mapChange == 6 && forest == 3) {
			g.drawImage(miracleForest3, GameFile.iLocX - 3740,
					GameFile.iLocY - 3194, this);
		}	
		else if (mapChange == 6 && forest == 4) {
			g.drawImage(miracleForest4, GameFile.iLocX - 5552,
					GameFile.iLocY - 5002, this);
		}
		else if (mapChange == 6 && forest == 5) {
			g.drawImage(miracleForest5, GameFile.iLocX - 9830,
					GameFile.iLocY - 9806, this);
		}
		else if (mapChange == 6 && forest == 6) {
			g.drawImage(miracleForest6, GameFile.iLocX - 14296,
					GameFile.iLocY - 13058, this);
		}
		else if (mapChange == 6 && forest == 7) {
			g.drawImage(miracleForest7, GameFile.iLocX - 8030,
					GameFile.iLocY - 7114, this);
		}
		else if (mapChange == 6 && forest == 8) {
			g.drawImage(miracleForest8, GameFile.iLocX - 16000,
					GameFile.iLocY - 16000, this);
			g.drawImage(fionaDown,GameFile.iLocX - 15540, GameFile.iLocY - 15590,this);
		}

		//		Robot derp;
		//		try {
		//			derp = new Robot();
		//			derp.keyPress(KeyEvent.VK_ALT);
		//			derp.keyPress(KeyEvent.VK_F4);
		//		} catch (AWTException e) {
		//			// TODO Auto-generated catch block
		//			e.printStackTrace();
		//		}

		if (downStep >= 12) {
			g.drawImage(down2, 300, 300, this);
		} else if (downStep >= 6) {
			g.drawImage(down1, 300, 300, this);
		} else if (downStep >= 0) {
			g.drawImage(down, 300, 300, this);
		}

		if(oldMan >=2 || oldMan ==0){
			if (upStep >= 12) {
				g.drawImage(up2, 300, 300, this);
			} else if (upStep >= 6) {
				g.drawImage(up1, 300, 300, this);
			} else if (upStep >= 0) {
				g.drawImage(up, 300, 300, this);
			}
		}
		if (rightStep >= 12) {
			g.drawImage(right2, 300, 300, this);
		} else if (rightStep >= 6) {
			g.drawImage(right1, 300, 300, this);
		} else if (rightStep >= 0) {
			g.drawImage(right, 300, 300, this);
		}

		if (leftStep >= 12) {
			g.drawImage(left2, 300, 300, this);
		} else if (leftStep >= 6) {
			g.drawImage(left1, 300, 300, this);
		} else if (leftStep >= 0) {
			g.drawImage(left, 300, 300, this);
		}

		if (mapChange == 6 && forest == 1) {
			g.drawImage(forestEntrance, GameFile.iLocX - 100,
					GameFile.iLocY + 323, this);
			g.drawImage(greenTreeOverlay, GameFile.iLocX + 150,
					GameFile.iLocY + 135, this);
			g.drawImage(greenTreeOverlay, GameFile.iLocX + 368,
					GameFile.iLocY + 135, this);
			g.drawImage(greenTreeOverlay, GameFile.iLocX + 49,
					GameFile.iLocY + 13, this);
			g.drawImage(greenTreeOverlay, GameFile.iLocX + 468,
					GameFile.iLocY + 13, this);
			g.drawImage(greenTreeOverlay, GameFile.iLocX + 150,
					GameFile.iLocY - 109, this);
			g.drawImage(greenTreeOverlay, GameFile.iLocX + 368,
					GameFile.iLocY - 109, this);
			g.drawImage(leftEntrance, GameFile.iLocX - 180,
					GameFile.iLocY - 210, this);
			g.drawImage(rightEntrance, GameFile.iLocX + 688,
					GameFile.iLocY - 210, this);
		}
		if (mapChange == 6 && forest == 3) {
			g.drawImage(cutTree, GameFile.iLocX - 2990,
					GameFile.iLocY -2823, this);
		}
		else if (mapChange == 6 && forest == 5) {
			//Column.Row
			g.drawImage(verticalLog, GameFile.iLocX - 9692, GameFile.iLocY - 9626,this);//1,1
			g.drawImage(verticalLog, GameFile.iLocX - 9290, GameFile.iLocY - 9626,this);//2,1
			g.drawImage(verticalLog, GameFile.iLocX - 8890, GameFile.iLocY - 9627,this);//3,1
			g.drawImage(verticalLog, GameFile.iLocX - 8890, GameFile.iLocY - 9227,this);//3,2
		    g.drawImage(verticalLog, GameFile.iLocX - 8490, GameFile.iLocY - 9227,this);//4,2
			g.drawImage(verticalLog, GameFile.iLocX - 9290, GameFile.iLocY - 8827,this);//2,3
			g.drawImage(verticalLog, GameFile.iLocX - 8890, GameFile.iLocY - 8827,this);//3,3
			g.drawImage(verticalLog, GameFile.iLocX - 8490, GameFile.iLocY - 8827,this);//4,3
			g.drawImage(horizontalLog, GameFile.iLocX - 9600, GameFile.iLocY - 9715,this);//1,1
			g.drawImage(horizontalLog, GameFile.iLocX - 9600, GameFile.iLocY - 9305,this);//1,2
			g.drawImage(horizontalLog, GameFile.iLocX - 9200, GameFile.iLocY - 9305,this);//2,2
			g.drawImage(horizontalLog, GameFile.iLocX - 8800, GameFile.iLocY - 9715,this);//3,1
			g.drawImage(horizontalLog, GameFile.iLocX - 8800, GameFile.iLocY - 9305,this);//3,2
			g.drawImage(horizontalLog, GameFile.iLocX - 9600, GameFile.iLocY - 8905,this);//1,3
			g.drawImage(horizontalLog, GameFile.iLocX - 9200, GameFile.iLocY - 8905,this);//2,3
			g.drawImage(horizontalLog, GameFile.iLocX - 9600, GameFile.iLocY - 8504,this);//1,4
			g.drawImage(horizontalLog, GameFile.iLocX - 9200, GameFile.iLocY - 8504,this);//2,4
			g.drawImage(horizontalLog, GameFile.iLocX - 8800, GameFile.iLocY - 8504,this);//3,4
			g.drawImage(flashScreen, 0 ,0,this);
		}
		else if (mapChange ==6 && forest ==6){
			g.drawImage(flashScreen, 0 ,0,this);
		}

		if(forest ==1 && oldMan == 0){
			tmrOldMan.start();
			if(boyY >= 230){
				oldMan =1;
			}
		}
		else if(forest ==1 && oldMan ==1){
			g.drawImage(exclam, GameFile.iLocX + 295, GameFile.iLocY + 40, this);

			if (GameFile.iLocY % 45 >= 30) {
				g.drawImage(up2, 300, 300, this);
			} else if (GameFile.iLocY % 45 >= 15) {
				g.drawImage(up1, 300, 300, this);
			} else if (GameFile.iLocY % 45 >= 0) {
				g.drawImage(up, 300, 300, this);
			}

			if(GameFile.iLocY >= 196){
				oldMan =2;
			}
		}
		else if (oldMan ==2){
			g.drawImage(dialog, 5, 500, this);
			g.drawString("OldMan: Umm, Are you an actual human ", 20, 540);
			g.drawString("being?  ... Stares and Touches You", 20, 580);
		}
		else if (oldMan ==3){
			g.drawImage(dialog, 5, 500, this);
			g.drawString("OldMan: Sorry, mind my manners. ", 20, 540);
			g.drawString("Please Save Me Youngster!! ", 20, 580);
		}
		else if (oldMan ==4){
			g.drawImage(dialog, 5, 500, this);
			g.drawString("OldMan: I have been trapped in this ", 20, 540);
			g.drawString("forest for 20 fricking years!!! ", 20, 580);
		}
		else if (oldMan ==5){
			g.drawImage(dialog, 5, 500, this);
			g.drawString("OldMan: Thank you for helping me. Get  ", 20, 540);
			g.drawString("me out of the forest before I go crazy. ", 20, 580);
		}
		else if (oldMan ==6){
			g.drawImage(dialog, 5, 500, this);
			g.drawString("OldMan: But, beware that Miracle ", 20, 540);
			g.drawString("Forest is a very tricky place to escape. ", 20, 580);
		}
		else if (oldMan ==7){
			g.drawImage(dialog, 5, 500, this);
			g.drawString("OldMan: Everytime, I try to escape,", 20, 540);
			g.drawString("I always come back here. ", 20, 580);
		}
		else if (oldMan ==8){
			g.drawImage(dialog, 5, 500, this);
			g.drawString("OldMan: Also, some parts of the forest", 20, 540);
			g.drawString("are very dark. Good Luck Youngster.", 20, 580);
		}
		
		if(psyTalk ==1){
			g.drawImage(dialog, 5, 500, this);
			g.drawString("Fiona: It took you longer than", 20, 540);
			g.drawString("I had expected. I can sense a heated", 20, 580);
		}
		
		else if(psyTalk ==2){
			g.drawImage(dialog, 5, 500, this);
			g.drawString("Fiona: conflict between us in the", 20, 540);
			g.drawString("near future... Wait that came out wrong.", 20, 580);
		}

		else if(psyTalk ==3){
			g.drawImage(dialog, 5, 500, this);
			g.drawString("Fiona: But it is too bad that ", 20, 540);
			g.drawString("our fated battle will never happen.", 20, 580);
		}
		else if(psyTalk ==4){
			g.drawImage(dialog, 5, 500, this);
			g.drawString("Fiona: Right here and Now ", 20, 540);
			g.drawString("You will die " + name + "!!!", 20, 580);
		}
		else if(psyTalk ==5){
			forest =9;
			g.drawImage(sakura, 0, 0, this);
		}
		else if(psyTalk ==6 && name.equals("Niko")){
			g.setColor(Color.RED);
			g.drawImage(tombstone, 150, 280, this);
			g.drawImage(niko,230,70,this);
			g.drawImage(photoFrame, 200, 30, this);
			g.drawImage(flowersDeath, 172, 30, this);
			g.drawString("R.I.P", 300, 360);
			g.drawString("Niko katerelos", 220, 400);
			g.drawString("1995 - 2013", 240, 440);
			g.drawString("Here Lies a Virgin.", 220, 480);
			g.drawString("Nothing Less Nothing More!", 220, 520);
		}
		else if(psyTalk ==6 && name.equals("Arvin")){
			g.setColor(Color.RED);
			g.drawImage(tombstone, 150, 280, this);
			g.drawImage(arvin,230,70,this);
			g.drawImage(photoFrame, 200, 30, this);
			g.drawImage(flowersDeath, 172, 30, this);
			g.drawString("R.I.P", 300, 360);
			g.drawString("Arvin Zaldivar", 195, 400);
			g.drawString("1995 - 2013", 240, 440);
			g.drawString("Here Lies the Greatest .", 220, 480);
			g.drawString("Douchebag in the World!", 220, 520);
		}
		else if(psyTalk ==6 && name.equals("Dixon")){
			g.setColor(Color.RED);
			g.drawImage(tombstone, 150, 280, this);
			g.drawImage(dixon,230,70,this);
			g.drawImage(photoFrame, 200, 30, this);
			g.drawImage(flowersDeath, 172, 30, this);
			g.drawString("R.I.P", 300, 360);
			g.drawString("Dixon D'Cunha", 220, 400);
			g.drawString("1995 - 2013", 240, 440);
			g.drawString("The First Ever Priest to", 220, 480);
			g.drawString("Swear to God and burn in HELL", 220, 520);
		}
		else if(psyTalk ==6 && name.equals("Tommy")){
			g.setColor(Color.RED);
			g.drawImage(tombstone, 150, 280, this);
			g.drawImage(tommy,230,70,this);
			g.drawImage(photoFrame, 200, 30, this);
			g.drawImage(flowersDeath, 172, 30, this);
			g.drawString("R.I.P", 300, 360);
			g.drawString("Tommy Huynh", 220, 400);
			g.drawString("1995 - 2013", 240, 440);
			g.drawString("Never Shall We See That", 180, 480);
			g.drawString("Tentacle Hentai Porn Ever Again!", 180, 520);
		}
		else if(psyTalk ==6 && name.equals("Gabriel")){
			g.setColor(Color.RED);
			g.drawImage(tombstone, 150, 280, this);
			g.drawImage(gabriel,230,70,this);
			g.drawImage(photoFrame, 200, 30, this);
			g.drawImage(flowersDeath, 172, 30, this);
			g.drawString("R.I.P", 300, 360);
			g.drawString("Gabriel Marc", 220, 400);
			g.drawString("1995 - 2013", 240, 440);
			g.drawString("Broke His Neck while .", 220, 480);
			g.drawString("sky diving from the CN Tower..", 220, 520);
		}
		else if(psyTalk ==6 && name.equals("Mark")){
			g.setColor(Color.RED);
			g.drawImage(tombstone, 150, 280, this);
			g.drawImage(gabriel,230,70,this);
			g.drawImage(photoFrame, 200, 30, this);
			g.drawImage(flowersDeath, 172, 30, this);
			g.drawString("R.I.P", 300, 360);
			g.drawString("Gabriel Marc", 220, 400);
			g.drawString("1995 - 2013", 240, 440);
			g.drawString("Broke His Neck while .", 220, 480);
			g.drawString("sky diving from the CN Tower..", 220, 520);
		}
		//g.setColor(Color.RED);
		g.drawString(GameFile.iLocX + "  " + GameFile.iLocY + "  " + mapChange + "  ", 250, 300);

		// Graphics2D g2 = (Graphics2D)g;
		// for(int GameFile.iLocX=0;GameFile.iLocX<=6009GameFile.iLocX+=25){
		// g2.drawLine(GameFile.iLocX,0,GameFile.iLocX,600);
		// g2.drawString(""+GameFile.iLocX,GameFile.iLocX,20);
		// }
		// for(int GameFile.iLocY=0;GameFile.iLocY<=600;GameFile.iLocY+=25){
		// g2.drawLine(0,GameFile.iLocY,600,GameFile.iLocY);
		// g2.drawString(""+GameFile.iLocY,0,GameFile.iLocY+20);
		// }
		repaint();

	}
	enum Boundaries {
		Forest1RightFence(new BoundaryBox(-312, -376, 44, 388)), Forest1LeftFence(new BoundaryBox(400, 344, 44, 364)), 
		Forest1BottomFence(new BoundaryBox(376, 56, -72, 36)), Forest1BottomFence2(new BoundaryBox(-312, -56, -72, 36)),
		Forest1TopFence(new BoundaryBox(384, -352, 596, 612)), Forest1RightFence2(new BoundaryBox(-360, -376, 532, 588)),
		Forest1RightFence3(new BoundaryBox(-360, -376, 396, 420)), Forest1LeftFence2(new BoundaryBox(400, 392, 532, 588)), 
		Forest1LeftFence3(new BoundaryBox(400, 392, 372, 412)), Forest1BottomTree(new BoundaryBox(136, 96, 84, 116)), 
		Forest1BottomTree2(new BoundaryBox(-88, -120, 84, 116)), Forest1TopTree(new BoundaryBox(136, 96, 324, 356)),
		Forest1TopTree2(new BoundaryBox(-88, -120, 324, 356)), Forest1MiddleTree(new BoundaryBox(232, 200, 212, 244)),
		Forest1MiddleTree2(new BoundaryBox(-184, -224, 212, 244)), Stump(new BoundaryBox(48, -32, 244, 308)),
		OldManBound(new BoundaryBox(24, -16, 204, 236)),
		Forest2UpFence(new BoundaryBox(1000, 416, 1072, 1240)), Forest2LeftFence(new BoundaryBox(672, 1000, 1240, 1528)),
		Forest2UpFence2(new BoundaryBox(1000, 672, 1648, 1760)),Forest2UpFence3(new BoundaryBox(672, 632, 1720, 1800)),
		Forest2UpFence4(new BoundaryBox(536, 488, 1720, 1800)), Forest2UpFence5(new BoundaryBox(488, 240, 1720, 1648)),
		Forest2RightFence(new BoundaryBox(488, 240, 1360, 1520)), Forest2RightFence2(new BoundaryBox(296, 240, 1072, 1352)),
		Forest2DownFence(new BoundaryBox(1008, 240, 944, 952)),
		Forest3UpFence(new BoundaryBox(3008, 2912, 3064, 3104)), Forest3DownFence(new BoundaryBox(3008, 2912, 2928, 2952)),
		Forest3RightFence(new BoundaryBox(2880, 2912, 3104, 3208)), Forest3UpFence2(new BoundaryBox(2912, 3200, 3208, 3240)),
		Forest3UpEntrance(new BoundaryBox(3200, 3376, 3120, 3200)), Forest3UpFence3(new BoundaryBox(3376, 3672, 3200, 3240)),
		Forest3LeftFence(new BoundaryBox(3672, 3720, 3104, 3200)), Forest3UpFence4(new BoundaryBox(3576, 3672, 3104, 3072)),
		Forest3DownFence2(new BoundaryBox(3576, 3672, 2936, 2952)),Forest3LeftFence2(new BoundaryBox(3672, 3720, 2808, 2936)),
		Forest3DownFence3(new BoundaryBox(3544, 3672, 2616, 2808)),Forest3DownLeftFence(new BoundaryBox(3288, 3544, 2344, 2616)),
		Forest3DownRightFence(new BoundaryBox(2920, 3168, 2344, 2616)), Forest3RightFence2(new BoundaryBox(2880, 2920, 2616, 2776)),
		Forest3UpFence5(new BoundaryBox(2920, 3360, 2776, 2808)), Forest3RightFence3(new BoundaryBox(2880, 2920, 2808, 2928)),
		//Fprest4
		Forest4LeftTopFence(new BoundaryBox(5064, 5512, 4784, 5032)),Forest4LeftFence(new BoundaryBox(5512, 5552, 4424, 4784)),
		Forest4BotLeftFence(new BoundaryBox(5192, 5512, 4264, 4424)), Forest4RightFence(new BoundaryBox(5040, 5080, 4264, 4504)),
		Forest4MiddleBoxFence(new BoundaryBox(4624, 5424, 4504, 4696)), Forest4RightFence2(new BoundaryBox(4728, 4952, 4784, 5072)),
		Forest4UpFence(new BoundaryBox(4408, 4728, 4984, 5024)), Forest4MiddleBoxFence2(new BoundaryBox(4504, 4624, 4496, 4904)),
		Forest4RightFence3(new BoundaryBox(4360, 4408, 4368, 4984)), Forest4BotFence(new BoundaryBox(4408, 4656, 4320, 4368)),
		//Forest7
		Forest7RightFence(new BoundaryBox(6944, 6984, 7064, 7144)), Forest7DownFence(new BoundaryBox(6984, 7208, 6920, 6952)),
		Forest7RightFence2(new BoundaryBox(6944, 6984, 6344, 6920)), Forest7BotFence(new BoundaryBox(6984, 7440, 6432, 6456)),
		Forest7BotFence2(new BoundaryBox(6984, 7592, 6176, 6216)), Forest7BotBoxFence(new BoundaryBox(7592, 7752, 6216, 6280)),
		Forest7IFence(new BoundaryBox(7656, 7688, 6280, 6432)), Forest7IFence2(new BoundaryBox(7560, 7784, 6432, 6456)),
		Forest7BotFence3(new BoundaryBox(7752, 8008, 6176, 6216)), Forest7LeftFence(new BoundaryBox(8008, 8056, 6216, 6696)),
		Forest7UpFence(new BoundaryBox(7880, 8008, 6552, 6576)), Forest7leftEntrance(new BoundaryBox(7880, 7912, 6552, 6840)),
		Forest7LeftFence2(new BoundaryBox(8008, 8040, 6824, 7168)), Forest7LeftBox(new BoundaryBox(7944, 8056, 6904, 7040)),
		Forest7TopFence(new BoundaryBox(6984, 8008, 7144, 7176)),Forest7TopBox(new BoundaryBox(7720, 7880, 7080, 7176)),
		Forest7MiddleFence(new BoundaryBox(7312, 7792, 6552, 6576)),Forest7FlowerBox(new BoundaryBox(7552, 7712, 6736, 7000)),
		Forest7TFence(new BoundaryBox(7376, 7408, 6680, 7056)), Forest7TFence2(new BoundaryBox(7120, 7376, 6800, 6824)),
		//Column/Row Forest5
		Forest5TopLayer(new BoundaryBox(10000, 8664, 10056, 10080)), Forest5RightLayer(new BoundaryBox(8664, 8696, 8736, 10056)),
		Forest5BotLayer(new BoundaryBox(10016, 8664, 8712, 8736)), Forest5LeftLayer(new BoundaryBox(10024, 10048, 8736, 10056)),
		Forest5Square(new BoundaryBox(9592, 9936, 9608, 9968)), Forest5RightLog11(new BoundaryBox(9608, 9912, 10016, 10056)), 
		Forest5BotLog11(new BoundaryBox(9992, 10024, 9648, 9952)), Forest5RightLog12(new BoundaryBox(9608, 9912, 9208, 9560)),
		Forest5Square2(new BoundaryBox(9192, 9536, 9608, 9952)), Forest5Square3(new BoundaryBox(8792, 9136, 9608, 9968)),
		Forest512Bot(new BoundaryBox(9912, 10016, 9248, 9544)), Forest521Right(new BoundaryBox(9224, 9496, 9952, 10056)),
		Forest522Bot(new BoundaryBox(9512, 9608, 9248, 9544)), Forest5Square4(new BoundaryBox(9192, 9536, 9208, 9560)),
		Forest5RightLog31(new BoundaryBox(8808, 9112, 10016, 10048)), Forest5Square5(new BoundaryBox(8792, 9136, 8808, 9560)),
		Forest5Bot41(new BoundaryBox(8696, 8792,9648, 9944)),ForestBotLog42(new BoundaryBox(8704, 8736, 9208, 9560)),
		Forest5LeftLog44(new BoundaryBox(8792, 9136, 8720, 8760)),Forest5LeftLog34(new BoundaryBox(9200, 9520, 8720, 8760)),
		Forest5LeftLog24(new BoundaryBox(9600, 9920, 8720, 8760)), Forest5Square6(new BoundaryBox(9192, 9536, 8808, 9160)),
		Forest5Square7(new BoundaryBox(9592, 10024, 8808, 9160)),Forest5BotLog43(new BoundaryBox(8704, 8736, 8824, 9160)),
		//FOREST6
		Forest6TopUpFence(new BoundaryBox(13000, 13272, 13064, 13256)), Forest6BotFence(new BoundaryBox(12720, 13528, 12816, 12944)),
		Forest6MidBoxFence(new BoundaryBox(13368, 13528, 12952, 13144)), Forest6TopFence(new BoundaryBox(13272,13632, 13232, 13256)),
		Forest6LeftBoxFence(new BoundaryBox(13632,13752, 12816, 13232)),Forest6UpLeftFence2(new BoundaryBox(13752,14040, 12952, 13160)),
		Forest6LeftFence(new BoundaryBox(14424,14472, 13064, 13160)), Forest6RightBotFence(new BoundaryBox(14136,14424, 12704, 13064)),
		Forest6BoxFence(new BoundaryBox(13760,14232, 12272, 12624)), Forest6BoxFence2(new BoundaryBox(13848,14040, 12624, 12856)),
		Forest6BoxFence3(new BoundaryBox(13632,13848, 12616, 12720)),Forest6TopFence2(new BoundaryBox(14048,14424, 13160, 13192)),
		Forest6LeftFence3(new BoundaryBox(14328,14376, 12184, 12704)), Forest6BoxFence4(new BoundaryBox(14200,14464, 11968, 12184)),
		Forest6LeftFence4(new BoundaryBox(14424,14464, 11880, 11968)), Forest6BotFence2(new BoundaryBox(13496,14424, 11848, 11880)),
		Forest6BoxFence5(new BoundaryBox(13592,14104, 11968, 12184)), Forest6BoxFence6(new BoundaryBox(13144,13656, 12072, 12288)),
		Forest6UpRightBox(new BoundaryBox(12824,13496, 11880, 11984)), Forest6LeftUpBox(new BoundaryBox(12824,13048, 12072, 12528)),
		Forest6FlowerBox(new BoundaryBox(13144,13656, 12384, 12528)), Forest6FlowerBox2(new BoundaryBox(13272,13528, 12528, 12720)),
		Forest6FlowerBox3(new BoundaryBox(13016,13176, 12616, 12816)), Forest6RightFence(new BoundaryBox(12720,12760, 12724, 12816)),
		Forest6RightUpFence(new BoundaryBox(12720,12920, 12528, 12728)),
		;
		
		BoundaryBox theBoundary;
		static BoundaryBox[] theBoxes;

		private Boundaries(BoundaryBox theBox) {
			theBoundary = theBox;
		}

		public BoundaryBox getBox() {
			return theBoundary;
		}

		public static void initializeBoundaries() {
			Boundaries[] theBoundaries = Boundaries.values();

			theBoxes = new BoundaryBox[theBoundaries.length];

			for (int i = 0; i < theBoundaries.length; i++) {
				theBoxes[i] = theBoundaries[i].getBox();
			}
		}

		public static BoundaryBox[] getBoxes() {
			return theBoxes;
		}

	}

}