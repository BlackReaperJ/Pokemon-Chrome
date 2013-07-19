package com.cvgstudios.pokemonchrome.maps;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;

import com.cvgstudios.pokemonchrome.FriendsRivals;
import com.cvgstudios.pokemonchrome.GameFile;
import com.cvgstudios.pokemonchrome.images.Images;
import com.cvgstudios.pokemonchrome.music.BGMusicPlayer;

public class Exitium extends JFrame implements ActionListener {
	ClassLoader cl = Exitium.class.getClassLoader();// Gets Image from URL
													// DIRECTOR

	final long KEYDELAY = 1000000;
	long lSystime;
	long lTimeL;
	long lTimeU;
	long lTimeR;
	long lTimeD;
	int velX = 4, velY = 4, boyY = 0, boyX = 0, gateX = 0, gateVelX = 2,
			battleVelX = 0, battleVelY = 0;
	int dadLocation = 0, boyLocation = 0, girlLocation = 0;
	static Random r = new Random();
	private Image dbImage;//
	private Graphics dbg;// double buffer
	int downStep = -1, upStep = -1, leftStep = -1, rightStep = 0, gate = 0,
			z = 0;;
	int showSign = 0, text = 0, exitiumSign = 0, houseSign = 0, jayceSign,
			townSign = 0, gateText = 0;
	int start = 300, yes = 0;
	int[] party;
	Timer tmrBoyUp = new Timer(10, this);
	Timer tmrBoyRight = new Timer(10, this);
	Timer tmrDadStart = new Timer(10, this);
	Timer tmrDadDown = new Timer(10, this);
	Timer tmrDadLeft = new Timer(10, this);
	Timer tmrGateLeft = new Timer(20, this);
	Timer tmrGateRight = new Timer(20, this);
	Timer tmrSign = new Timer(40, this);
	Timer tmrBattle = new Timer(1, this);
	Timer tmrBattle2 = new Timer(20, this);
	// Create a variable name for each image above
	Image map, down, down1, down2, left, left1, left2, right, right1, right2,
			up, up1, up2, house, house1bot, dadDown, dadRight, exclam, dialog,
			boyLeft;
	Image boyRight, boyRight1, boyRight2, boyUp, boyUp1, boyUp2, dadUp,
			dadLeft, route1, girlDown, girlRight, girlLeft, gateDown, gateLeft,
			gateLeft1, sign;
	Image gateLeft2, gateRight, gateRight1, gateRight2, boyDown, house1,
			house2, house3, house4, lamppost, mailbox, mailbox2, columnTrees,
			dialog2, dialog3;
	Image cosmetStart, tykepolStart, embiteStart, arrow, hand, tykepol, cosmet,
			embite, mainBattleBack, natalieBattleBack, vs2, mainHead,
			natalieHead;

	File f = new File("PokemonFont.ttf");
	FileInputStream in = new FileInputStream(f);
	Font dFont = Font.createFont(Font.TRUETYPE_FONT, in);
	Font f1 = dFont.deriveFont(40f), f2 = dFont.deriveFont(50f);

	public static void main(String[] args) throws Exception {
		pleaseRenameTheseMethodsJulius();
	}

	public static void pleaseRenameTheseMethodsJulius() throws Exception {
		Exitium mainMenu = new Exitium();

		while (true) {
			System.out
					.println(GameFile.iaGameVars[3] == 12 ? "Okay Julius. You're right."
							: "I TOLD YOU SO");

			if (GameFile.iaGameVars[0] == 0) {
				GameFile.enemyParty[0] = "Tykepol";
				GameFile.enemy1MoveSet[0] = "Tackle";
				GameFile.enemy1MoveSet[1] = "Tail Whip";
			} else if (GameFile.iaGameVars[0] == 1) {
				GameFile.enemyParty[0] = "Embite";
				GameFile.enemy1MoveSet[0] = "Tackle";
				GameFile.enemy1MoveSet[1] = "Growl";
			} else if (GameFile.iaGameVars[0] == 2) {
				System.out.println("Its not null anymore asshole");
				GameFile.enemyParty[0] = "Cosmet";
				GameFile.enemy1MoveSet[0] = "Tackle";
				GameFile.enemy1MoveSet[1] = "Leer";
			}

			if (GameFile.iaGameVars[3] == 12) {
				GameFile.iBattle = 3;
				GameFile.strTrainerName = "Natalie";

				// Create Random IVs for pokemon
				System.out.println("Those arent null either.");
				GameFile.enemy1Ivs[0] = r.nextInt(30) + 1;
				GameFile.enemy1Ivs[1] = r.nextInt(30) + 1;
				GameFile.enemy1Ivs[2] = r.nextInt(30) + 1;
				GameFile.enemy1Ivs[3] = r.nextInt(30) + 1;
				GameFile.enemy1Ivs[4] = r.nextInt(30) + 1;
				GameFile.enemy1Ivs[5] = r.nextInt(30) + 1;
				GameFile.enemyLevels[0] = 5;
				GameFile.saveFile();
				FriendsRivals.renameThisMethodJuliusUsingAltShiftR();
				mainMenu.setVisible(false);
				break;
			}
		}

	}

	public Exitium() throws Exception {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		// Match image variable name to imageURL
		map = Images.Exitium.getImage();
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
		house = Images.House1Top.getImage();
		house1bot = Images.House1Bot.getImage();
		dadDown = Images.DadDown.getImage();
		dadRight = Images.DadRight.getImage();
		exclam = Images.Exclamation.getImage();
		dialog = Images.DialogBox.getImage();
		boyLeft = Images.BoyLeft.getImage();
		boyRight = Images.BoyRight.getImage();
		boyRight1 = Images.BoyRight1.getImage();
		boyRight2 = Images.BoyRight2.getImage();
		boyUp = Images.BoyUp.getImage();
		boyUp1 = Images.BoyUp1.getImage();
		boyUp2 = Images.BoyUp2.getImage();
		dadUp = Images.DadUp.getImage();
		dadLeft = Images.DadLeft.getImage();
		route1 = Images.Route1.getImage();
		girlDown = Images.GirlDown.getImage();
		girlRight = Images.GirlLeft.getImage();
		girlLeft = Images.GirlLeft.getImage();
		gateDown = Images.GateDown.getImage();
		gateLeft = Images.GateLeft.getImage();
		gateLeft1 = Images.GateLeft1.getImage();
		gateLeft2 = Images.GateLeft2.getImage();
		gateRight = Images.GateRight.getImage();
		gateRight1 = Images.GateRight1.getImage();
		gateRight2 = Images.GateRight2.getImage();
		boyDown = Images.BoyDown.getImage();
		house1 = Images.House1Overlay.getImage();
		house2 = Images.House2Overlay.getImage();
		house3 = Images.House3Overlay.getImage();
		house4 = Images.House4Overlay.getImage();
		lamppost = Images.Lamppost.getImage();
		mailbox = Images.MailBox.getImage();
		mailbox2 = Images.MailBox2.getImage();
		columnTrees = Images.ColumnTrees.getImage();
		dialog2 = Images.DialogBox2.getImage();
		dialog3 = Images.DialogBox3.getImage();
		sign = Images.Sign.getImage();
		cosmetStart = Images.CosmetStart.getImage();
		tykepolStart = Images.TykepolStart.getImage();
		embiteStart = Images.EmbiteStart.getImage();
		arrow = Images.Arrow.getImage();
		hand = Images.Hand.getImage();
		tykepol = Images.Tykepol.getImage();
		cosmet = Images.Cosmet.getImage();
		embite = Images.Embite.getImage();
		mainBattleBack = Images.MainBattleBack.getImage();
		natalieBattleBack = Images.NatalieBattleBack.getImage();
		vs2 = Images.Vs2.getImage();
		mainHead = Images.MainHead.getImage();
		natalieHead = Images.NatalieHead.getImage();

		addKeyListener(new AL());
		setTitle("Pokemon Chrome");// Sets the Title
		setSize(600, 600);// Size of Window
		setResizable(false);// Cannot resize the window
		setVisible(true);// Makes it visible
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new BGMusicPlayer("Music/NimbasaCity.wav").start();
	}

	public void actionPerformed(ActionEvent e) {
		if (GameFile.iLocation == 2 && townSign == 0) {
			showSign = showSign + velX;
		}
		if (GameFile.iaGameVars[3] == 11 && battleVelX <= 600) {
			battleVelX = battleVelX + 8;
		}
		if (GameFile.iaGameVars[3] == 11 && battleVelX >= 600) {
			battleVelY = battleVelY + 4;
		}
		if (gate == 1 || gate == 4) {
			gateX = gateX + gateVelX;
		}
		if (GameFile.iaGameVars[1] == 3) {
			boyY = boyY + velY;
		}
		if (GameFile.iaGameVars[1] == 4) {
			boyX = boyX + velX;
		}
		if (GameFile.iaGameVars[2] == 0 && GameFile.iLocation == 1) {
			boyX = boyX + velX;
		}
		if (GameFile.iaGameVars[2] == 1) {
			boyY = boyY + velY;
		}
		if (GameFile.iaGameVars[2] == 2) {
			boyX = boyX + velX;
		}
		repaint();
	}

	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();// Get keGameFile.iLocYpreseed
			if (keyCode == e.VK_Z) {
				z = z + 1;
			}
			if (keyCode == e.VK_S) {
				if (GameFile.iaGameVars[1] >= 0 && GameFile.iaGameVars[1] <= 2) {
					GameFile.iaGameVars[1] = GameFile.iaGameVars[1] + 1;
				}
				if (GameFile.iaGameVars[2] >= 3 && GameFile.iaGameVars[2] <= 4) {
					GameFile.iaGameVars[2] = GameFile.iaGameVars[2] + 1;
				}

				if (GameFile.iaGameVars[3] == 6 && yes == 0) {
					GameFile.iaGameVars[3] = 5;
				} else if (GameFile.iaGameVars[3] == 21
						&& GameFile.iLocX <= -541 && GameFile.iLocX >= -548
						&& GameFile.iLocY >= -384 && GameFile.iLocY <= -377
						&& leftStep >= 0 || GameFile.iaGameVars[3] == 21
						&& upStep >= 0 && GameFile.iLocX <= -492
						&& GameFile.iLocX >= -540 && GameFile.iLocY >= -416
						&& GameFile.iLocY <= -407) {
					GameFile.iaGameVars[3] = 20;
				} else if (GameFile.iaGameVars[3] == 21) {
				} else if (GameFile.iaGameVars[3] >= 11
						&& GameFile.iaGameVars[3] <= 12) {
				} else if (GameFile.iaGameVars[3] >= 1
						&& GameFile.iaGameVars[3] < 11
						|| GameFile.iaGameVars[3] >= 13
						&& GameFile.iaGameVars[3] <= 20) {
					GameFile.iaGameVars[3] = GameFile.iaGameVars[3] + 1;
				} else if (GameFile.iLocation == 2
						&& GameFile.iaGameVars[3] >= 0 && upStep >= 0
						&& GameFile.iLocX <= -492 && GameFile.iLocX >= -540
						&& GameFile.iLocY >= -416 && GameFile.iLocY <= -407) {
					GameFile.iaGameVars[3] = 1;
					girlLocation = 0;
				} else if (GameFile.iLocation == 2
						&& GameFile.iaGameVars[3] >= 0 && leftStep >= 0
						&& GameFile.iLocX <= -541 && GameFile.iLocX >= -548
						&& GameFile.iLocY >= -384 && GameFile.iLocY <= -377) {
					GameFile.iaGameVars[3] = 1;
					girlLocation = 1;
				}

				if (GameFile.iLocation == 2 && GameFile.iLocX <= -220
						&& GameFile.iLocX >= -260 && GameFile.iLocY <= -104
						&& GameFile.iLocY >= -112 && exitiumSign == 0
						&& upStep >= 0) {
					exitiumSign = 1;
				} else if (GameFile.iLocation == 2 && GameFile.iLocX <= -444
						&& GameFile.iLocX >= -484 && GameFile.iLocY >= -416
						&& GameFile.iLocY <= -368 && jayceSign == 0
						&& upStep >= 0) {
					jayceSign = 1;
				} else if (GameFile.iLocation == 2 && GameFile.iLocX <= -12
						&& GameFile.iLocX >= -44 & GameFile.iLocY >= -416
						&& GameFile.iLocY <= -409 && houseSign == 0
						&& upStep >= 0) {
					houseSign = 1;
				} else if (GameFile.iLocation == 2 && GameFile.iLocX >= -348
						&& GameFile.iLocX <= -332 && GameFile.iLocY >= -96
						&& GameFile.iLocY <= -89 && upStep >= 0
						&& gateText == 0) {
					gateText = 1;
				} else if (GameFile.iLocation == 2 && GameFile.iLocX >= -348
						&& GameFile.iLocX <= -332 && GameFile.iLocY >= -96
						&& GameFile.iLocY <= -89 && upStep >= 0
						&& gateText == 1) {
					gateText = 2;
				} else if (GameFile.iLocation == 1 && GameFile.iLocX <= -108
						&& GameFile.iLocX >= -149 && GameFile.iLocY <= 216
						&& GameFile.iLocY <= 209 && GameFile.iaGameVars[2] >= 5
						&& text == 0 && rightStep == -1 && upStep == -1
						&& leftStep == -1) {
					dadLocation = 1;
					text = 1;
				} else if (GameFile.iLocation == 1 && GameFile.iLocX <= -108
						&& GameFile.iLocX >= -149 && GameFile.iLocY >= 144
						&& GameFile.iLocY <= 160 && GameFile.iaGameVars[2] >= 5
						&& text == 0 && rightStep == -1 && leftStep == -1
						&& downStep == -1) {
					dadLocation = 2;
					text = 1;
				} else if (GameFile.iLocation == 1 && GameFile.iLocX >= -156
						&& GameFile.iLocX <= -149 && GameFile.iLocY >= 160
						&& GameFile.iLocY <= 200 && GameFile.iaGameVars[2] >= 5
						&& text == 0 && rightStep == -1 && upStep == -1
						&& downStep == -1) {
					dadLocation = 0;
					text = 1;
				} else if (GameFile.iLocation == 1 && GameFile.iLocX >= -100
						&& GameFile.iLocX <= -93 && GameFile.iLocY >= 168
						&& GameFile.iLocY <= 184 && GameFile.iaGameVars[2] >= 5
						&& text == 0 && leftStep == -1 && upStep == -1
						&& downStep == -1) {
					dadLocation = 3;
					text = 1;
				} else if (text == 1 || exitiumSign == 1 || jayceSign == 1
						|| houseSign == 1 || gateText == 2) {
					text = 0;
					exitiumSign = 0;
					jayceSign = 0;
					houseSign = 0;
					gateText = 0;
				} else if (gate == 2) {
					gate = 3;
				} else if (gate == 3) {
					gate = 4;
				}
			}
			long nanoTime = System.nanoTime();
			if (keyCode == e.VK_LEFT && nanoTime - lTimeU > KEYDELAY
					&& nanoTime - lTimeD > KEYDELAY) {// moves object left
				if (GameFile.iaGameVars[1] >= 0 && GameFile.iaGameVars[1] <= 4) {
				} else if (GameFile.iaGameVars[2] >= 0
						&& GameFile.iaGameVars[2] <= 4
						&& GameFile.iLocation == 1) {
				} else if (GameFile.iaGameVars[3] == 6) {
					yes = 1;
				} else if (GameFile.iaGameVars[3] == 5) {
					start = start + 1;
				} else if (GameFile.iaGameVars[3] >= 1
						&& GameFile.iaGameVars[3] <= 20) {
				} else if (gate >= 1 && gate <= 4 || gateText == 1
						|| gateText == 2) {
				} else if (text == 1 && GameFile.iaGameVars[2] >= 5
						|| exitiumSign == 1 || jayceSign == 1 || houseSign == 1) {
				} else if (GameFile.iLocation == 2 && GameFile.iLocX >= -172
						&& GameFile.iLocX <= -163 && GameFile.iLocY >= -384
						&& GameFile.iLocY <= -280 || GameFile.iLocation == 2
						&& GameFile.iLocX >= -52 && GameFile.iLocX <= -45
						&& GameFile.iLocY >= -408 && GameFile.iLocY <= -392
						|| GameFile.iLocation == 2 && GameFile.iLocX <= -172
						&& GameFile.iLocX >= -188 && GameFile.iLocY >= -720
						&& GameFile.iLocY <= -592 || GameFile.iLocation == 2
						&& GameFile.iLocX >= -628 && GameFile.iLocX <= -620
						&& GameFile.iLocY >= -720 && GameFile.iLocY <= -592
						|| GameFile.iLocation == 2 && GameFile.iLocX >= -548
						&& GameFile.iLocX <= -532 && GameFile.iLocY >= -408
						&& GameFile.iLocY <= -384 || GameFile.iLocation == 2
						&& GameFile.iLocX >= -628 && GameFile.iLocX <= -612
						&& GameFile.iLocY >= -376 && GameFile.iLocY <= -280) {
					leftStep = leftStep + 1;
					rightStep = -1;
					downStep = -1;
					upStep = -1;
				} else if (GameFile.iLocation == 2 && GameFile.iLocX >= -68
						&& GameFile.iLocY <= -808 && GameFile.iLocY >= -832
						|| GameFile.iLocation == 2 && GameFile.iLocX >= -268
						&& GameFile.iLocY >= -88 && GameFile.iLocY <= 40
						|| GameFile.iLocation == 2 && GameFile.iLocX >= -252
						&& GameFile.iLocX <= -236 && GameFile.iLocY >= -408
						&& GameFile.iLocY <= -376 || GameFile.iLocation == 2
						&& GameFile.iLocX >= -420 && GameFile.iLocX <= -396
						&& GameFile.iLocY >= -408 && GameFile.iLocY <= -376
						|| GameFile.iLocation == 2 && GameFile.iLocX >= -252
						&& GameFile.iLocX <= -236 && GameFile.iLocY >= -744
						&& GameFile.iLocY <= -712 || GameFile.iLocation == 2
						&& GameFile.iLocX >= -420 && GameFile.iLocX <= -396
						&& GameFile.iLocY >= -744 && GameFile.iLocY <= -712
						|| GameFile.iLocation == 2 && GameFile.iLocX >= -268
						&& GameFile.iLocX <= -226 && GameFile.iLocY <= -96
						&& GameFile.iLocY >= -104) {// BOundaries for exitium
													// for the fences and
													// lamposts
					leftStep = leftStep + 1;
					rightStep = -1;
					downStep = -1;
					upStep = -1;
				} else if (GameFile.iLocation == 1 && GameFile.iLocX >= -156
						&& GameFile.iLocX <= -149 && GameFile.iLocY >= 160
						&& GameFile.iLocY <= 200 && GameFile.iaGameVars[2] >= 5
						|| GameFile.iLocation == 1 && GameFile.iLocX >= 36
						&& GameFile.iLocY <= 40 && GameFile.iLocY >= -8
						|| GameFile.iLocation == 1 && GameFile.iLocX >= -100
						&& GameFile.iLocX <= 20 && GameFile.iLocY >= 88
						&& GameFile.iLocY <= 208 || GameFile.iLocation == 1
						&& GameFile.iLocX >= -76 && GameFile.iLocY >= 296
						&& GameFile.iLocY <= 352 || GameFile.iLocation == 1
						&& GameFile.iLocX >= -4 && GameFile.iLocY >= 416
						|| GameFile.iLocation == 1 && GameFile.iLocX >= -244
						&& GameFile.iLocX <= -148 && GameFile.iLocY <= 320
						&& GameFile.iLocY >= 288 || GameFile.iLocation == 1
						&& GameFile.iLocX >= -300 && GameFile.iLocX <= -252
						&& GameFile.iLocY >= 320 && GameFile.iLocY <= 376
						|| GameFile.iLocation == 1 && GameFile.iLocX >= -372
						&& GameFile.iLocX <= -363 && GameFile.iLocY >= 448
						&& GameFile.iLocY <= 456 || GameFile.iLocation == 1
						&& GameFile.iLocX >= -372 && GameFile.iLocX <= -363
						&& GameFile.iLocY >= 384 && GameFile.iLocY <= 392) {// house
																			// bot1
					leftStep = leftStep + 1;
					rightStep = -1;
					downStep = -1;
					upStep = -1;
				} else if (GameFile.iLocation == 0 && GameFile.iLocX >= 240
						&& GameFile.iLocY >= 116 || GameFile.iLocation == 0
						&& GameFile.iLocX >= 256 && GameFile.iLocY >= -236
						&& GameFile.iLocY <= -204 || GameFile.iLocation == 0
						&& GameFile.iLocX >= -208 && GameFile.iLocX <= -144
						&& GameFile.iLocY >= -224 && GameFile.iLocY <= -192
						|| GameFile.iLocation == 0 && GameFile.iLocX >= -208
						&& GameFile.iLocX <= -144 && GameFile.iLocY >= -168
						&& GameFile.iLocY <= -152 || GameFile.iLocation == 0
						&& GameFile.iLocX >= 16 && GameFile.iLocX <= 176
						&& GameFile.iLocY >= 100 && GameFile.iLocY <= 124
						|| GameFile.iLocation == 0 && GameFile.iLocX >= 40
						&& GameFile.iLocX <= 176 && GameFile.iLocY >= 128
						&& GameFile.iLocY <= 140 || GameFile.iLocation == 0
						&& GameFile.iLocX >= 80 && GameFile.iLocX <= 176
						&& GameFile.iLocY >= 140) {// Boundaries for house top1
					leftStep = leftStep + 1;
					rightStep = -1;
					downStep = -1;
					upStep = -1;
				} else {
					GameFile.iLocX = GameFile.iLocX + 8;
					upStep = -1;
					downStep = -1;
					rightStep = -1;
					leftStep = leftStep + 1;
					lTimeL = nanoTime;
				}
			} else if (keyCode == e.VK_RIGHT && nanoTime - lTimeU > KEYDELAY
					&& nanoTime - lTimeD > KEYDELAY) {// moves object right
				if (GameFile.iaGameVars[1] >= 0 && GameFile.iaGameVars[1] <= 4) {
				} else if (GameFile.iaGameVars[2] >= 0
						&& GameFile.iaGameVars[2] <= 4
						&& GameFile.iLocation == 1) {
				} else if (GameFile.iaGameVars[3] == 6) {
					yes = 0;
				} else if (GameFile.iaGameVars[3] == 5) {
					start = start - 1;
				} else if (GameFile.iaGameVars[3] >= 1
						&& GameFile.iaGameVars[3] <= 20) {
				} else if (gate >= 1 && gate <= 4 || gateText == 1
						|| gateText == 2) {
				} else if (text == 1 && GameFile.iaGameVars[2] >= 5
						|| exitiumSign == 1 || jayceSign == 1 || houseSign == 1) {
				} else if (GameFile.iLocation == 2 && GameFile.iLocX <= -4
						&& GameFile.iLocX >= -20 && GameFile.iLocY >= -408
						&& GameFile.iLocY <= -280 || GameFile.iLocation == 2
						&& GameFile.iLocX <= -12 && GameFile.iLocX >= -36
						&& GameFile.iLocY >= -720 && GameFile.iLocY <= -592
						|| GameFile.iLocation == 2 && GameFile.iLocX <= -452
						&& GameFile.iLocX >= -476 && GameFile.iLocY >= -720
						&& GameFile.iLocY <= -592 || GameFile.iLocation == 2
						&& GameFile.iLocX <= -436 && GameFile.iLocX >= -452
						&& GameFile.iLocY >= -408 && GameFile.iLocY <= -280
						|| GameFile.iLocation == 2 && GameFile.iLocX <= -348
						&& GameFile.iLocY >= -96 && GameFile.iLocY <= -87) {
					leftStep = -1;
					rightStep = rightStep + 1;
					downStep = -1;
					upStep = -1;
				} else if (GameFile.iLocation == 2 && GameFile.iLocX <= -548
						&& GameFile.iLocY <= -808 && GameFile.iLocY >= -832
						|| GameFile.iLocation == 2 && GameFile.iLocX <= -348
						&& GameFile.iLocY >= -88 && GameFile.iLocY <= 40
						|| GameFile.iLocation == 2 && GameFile.iLocX >= -220
						&& GameFile.iLocX <= -196 && GameFile.iLocY >= -408
						&& GameFile.iLocY <= -376 || GameFile.iLocation == 2
						&& GameFile.iLocX >= -388 && GameFile.iLocX <= -364
						&& GameFile.iLocY >= -408 && GameFile.iLocY <= -376
						|| GameFile.iLocation == 2 && GameFile.iLocX >= -220
						&& GameFile.iLocX <= -196 && GameFile.iLocY >= -744
						&& GameFile.iLocY <= -712 || GameFile.iLocation == 2
						&& GameFile.iLocX >= -388 && GameFile.iLocX <= -364
						&& GameFile.iLocY >= -744 && GameFile.iLocY <= -712
						|| GameFile.iLocation == 2 && GameFile.iLocX <= -212
						&& GameFile.iLocX >= -252 && GameFile.iLocY <= -104
						&& GameFile.iLocY >= -111) {// Boundaries for exitium
													// town of the fences and
													// lamposts
					rightStep = rightStep + 1;
					leftStep = -1;
					downStep = -1;
					upStep = -1;
				} else if (GameFile.iLocation == 1 && GameFile.iLocX >= -100
						&& GameFile.iLocX <= -93 && GameFile.iLocY >= 168
						&& GameFile.iLocY <= 184 && GameFile.iaGameVars[2] >= 5
						|| GameFile.iLocation == 1 && GameFile.iLocX >= -76
						&& GameFile.iLocX <= 36 && GameFile.iLocY >= 88
						&& GameFile.iLocY <= 208 || GameFile.iLocation == 1
						&& GameFile.iLocX >= -236 && GameFile.iLocX <= -124
						&& GameFile.iLocY >= 288 && GameFile.iLocY <= 408
						|| GameFile.iLocation == 1 && GameFile.iLocX <= -68
						&& GameFile.iLocX >= -124 && GameFile.iLocY >= 416) {// Boundaries
																				// for
																				// house
																				// bot1
					leftStep = -1;
					rightStep = rightStep + 1;
					downStep = -1;
					upStep = -1;
				} else if (GameFile.iLocation == 0 && GameFile.iLocX >= 104
						&& GameFile.iLocX <= 200 && GameFile.iLocY >= 100
						|| GameFile.iLocation == 0 && GameFile.iLocX >= -192
						&& GameFile.iLocX <= -128 && GameFile.iLocY >= -224
						&& GameFile.iLocY <= -192 || GameFile.iLocation == 0
						&& GameFile.iLocX <= -160 && GameFile.iLocY >= 160
						|| GameFile.iLocation == 0 && GameFile.iLocX <= -160
						&& GameFile.iLocY >= 60 && GameFile.iLocY <= 80
						|| GameFile.iLocation == 0 && GameFile.iLocX <= -128
						&& GameFile.iLocY >= -168 && GameFile.iLocY <= -152) {// Boundaries
																				// for
																				// house
																				// top1
					leftStep = -1;
					rightStep = rightStep + 1;
					downStep = -1;
					upStep = -1;
				} else {
					GameFile.iLocX = GameFile.iLocX - 8;
					upStep = -1;
					leftStep = -1;
					downStep = -1;
					rightStep = rightStep + 1;
					lTimeR = nanoTime;
				}
			} else if (keyCode == e.VK_UP && nanoTime - lTimeL > KEYDELAY
					&& nanoTime - lTimeR > KEYDELAY) {// moves object up
				if (GameFile.iaGameVars[1] >= 0 && GameFile.iaGameVars[1] <= 4) {
				} else if (GameFile.iaGameVars[3] >= 1
						&& GameFile.iaGameVars[3] <= 20) {
				} else if (gate >= 1 && gate <= 4 || gateText == 1
						|| gateText == 2) {
				} else if (GameFile.iaGameVars[2] >= 0
						&& GameFile.iaGameVars[2] <= 4
						&& GameFile.iLocation == 1) {
				} else if (text == 1 && GameFile.iaGameVars[2] >= 5
						|| exitiumSign == 1 || jayceSign == 1 || houseSign == 1) {
				} else if (GameFile.iLocation == 2 && GameFile.iLocY >= -96
						&& GameFile.iLocY <= -89 && GameFile.iLocX >= -324
						&& GameFile.iLocX <= -268
						&& GameFile.iaGameVars[4] == 0) {
					gate = 1;
					leftStep = -1;
					rightStep = -1;
					downStep = -1;
					upStep = 0;
				} else if (GameFile.iLocation == 2 && GameFile.iLocX <= -68
						&& GameFile.iLocX >= -164 && GameFile.iLocY >= -392
						&& GameFile.iLocY <= -385 || GameFile.iLocation == 2
						&& GameFile.iLocX <= -548 && GameFile.iLocX >= -620
						&& GameFile.iLocY >= -384 && GameFile.iLocY <= -376
						|| GameFile.iLocation == 2 && GameFile.iLocX <= -12
						&& GameFile.iLocX >= -44 && GameFile.iLocY >= -416
						&& GameFile.iLocY <= -392 || GameFile.iLocation == 2
						&& GameFile.iLocX <= -20 && GameFile.iLocX >= -180
						&& GameFile.iLocY >= -728 && GameFile.iLocY <= -680
						|| GameFile.iLocation == 2 && GameFile.iLocX <= -460
						&& GameFile.iLocX >= -620 && GameFile.iLocY >= -728
						&& GameFile.iLocY <= -704 || GameFile.iLocation == 2
						&& GameFile.iLocX <= -444 && GameFile.iLocX >= -540
						&& GameFile.iLocY >= -416 && GameFile.iLocY <= -368
						|| GameFile.iLocation == 2 && GameFile.iLocX >= -348
						&& GameFile.iLocX <= -332 && GameFile.iLocY >= -96
						&& GameFile.iLocY <= -89 && GameFile.iaGameVars[4] == 0) {
					leftStep = -1;
					rightStep = -1;
					downStep = -1;
					upStep = upStep + 1;
				} else if (GameFile.iLocation == 2 && GameFile.iLocX <= -204
						&& GameFile.iLocX >= -244 && GameFile.iLocY <= -392
						&& GameFile.iLocY >= -416 || GameFile.iLocation == 2
						&& GameFile.iLocX <= -372 && GameFile.iLocX >= -412
						&& GameFile.iLocY <= -392 && GameFile.iLocY >= -416
						|| GameFile.iLocation == 2 && GameFile.iLocX <= -204
						&& GameFile.iLocX >= -244 && GameFile.iLocY <= -728
						&& GameFile.iLocY >= -752 || GameFile.iLocation == 2
						&& GameFile.iLocX <= -372 && GameFile.iLocX >= -412
						&& GameFile.iLocY <= -728 && GameFile.iLocY >= -752
						|| GameFile.iLocation == 2 && GameFile.iLocX <= -220
						&& GameFile.iLocX >= -260 && GameFile.iLocY <= -104
						&& GameFile.iLocY >= -112) {// Boundaries for lamposts
													// and sign
					leftStep = -1;
					rightStep = -1;
					downStep = -1;
					upStep = upStep + 1;
				} else if (GameFile.iLocation == 1 && GameFile.iLocX <= -108
						&& GameFile.iLocX >= -149 && GameFile.iLocY >= 144
						&& GameFile.iLocY <= 160 && GameFile.iaGameVars[2] >= 5
						|| GameFile.iLocation == 1 && GameFile.iLocX >= -76
						&& GameFile.iLocX <= 28 && GameFile.iLocY >= 80
						&& GameFile.iLocY <= 200 || GameFile.iLocation == 1
						&& GameFile.iLocX >= -68 && GameFile.iLocY >= 288
						&& GameFile.iLocY <= 328 || GameFile.iLocation == 1
						&& GameFile.iLocX >= -124 && GameFile.iLocX <= -76
						&& GameFile.iLocY >= 400 || GameFile.iLocation == 1
						&& GameFile.iLocX >= 4 && GameFile.iLocY >= 400
						|| GameFile.iLocation == 1 && GameFile.iLocX <= -132
						&& GameFile.iLocX >= -244 && GameFile.iLocY >= 280
						&& GameFile.iLocY <= 352 || GameFile.iLocation == 1
						&& GameFile.iLocX <= -252 && GameFile.iLocX >= -292
						&& GameFile.iLocY >= 320 && GameFile.iLocY <= 384
						|| GameFile.iLocX <= -300 && GameFile.iLocX >= -364
						&& GameFile.iLocY >= 376 && GameFile.iLocY <= 383) {// Boundaries
																			// for
																			// house
																			// bot1
					leftStep = -1;
					rightStep = -1;
					downStep = -1;
					upStep = upStep + 1;
				} else if (GameFile.iLocation == 0 && GameFile.iLocX >= 248
						&& GameFile.iLocY >= 108 || GameFile.iLocation == 0
						&& GameFile.iLocX <= 192 && GameFile.iLocX >= 24
						&& GameFile.iLocY >= 92 && GameFile.iLocY <= 108
						|| GameFile.iLocation == 0 && GameFile.iLocX >= 264
						&& GameFile.iLocY >= -244 && GameFile.iLocY <= -216
						|| GameFile.iLocation == 0 && GameFile.iLocX <= -136
						&& GameFile.iLocX >= -200 && GameFile.iLocY >= -232
						&& GameFile.iLocY <= -191 || GameFile.iLocation == 0
						&& GameFile.iLocX <= -168 && GameFile.iLocY >= 48
						&& GameFile.iLocY <= 55 || GameFile.iLocation == 0
						&& GameFile.iLocX <= -136 && GameFile.iLocX >= -200
						&& GameFile.iLocY >= -176 && GameFile.iLocY <= -152) {// Boundaries
																				// for
																				// house
																				// top1
					leftStep = -1;
					rightStep = -1;
					downStep = -1;
					upStep = upStep + 1;
				} else {
					GameFile.iLocY = GameFile.iLocY + 8;
					leftStep = -1;
					downStep = -1;
					rightStep = -1;
					upStep = upStep + 1;
					lTimeU = nanoTime;
				}
			} else if (keyCode == e.VK_DOWN && nanoTime - lTimeL > KEYDELAY
					&& nanoTime - lTimeR > KEYDELAY) {// moves object down
				if (GameFile.iaGameVars[1] >= 0 && GameFile.iaGameVars[1] <= 4) {
				} else if (GameFile.iaGameVars[3] >= 1
						&& GameFile.iaGameVars[3] <= 20) {
				} else if (GameFile.iaGameVars[2] >= 0
						&& GameFile.iaGameVars[2] <= 4
						&& GameFile.iLocation == 1) {
				} else if (gate >= 1 && gate <= 4 || gateText == 1
						|| gateText == 2) {
				} else if (text == 1 && GameFile.iaGameVars[2] >= 5
						|| exitiumSign == 1 || jayceSign == 1 || houseSign == 1) {
				} else if (GameFile.iLocation == 2 && GameFile.iLocY <= -272
						&& GameFile.iLocY >= -279 && GameFile.iLocX >= -164
						&& GameFile.iLocX <= -12 || GameFile.iLocation == 2
						&& GameFile.iLocX <= -20 && GameFile.iLocX >= -180
						&& GameFile.iLocY <= -584 && GameFile.iLocY >= -600
						|| GameFile.iLocation == 2 && GameFile.iLocX <= -460
						&& GameFile.iLocX >= -620 && GameFile.iLocY <= -584
						&& GameFile.iLocY >= -600 || GameFile.iLocation == 2
						&& GameFile.iLocX <= -444 && GameFile.iLocX >= -620
						&& GameFile.iLocY <= -272 && GameFile.iLocY >= -280) {
					leftStep = -1;
					rightStep = -1;
					downStep = downStep + 1;
					upStep = -1;
				} else if (GameFile.iLocation == 2 && GameFile.iLocX <= -204
						&& GameFile.iLocX >= -244 && GameFile.iLocY <= -368
						&& GameFile.iLocY >= -392 || GameFile.iLocation == 2
						&& GameFile.iLocX <= -372 && GameFile.iLocX >= -412
						&& GameFile.iLocY <= -368 && GameFile.iLocY >= -392
						|| GameFile.iLocation == 2 && GameFile.iLocX <= -204
						&& GameFile.iLocX >= -244 && GameFile.iLocY <= -704
						&& GameFile.iLocY >= -728 || GameFile.iLocation == 2
						&& GameFile.iLocX <= -372 && GameFile.iLocX >= -412
						&& GameFile.iLocY <= -704 && GameFile.iLocY >= -728) {// Boundaries
																				// for
																				// lamposts
					leftStep = -1;
					rightStep = -1;
					downStep = downStep + 1;
					upStep = -1;
				} else if (GameFile.iLocation == 1 && GameFile.iLocX <= -108
						&& GameFile.iLocX >= -148 && GameFile.iLocY <= 215
						&& GameFile.iLocY >= 208 && GameFile.iaGameVars[2] >= 5
						|| GameFile.iLocation == 1 && GameFile.iLocX >= -84
						&& GameFile.iLocX <= 28 && GameFile.iLocY >= 112
						&& GameFile.iLocY <= 216 || GameFile.iLocation == 1
						&& GameFile.iLocX >= 44 && GameFile.iLocY <= 48
						|| GameFile.iLocation == 1 && GameFile.iLocX >= -68
						&& GameFile.iLocY <= 360 && GameFile.iLocY >= 320) {// Boundaries
																			// for
																			// house
																			// bot1
					leftStep = -1;
					rightStep = -1;
					downStep = downStep + 1;
					upStep = -1;
				} else if (GameFile.iLocation == 0 && GameFile.iLocX <= 80
						&& GameFile.iLocX >= 48 && GameFile.iLocY <= 151
						&& GameFile.iLocY >= 144 || GameFile.iLocation == 0
						&& GameFile.iLocX <= 40 && GameFile.iLocX >= 24
						&& GameFile.iLocY <= 135 && GameFile.iLocY >= 128
						|| GameFile.iLocation == 0 && GameFile.iLocX >= 264
						&& GameFile.iLocY <= -196 && GameFile.iLocY >= -236
						|| GameFile.iLocation == 0 && GameFile.iLocX <= -136
						&& GameFile.iLocX >= -200 && GameFile.iLocY >= -168
						&& GameFile.iLocY <= -144 || GameFile.iLocation == 0
						&& GameFile.iLocX <= -136 && GameFile.iLocX >= -200
						&& GameFile.iLocY <= -184 && GameFile.iLocY >= -224) {// Boundaries
																				// for
																				// house
																				// top1
					leftStep = -1;
					rightStep = -1;
					downStep = downStep + 1;
					upStep = -1;
				} else {
					GameFile.iLocY = GameFile.iLocY - 8;
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
		leftStep = leftStep % 24;
		upStep = upStep % 24;
		rightStep = rightStep % 24;
		downStep = downStep % 24;

		if (GameFile.iLocation == 0) {
			if (GameFile.iLocX <= -176 && GameFile.iLocY >= 84
					&& GameFile.iLocY <= 156 && GameFile.iaGameVars[2] >= 5) {
				GameFile.iLocation = 1;
				GameFile.iLocX = -372;
				GameFile.iLocY = 408;
			} else if (GameFile.iLocX <= -176 && GameFile.iLocY >= 84
					&& GameFile.iLocY <= 156) {
				GameFile.iLocation = 1;
				GameFile.iLocX = -156;
				GameFile.iLocY = 176;
			} else if (GameFile.iLocX <= -272 && GameFile.iLocY <= -256) {
				GameFile.iLocX = -272;
				GameFile.iLocY = -256;
			} else if (GameFile.iLocX >= 304 && GameFile.iLocY >= 168) {
				GameFile.iLocX = 304;
				GameFile.iLocY = 168;
			} else if (GameFile.iLocX >= 304 && GameFile.iLocY <= -256) {
				GameFile.iLocX = 304;
				GameFile.iLocY = -256;
			} else if (GameFile.iLocY <= -256) {
				GameFile.iLocY = -256;
			} else if (GameFile.iLocY >= 168) {
				GameFile.iLocY = 168;
			} else if (GameFile.iLocX <= -272) {
				GameFile.iLocX = -272;
			} else if (GameFile.iLocX >= 304) {
				GameFile.iLocX = 304;
			}
			g.drawImage(house, GameFile.iLocX, GameFile.iLocY, this);
		}

		if (GameFile.iaGameVars[1] >= 0 && GameFile.iaGameVars[1] <= 2) {
			g.drawImage(boyLeft, 335, 300, this);
			g.drawImage(dialog, 0, 500, this);
			if (GameFile.iaGameVars[1] == 0) {
				g.drawString("Jayce: About time you woke up", 10, 550);
				g.drawString("You sleepy head.", 110, 590);
			} else if (GameFile.iaGameVars[1] == 1) {
				g.drawString("Jayce: Watching you sleep like a baby, ", 10, 550);
				g.drawString("I just had to kick your face out of bed", 10, 590);
			} else if (GameFile.iaGameVars[1] == 2) {
				g.drawString("Jayce: Come on " + GameFile.strPlayerName
						+ "! Me and Natalie ", 10, 550);
				g.drawString("are waiting for you at my house. ", 10, 590);
			}
		}
		if (GameFile.iaGameVars[1] == 3) {
			tmrBoyUp.start();
			if (boyY % 45 >= 30) {
				g.drawImage(boyUp2, 335, 295 - boyY, this);
			} else if (boyY % 45 >= 15) {
				g.drawImage(boyUp1, 335, 295 - boyY, this);
			} else if (boyY % 45 >= 0) {
				g.drawImage(boyUp, 335, 295 - boyY, this);
			}
			if (boyY >= 120) {
				GameFile.iaGameVars[1] = GameFile.iaGameVars[1] + 1;
			}
		}
		if (GameFile.iaGameVars[1] == 4) {
			tmrBoyUp.stop();
			tmrBoyRight.start();
			if (boyX % 45 >= 30) {
				g.drawImage(boyRight2, 335 + boyX, 185, this);
			} else if (boyX % 45 >= 15) {
				g.drawImage(boyRight1, 335 + boyX, 185, this);
			} else if (boyX % 45 >= 0) {
				g.drawImage(boyRight, 335 + boyX, 185, this);
			}
			if (boyX >= 130) {
				GameFile.iaGameVars[1] = GameFile.iaGameVars[1] + 1;
				boyX = 0;
				boyY = 0;
			}
		}
		if (GameFile.iLocation == 1) {

			if (GameFile.iLocX >= -364 && GameFile.iLocX <= -260
					&& GameFile.iLocY >= 400 && GameFile.iLocY <= 440) {
				GameFile.iLocation = 0;
				GameFile.iLocX = -168;
				GameFile.iLocY = 128;
			} else if (GameFile.iLocX <= -148 && GameFile.iLocX >= -228
					&& GameFile.iLocY <= -16) {
				GameFile.iLocation = 2;
				GameFile.iLocX = -52;
				GameFile.iLocY = -392;
			} else if (GameFile.iLocX <= -468 && GameFile.iLocY >= 456) {
				GameFile.iLocX = -468;
				GameFile.iLocY = 456;
			} else if (GameFile.iLocX <= -468 && GameFile.iLocY <= -8) {
				GameFile.iLocX = -468;
				GameFile.iLocY = -8;
			} else if (GameFile.iLocX >= 92 && GameFile.iLocY <= -8) {
				GameFile.iLocX = 92;
				GameFile.iLocY = -8;
			} else if (GameFile.iLocX >= 92 && GameFile.iLocY >= 456) {
				GameFile.iLocX = 92;
				GameFile.iLocY = 456;
			} else if (GameFile.iLocX >= 92) {
				GameFile.iLocX = 92;
			} else if (GameFile.iLocX <= -468) {
				GameFile.iLocX = -468;
			} else if (GameFile.iLocY >= 456) {
				GameFile.iLocY = 456;
			} else if (GameFile.iLocY <= -8) {
				GameFile.iLocY = -8;
			}

			if (GameFile.iaGameVars[2] == 0) {
				tmrBoyRight.stop();
				g.drawImage(house1bot, GameFile.iLocX, GameFile.iLocY, this);
				g.drawImage(dadDown, GameFile.iLocX + 215,
						GameFile.iLocY + 365, this);
				tmrDadStart.start();
				if (boyX >= 30) {
					GameFile.iaGameVars[2] = 1;
					boyX = 0;
				}
			}
			if (GameFile.iaGameVars[2] == 1) {
				tmrDadStart.stop();
				tmrDadDown.start();
				g.drawImage(house1bot, GameFile.iLocX, GameFile.iLocY - boyY,
						this);
				g.drawImage(dadRight, GameFile.iLocX + 215, GameFile.iLocY
						+ 365 - boyY, this);
				g.drawImage(exclam, GameFile.iLocX + 215, GameFile.iLocY + 325
						- boyY, this);
				rightStep = -1;
				leftStep = -1;
				upStep = -1;
				if (boyY % 45 >= 30) {
					g.drawImage(down2, 300, 300, this);
				} else if (boyY % 45 >= 15) {
					g.drawImage(down1, 300, 300, this);
				} else if (boyY % 45 >= 0) {
					g.drawImage(down, 300, 300, this);
				}
				if (boyY >= 240) {
					GameFile.iaGameVars[2] = 2;
				}
			}
			if (GameFile.iaGameVars[2] == 2) {
				tmrDadDown.stop();
				tmrDadLeft.start();
				g.drawImage(house1bot, GameFile.iLocX + boyX, GameFile.iLocY
						- boyY, this);
				g.drawImage(dadRight, GameFile.iLocX + 215 + boyX,
						GameFile.iLocY + 365 - boyY, this);
				g.drawImage(exclam, GameFile.iLocX + 215 + boyX, GameFile.iLocY
						+ 325 - boyY, this);

				if (boyX % 45 >= 30) {
					g.drawImage(left2, 300, 300, this);
				} else if (boyX % 45 >= 15) {
					g.drawImage(left1, 300, 300, this);
				} else if (boyX % 45 >= 0) {
					g.drawImage(left, 300, 300, this);
				}
				if (boyX >= 210) {
					GameFile.iaGameVars[2] = 3;
					leftStep = 0;
				}
			}
			if (GameFile.iaGameVars[2] >= 3) {
				tmrDadLeft.stop();
				g.drawImage(house1bot, GameFile.iLocX + boyX, GameFile.iLocY
						- boyY, this);
				if (GameFile.iaGameVars[2] >= 3 && GameFile.iaGameVars[2] <= 4) {
					g.drawImage(dadRight, GameFile.iLocX + 215 + boyX,
							GameFile.iLocY + 365 - boyY, this);
				}
				if (GameFile.iaGameVars[2] == 3) {
					g.drawImage(dialog, 5, 500, this);
					g.drawString("Dad: Hey Son, Today is a big day for you ",
							20, 540);
					g.drawString("Starting today your a Pokemon Trainer", 20,
							580);
				}
				if (GameFile.iaGameVars[2] == 4) {
					g.drawImage(dialog, 5, 500, this);
					g.drawString("Dad: I know if your Mom was here", 20, 540);
					g.drawString("She would have been happy for you.", 20, 580);
				}
			}
			if (GameFile.iaGameVars[2] >= 5 && dadLocation == 0) {
				g.drawImage(dadRight, GameFile.iLocX + 215 + boyX,
						GameFile.iLocY + 365 - boyY, this);
			} else if (GameFile.iaGameVars[2] >= 5 && dadLocation == 1) {
				g.drawImage(dadUp, GameFile.iLocX + 215 + boyX, GameFile.iLocY
						+ 365 - boyY, this);
			} else if (GameFile.iaGameVars[2] >= 5 && dadLocation == 2) {
				g.drawImage(dadDown, GameFile.iLocX + 215 + boyX,
						GameFile.iLocY + 365 - boyY, this);
			} else if (GameFile.iaGameVars[2] >= 5 && dadLocation == 3) {
				g.drawImage(dadLeft, GameFile.iLocX + 215 + boyX,
						GameFile.iLocY + 365 - boyY, this);
			}
			if (text == 1) {
				g.drawImage(dialog, 5, 500, this);
				g.drawString("Dad: Good luck on your journey! ", 20, 540);
			}
		}

		if (GameFile.iLocation == 2) {
			if (GameFile.iLocX >= -60 && GameFile.iLocX <= -44
					&& GameFile.iLocY <= -368 && GameFile.iLocY >= -384) {
				GameFile.iLocation = 1;
				GameFile.iLocX = -180;
				GameFile.iLocY = -8;
				townSign = 0;
				showSign = 0;
			} else if (GameFile.iLocX <= -748 && GameFile.iLocY >= -104) {
				GameFile.iLocX = -748;
				GameFile.iLocY = -104;
			} else if (GameFile.iLocX >= 132 && GameFile.iLocY >= -104) {
				GameFile.iLocX = 132;
				GameFile.iLocY = -104;
			} else if (GameFile.iLocX <= -356 && GameFile.iLocY >= -104) {
				GameFile.iLocY = -104;
			} else if (GameFile.iLocX >= -212 && GameFile.iLocY >= -104) {
				GameFile.iLocY = -104;
			} else if (GameFile.iLocX <= -748 && GameFile.iLocY <= -800) {
				GameFile.iLocX = -748;
				GameFile.iLocY = -800;
			} else if (GameFile.iLocX >= 132 && GameFile.iLocY <= -800) {
				GameFile.iLocX = 132;
				GameFile.iLocY = -800;
			} else if (GameFile.iLocX <= -68 && GameFile.iLocX >= -548
					&& GameFile.iLocY <= -832) {
				GameFile.iLocY = -832;
			} else if (GameFile.iLocY <= -800 && GameFile.iLocX <= -556) {
				GameFile.iLocY = -800;
			} else if (GameFile.iLocY <= -800 && GameFile.iLocX >= -60) {
				GameFile.iLocY = -800;
			} else if (GameFile.iLocX <= -748) {
				GameFile.iLocX = -748;
			} else if (GameFile.iLocX >= 132) {
				GameFile.iLocX = 132;
			}
			if (GameFile.iaGameVars[3] != 5 && GameFile.iaGameVars[3] != 6) {
				g.drawImage(map, GameFile.iLocX + 67, GameFile.iLocY + 285,
						this);
				g.drawImage(route1, GameFile.iLocX + 67, GameFile.iLocY - 1155,
						this);
			}
			if (GameFile.iaGameVars[4] == 0) {
				if (gate == 0 || gate == 5) {
					g.drawImage(gateDown, GameFile.iLocX + 648,
							GameFile.iLocY + 380, this);
					gateX = 0;
				} else if (gate == 1) {
					tmrGateLeft.start();
					if (gateX % 45 >= 30) {
						g.drawImage(gateLeft2, GameFile.iLocX + 648 - gateX,
								284, this);
					} else if (gateX % 45 >= 15) {
						g.drawImage(gateLeft1, GameFile.iLocX + 648 - gateX,
								284, this);
					} else if (gateX % 45 >= 0) {
						g.drawImage(gateLeft, GameFile.iLocX + 648 - gateX,
								284, this);
					}
					if (gateX - GameFile.iLocX >= 348) {
						gate = 2;
						tmrGateLeft.stop();
					}
				} else if (gate == 2 || gate == 3) {
					g.drawImage(gateDown, 300, 284, this);
				} else if (gate == 4) {
					tmrGateRight.start();
					if (gateX % 45 >= 30) {
						g.drawImage(gateRight2, 300 + gateX, 284, this);
					} else if (gateX % 45 >= 15) {
						g.drawImage(gateRight1, 300 + gateX, 284, this);
					} else if (gateX % 45 >= 0) {
						g.drawImage(gateRight, 300 + gateX, 284, this);
					}
					if (gateX - GameFile.iLocX >= 348) {
						gate = 5;
						tmrGateRight.stop();
					}
				}
			}
		}

		if (downStep >= 18) {
			g.drawImage(down2, 300, 300, this);
		} else if (downStep >= 12) {
			g.drawImage(down, 300, 300, this);
		} else if (downStep >= 6) {
			g.drawImage(down1, 300, 300, this);
		} else if (downStep >= 0) {
			g.drawImage(down, 300, 300, this);
		}

		if (upStep >= 18) {
			g.drawImage(up2, 300, 300, this);
		} else if (upStep >= 12) {
			g.drawImage(up, 300, 300, this);
		} else if (upStep >= 6) {
			g.drawImage(up1, 300, 300, this);
		} else if (upStep >= 0) {
			g.drawImage(up, 300, 300, this);
		}

		if (rightStep >= 18) {
			g.drawImage(right2, 300, 300, this);
		} else if (rightStep >= 12) {
			g.drawImage(right, 300, 300, this);
		} else if (rightStep >= 6) {
			g.drawImage(right1, 300, 300, this);
		} else if (rightStep >= 0) {
			g.drawImage(right, 300, 300, this);
		}

		if (leftStep >= 18) {
			g.drawImage(left2, 300, 300, this);
		} else if (leftStep >= 12) {
			g.drawImage(left, 300, 300, this);
		} else if (leftStep >= 6) {
			g.drawImage(left1, 300, 300, this);
		} else if (leftStep >= 0) {
			g.drawImage(left, 300, 300, this);
		}

		if (GameFile.iLocation == 2) {
			g.drawImage(house1, GameFile.iLocX + 319, GameFile.iLocY + 520,
					this);
			g.drawImage(house2, GameFile.iLocX + 755, GameFile.iLocY + 525,
					this);
			g.drawImage(house3, GameFile.iLocX + 320, GameFile.iLocY + 865,
					this);
			g.drawImage(house4, GameFile.iLocX + 770, GameFile.iLocY + 865,
					this);
			g.drawImage(lamppost, GameFile.iLocX + 512, GameFile.iLocY + 620,
					this);
			g.drawImage(lamppost, GameFile.iLocX + 512, GameFile.iLocY + 955,
					this);
			g.drawImage(lamppost, GameFile.iLocX + 676, GameFile.iLocY + 620,
					this);
			g.drawImage(lamppost, GameFile.iLocX + 676, GameFile.iLocY + 955,
					this);
			g.drawImage(mailbox, GameFile.iLocX + 327, GameFile.iLocY + 692,
					this);
			g.drawImage(mailbox2, GameFile.iLocX + 775, GameFile.iLocY + 692,
					this);
			g.drawImage(columnTrees, GameFile.iLocX - 386,
					GameFile.iLocY + 287, this);
			g.drawImage(columnTrees, GameFile.iLocX + 1183,
					GameFile.iLocY + 287, this);

			if (townSign == 0) {
				tmrSign.start();
				g.setFont(f2);
				g.drawImage(sign, 2, 20, this);
				g.drawString("Exitium Town", 45, 75);
				g.setFont(f1);

				if (showSign >= 300) {
					townSign = 1;
					tmrSign.stop();
				}
			}

			if (boyLocation == 0) {
				g.drawImage(boyDown, GameFile.iLocX + 800,
						GameFile.iLocY + 680, this);
			}

			if (girlLocation == 0) {
				g.drawImage(girlDown, GameFile.iLocX + 824,
						GameFile.iLocY + 680, this);
			} else if (girlLocation == 1) {
				g.drawImage(girlRight, GameFile.iLocX + 824,
						GameFile.iLocY + 680, this);
			}

			if (gateText == 1) {
				g.drawImage(dialog, 5, 500, this);
				g.drawString("Hey, You are not allowed to pass", 20, 540);
				g.drawString("Wild Pokemon can attack you", 20, 580);
			} else if (gateText == 2) {
				g.drawImage(dialog, 5, 500, this);
				g.drawString("You need pokemon to defend yourself", 20, 540);
			}
			if (gate == 2) {
				g.drawImage(dialog, 5, 500, this);
				g.drawString("Hey, You are not allowed to pass", 20, 540);
				g.drawString("Wild Pokemon can attack you", 20, 580);
				gateX = 0;
			} else if (gate == 3) {
				g.drawImage(dialog, 5, 500, this);
				g.drawString("You need pokemon to defend yourself", 20, 540);
			}

		}

		if (exitiumSign == 1) {
			g.drawImage(dialog2, 5, 500, this);
			g.drawString("Exitium Town ", 20, 540);
			g.drawString("The Start of Something Epic ", 20, 580);
		}

		if (houseSign == 1) {
			g.drawImage(dialog3, 5, 500, this);
			g.drawString(GameFile.strPlayerName + " House ", 20, 540);
		}

		if (jayceSign == 1) {
			g.drawImage(dialog3, 5, 500, this);
			g.drawString("Jayce House ", 20, 540);
		}

		if (GameFile.iaGameVars[3] == 1) {
			g.drawImage(dialog, 5, 500, this);
			g.drawString("Natalie: Good Morning " + GameFile.strPlayerName, 20,
					540);
		} else if (GameFile.iaGameVars[3] == 2) {
			g.drawImage(dialog, 5, 500, this);
			g.drawString("Jayce: I know what you are thinking,", 20, 540);
			g.drawString("and yes, we come bearing gifts of pokemon", 20, 580);
		} else if (GameFile.iaGameVars[3] == 3) {
			g.drawImage(dialog, 5, 500, this);
			g.drawString("Jayce: Now stop drooling and pick one", 20, 540);
		} else if (GameFile.iaGameVars[3] == 4) {
			g.drawImage(dialog, 5, 500, this);
			g.drawString("Natalie: Jayce! Don’t be so mean!", 20, 540);
			g.drawString("Go ahead and pick one, we’ll wait.", 20, 580);
		} else if (GameFile.iaGameVars[3] >= 5 && GameFile.iaGameVars[3] <= 6) {
			GameFile.iaGameVars[0] = start % 3;

			if (GameFile.iaGameVars[0] == 0) {
				g.drawImage(cosmetStart, 0, 25, this);
				g.drawImage(cosmet, 210, 100, this);
				g.drawString("The Water-type Pokemon", 150, 265);
				g.drawString("Cosmet", 250, 300);
				g.drawImage(hand, 430, 380, this);

				if (GameFile.iaGameVars[3] == 6) {
					g.drawImage(dialog, 5, 500, this);
					g.drawString("Are you sure you want to pick Cosmet", 20,
							540);
					GameFile.pokemonParty[0] = "Cosmet";
					GameFile.pokemon1MoveSet[0] = "Tackle";
					GameFile.pokemon1MoveSet[1] = "Leer";
				}
			} else if (GameFile.iaGameVars[0] == 1) {
				g.drawImage(tykepolStart, 0, 25, this);
				g.drawImage(tykepol, 210, 95, this);
				g.drawString("The Grass-type Pokemon", 150, 265);
				g.drawString("Tykepol", 250, 298);
				g.drawImage(hand, 295, 320, this);

				if (GameFile.iaGameVars[3] == 6) {
					g.drawImage(dialog, 5, 500, this);
					g.drawString("Are you sure you want to pick Tykepol", 20,
							540);
					GameFile.pokemonParty[0] = "Tykepol";
					GameFile.pokemon1MoveSet[0] = "Tackle";
					GameFile.pokemon1MoveSet[1] = "Tail Whip";
				}
			} else if (GameFile.iaGameVars[0] == 2) {
				g.drawImage(embiteStart, 0, 25, this);
				g.drawImage(embite, 230, 85, this);
				g.drawString("The Fire-type Pokémon", 150, 265);
				g.drawString("Embite", 250, 300);
				g.drawImage(hand, 150, 380, this);

				if (GameFile.iaGameVars[3] == 6) {
					g.drawImage(dialog, 5, 500, this);
					g.drawString("Are you sure you want to pick Embite", 20,
							540);
					GameFile.pokemonParty[0] = "Embite";
					GameFile.pokemon1MoveSet[0] = "Tackle";
					GameFile.pokemon1MoveSet[1] = "Growl";
				}
			}

			if (GameFile.iaGameVars[3] == 5) {
				g.setColor(Color.WHITE);
				g.drawString("Choose a Pokémon", 200, 585);
				g.setColor(Color.BLACK);
			}

			if (GameFile.iaGameVars[3] == 6) {
				g.drawString("         Yes                      No", 20, 580);
				if (yes == 0) {
					g.drawImage(arrow, 410, 555, this);
				} else if (yes == 1) {
					g.drawImage(arrow, 160, 555, this);
				}
			}
		} else if (GameFile.iaGameVars[3] == 7) {
			g.drawImage(dialog, 5, 500, this);
			GameFile.pokemonLevels[0] = 5;
			g.drawString("Jayce: Wow, that Pokemon is so ugly,", 20, 540);
			g.drawString("yet it compliments your face so perfectly", 20, 580);
			GameFile.pokemon1Ivs[0] = r.nextInt(30) + 1;
			GameFile.pokemon1Ivs[1] = r.nextInt(30) + 1;
			GameFile.pokemon1Ivs[2] = r.nextInt(30) + 1;
			GameFile.pokemon1Ivs[3] = r.nextInt(30) + 1;
			GameFile.pokemon1Ivs[4] = r.nextInt(30) + 1;
			GameFile.pokemon1Ivs[5] = r.nextInt(30) + 1;
		} else if (GameFile.iaGameVars[3] == 8) {
			g.drawImage(dialog, 5, 500, this);
			g.drawString("Natalie: Ok, I'll choose this Pokemon", 20, 540);
			g.setColor(Color.BLUE);
			if (GameFile.iaGameVars[0] == 0) {
				g.drawString("             Natalie choose Tykepol", 20, 580);
			} else if (GameFile.iaGameVars[0] == 1) {
				g.drawString("             Natalie choose Embite", 20, 580);
			} else if (GameFile.iaGameVars[0] == 2) {
				g.drawString("             Natalie choose Cosmet", 20, 580);
			}
			g.setColor(Color.BLACK);
		} else if (GameFile.iaGameVars[3] == 9) {
			g.drawImage(dialog, 5, 500, this);
			g.drawString("Jayce: And I guess the best pick last", 20, 540);
			g.setColor(Color.BLUE);
			if (GameFile.iaGameVars[0] == 0) {
				g.drawString("             Jayce choose Embite", 20, 580);
			} else if (GameFile.iaGameVars[0] == 1) {
				g.drawString("             Jayce choose Cosmet", 20, 580);
			} else if (GameFile.iaGameVars[0] == 2) {
				g.drawString("             Jayce choose Tykepol", 20, 580);
			}
			g.setColor(Color.BLACK);
		} else if (GameFile.iaGameVars[3] == 10) {
			g.drawImage(dialog, 5, 500, this);
			g.drawString("Natalie:", 20, 540);
			g.drawString("How about we try these little guys out?", 20, 580);
		} else if (GameFile.iaGameVars[3] == 11) {
			g.drawImage(mainBattleBack, -600 + battleVelX, 100, this);
			g.drawImage(natalieBattleBack, 600 - battleVelX, 400, this);
			tmrBattle.start();

			if (battleVelX >= 600) {
				tmrBattle.stop();
				g.drawImage(vs2, 200, 250, this);
				g.drawImage(mainHead, 30, 100, this);
				g.drawImage(natalieHead, 400, 400, this);
				tmrBattle2.start();
			}

			if (battleVelY >= 110) {
				tmrBattle2.stop();
				GameFile.iaGameVars[3] = 12;
				GameFile.saveFile();

				try {
					FriendsRivals.renameThisMethodJuliusUsingAltShiftR();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.err.println("This code. This code.");
				}
			}
		} else if (GameFile.iaGameVars[3] >= 13 && GameFile.iaGameVars[3] <= 20) {
			g.drawImage(dialog, 5, 500, this);

			if (GameFile.iaGameVars[3] == 13) {
				if (GameFile.iWin == 1) {
					g.drawString("Natalie: Yay, I won my first battle!", 20,
							540);
				} else if (GameFile.iWin == 2) {
					g.drawString("Natalie: I lost, I wish Daddy was here!", 20,
							540);
				}
			} else if (GameFile.iaGameVars[3] == 14) {
				if (GameFile.iWin == 1) {
					g.drawString("Jayce: Haha " + GameFile.strPlayerName
							+ ", losing to a girl!", 20, 540);
					g.drawString("Your such a pathetic loser.", 20, 580);
				} else if (GameFile.iWin == 2) {
					g.drawString("Jayce: How could you "
							+ GameFile.strPlayerName + " ! Beating", 20, 540);
					g.drawString("up a girl. Shame on you.", 20, 580);
				}
			} else if (GameFile.iaGameVars[3] == 15) {
				g.drawString("Natalie: Let me give you a present.", 20, 540);
				g.setColor(Color.BLUE);
				g.drawString(GameFile.strPlayerName + " obtained a bag.", 20,
						580);
				g.setColor(Color.BLACK);
			} else if (GameFile.iaGameVars[3] == 16) {
				g.drawString("Natalie: You can press the X key to", 20, 540);
				g.drawString("open up the bag.", 20, 580);
			} else if (GameFile.iaGameVars[3] == 17) {
				g.drawString("Jayce: Here " + GameFile.strPlayerName
						+ ",  a gift to the poor.", 20, 540);
				g.setColor(Color.BLUE);
				g.drawString(GameFile.strPlayerName + " obtained 5 Pokeballs.",
						20, 580);
				g.setColor(Color.BLACK);
			} else if (GameFile.iaGameVars[3] == 18) {
				g.drawString("Jayce: To start our new adventure.", 20, 540);
				g.drawString("Lets meet up at MapleLodge Town!", 20, 580);
			} else if (GameFile.iaGameVars[3] == 19) {
				g.drawString("Natalie: Wait, let me heal your", 20, 540);
				g.drawString("Pokemon " + GameFile.strPlayerName + ".", 20, 580);
			} else if (GameFile.iaGameVars[3] == 20) {
				g.drawString("Natalie: If your Pokemon are injured.", 20, 540);
				g.drawString("Talk to me and I will heal your Pokemon.", 20,
						580);
			}
		}
		// int gateCordX= GameFile.iLocX+ 648 , gateCordY = GameFile.iLocY+380;
		if (z % 2 == 1) {
			g.drawString(GameFile.iLocX + "  " + GameFile.iLocY + "  "
					+ GameFile.iLocation + "  " + girlLocation + "   "
					+ GameFile.iaGameVars[3], 250, 300);
		}
		// Graphics2D g2 = (Graphics2D)g;
		// for(int GameFile.iLocX=0;GameFile.iLocX<=600;GameFile.iLocX+=25){
		// g2.drawLine(GameFile.iLocX,0,GameFile.iLocX,600);
		// g2.drawString(""+GameFile.iLocX,GameFile.iLocX,20);
		// }
		// for(int GameFile.iLocY=0;GameFile.iLocY<=600;GameFile.iLocY+=25){
		// g2.drawLine(0,GameFile.iLocY,600,GameFile.iLocY);
		// g2.drawString(""+GameFile.iLocY,0,GameFile.iLocY+20);
		// }
		repaint();
	}

}