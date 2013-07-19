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

import javax.swing.JFrame;
import javax.swing.Timer;

import com.cvgstudios.pokemonchrome.GameFile;
import com.cvgstudios.pokemonchrome.images.Images;

public class MiracleForest extends JFrame implements ActionListener {
	ClassLoader cl = MiracleForest.class.getClassLoader();

	final long KEYDELAY = 1000000;
	long lSystime;
	long lTimeL;
	long lTimeU;
	long lTimeR;
	long lTimeD;
	int mapChange = 6, forest = 2;
	private Image dbImage;//
	private Graphics dbg;// double buffer
	int downStep = -1, upStep = 0, leftStep = -1, rightStep = -1;
	Timer tmrFountain = new Timer(120, this);
	int[] party;
	Image miracleForest1, down, down1, down2, left, left1, left2, right,
			right1, right2, up, up1, up2, greenColumnTrees, greenColumnTrees2,
			forestEntrance, greenTreeOverlay, leftEntrance, rightEntrance,
			greenColumnTrees3, miracleForest2, miracleForest4;

	File f = new File("PokemonFont.ttf");
	FileInputStream in = new FileInputStream(f);
	Font dFont = Font.createFont(Font.TRUETYPE_FONT, in);
	Font f1 = dFont.deriveFont(40f), f2 = dFont.deriveFont(50f);

	public static void main(String[] args) throws Exception {
		MiracleForest mainMenu = new MiracleForest();
	}

	public MiracleForest() throws Exception {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
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
		miracleForest4 = Images.MiracleForest4.getImage();
		
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

	}

	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();// Get key preseed
			if (keyCode == e.VK_S) {
			}
			long nanoTime = System.nanoTime();
			if (keyCode == e.VK_LEFT && nanoTime - lTimeU > KEYDELAY
					&& nanoTime - lTimeD > KEYDELAY) {// moves object left
				GameFile.iLocX = GameFile.iLocX + 8;
				upStep = -1;
				downStep = -1;
				rightStep = -1;
				leftStep = leftStep + 1;
				lTimeL = nanoTime;
			}
			if (keyCode == e.VK_RIGHT && nanoTime - lTimeU > KEYDELAY
					&& nanoTime - lTimeD > KEYDELAY) {// moves object right
				if (GameFile.iLocX <= -368 && GameFile.iLocY <= 536
						&& GameFile.iLocY >= 424) {
					forest = 2;
					GameFile.iLocX = 0;
					GameFile.iLocY = 0;
				} else {
					GameFile.iLocX = GameFile.iLocX - 8;
					upStep = -1;
					leftStep = -1;
					downStep = -1;
					rightStep = rightStep + 1;
					lTimeR = nanoTime;
				}
			}
			if (keyCode == e.VK_UP && nanoTime - lTimeL > KEYDELAY
					&& nanoTime - lTimeR > KEYDELAY) {// moves object up
				GameFile.iLocY = GameFile.iLocY + 8;
				leftStep = -1;
				downStep = -1;
				rightStep = -1;
				upStep = upStep + 1;
				lTimeU = nanoTime;
			}
			if (keyCode == e.VK_DOWN && nanoTime - lTimeL > KEYDELAY
					&& nanoTime - lTimeR > KEYDELAY) {// moves object down
				GameFile.iLocY = GameFile.iLocY - 8;
				upStep = -1;
				leftStep = -1;
				rightStep = -1;
				downStep = downStep + 1;
				lTimeD = nanoTime;
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
		} else if (mapChange == 6 && forest == 2) {
			g.drawImage(miracleForest2, GameFile.iLocX + 220,
					GameFile.iLocY - 482, this);
		}

		if (downStep >= 12) {
			g.drawImage(down2, 300, 300, this);
		} else if (downStep >= 6) {
			g.drawImage(down1, 300, 300, this);
		} else if (downStep >= 0) {
			g.drawImage(down, 300, 300, this);
		}

		if (upStep >= 12) {
			g.drawImage(up2, 300, 300, this);
		} else if (upStep >= 6) {
			g.drawImage(up1, 300, 300, this);
		} else if (upStep >= 0) {
			g.drawImage(up, 300, 300, this);
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
		g.drawString(GameFile.iLocX + "  " + GameFile.iLocY + "  " + mapChange
				+ "  ", 250, 300);

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
}