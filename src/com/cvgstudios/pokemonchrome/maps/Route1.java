package com.cvgstudios.pokemonchrome.maps;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JFrame;

import com.cvgstudios.pokemonchrome.GameFile;
import com.cvgstudios.pokemonchrome.entities.Player;
import com.cvgstudios.pokemonchrome.images.Images;

public class Route1 extends JFrame implements ActionListener {

	final long KEYDELAY = 1000000;
	long lSystime;
	long lTimeL;
	long lTimeU;
	long lTimeR;
	long lTimeD;
	int velX = 4, velY = 4, z = 0;
	private Image dbImage;//
	private Graphics dbg;// double buffer
	int downStep = -1, upStep = 0, leftStep = -1, rightStep = -1;
	int[] party;

	Image[] playerUp = { Images.PlayerUp.getImage(),
			Images.PlayerUp1.getImage(), Images.PlayerUp2.getImage() };
	Image[] playerDown = { Images.PlayerDown.getImage(),
			Images.PlayerDown1.getImage(), Images.PlayerDown2.getImage() };
	Image[] playerRight = { Images.PlayerRight.getImage(),
			Images.PlayerRight1.getImage(), Images.PlayerRight2.getImage() };

	Image[] playerLeft = { Images.PlayerLeft.getImage(),
			Images.PlayerLeft1.getImage(), Images.PlayerLeft2.getImage() };
	Player player = new Player(200, 200, playerLeft, playerRight, playerDown,
			playerUp);

	Image route1, down, down1, down2, left, left1, left2, right, right1,
			right2, up, up1, up2, exitium, mapleLodge;
	Image columnTrees, pokeball3, train1Right, train1Right1, train1Right2,
			train1Left, train1Left1, train1Left2;
	Image train2Right, train2Right1, train2Right2, train2Left, train2Left1,
			train2Left2, pileBlock, gate2Left, gate2Down;

	File f = new File("PokemonFont.ttf");
	FileInputStream in = new FileInputStream(f);
	Font dFont = Font.createFont(Font.TRUETYPE_FONT, in);
	Font f1 = dFont.deriveFont(40f), f2 = dFont.deriveFont(50f);

	public static void main(String[] args) throws Exception {
		Route1 mainMenu = new Route1();
	}

	public Route1() throws Exception {
		route1 = Images.Route1.getImage();
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
		exitium = Images.Exitium.getImage();
		columnTrees = Images.ColumnTrees.getImage();
		// pokeball3 = Images.Pokeball3.getImage();
		// train1Right = Images.Trainer1Right.getImage();
		// train1Right1 = Images.Trainer1Right1.getImage();
		// train1Right2 = Images.Trainer1Right2.getImage();
		// train1Left = Images.Trainer1Left.getImage();
		// train1Left1 = Images.Trainer1Left1.getImage();
		// train1Left2 = Images.Trainer1Left2.getImage();
		// train2Right = Images.Trainer2Right.getImage();
		// train2Right1 = Images.Trainer2Right1.getImage();
		// train2Right2 = Images.Trainer2Right2.getImage();
		// train2Left = Images.Trainer2Left.getImage();
		// train2Left1 = Images.Trainer2Left1.getImage();
		// train2Left2 = Images.Trainer2Left2.getImage();
		// pileBlock = Images.PileBlock.getImage();
		// gate2Left = Images.Gate2Left.getImage();
		// gate2Down = Images.Gate2Down.getImage();
		mapleLodge = Images.MapleLodge.getImage();

		addKeyListener(new AL());
		setTitle("Pokemon Chrome");// Sets the Title
		setSize(600, 600);// Size of Window
		setResizable(false);// Cannot resize the window
		setVisible(true);// Makes it visible
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GameFile.iLocX = GameFile.iLocX + 4;
	}

	public void actionPerformed(ActionEvent e) {
	}

	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();// Get key preseed
			if (keyCode == e.VK_Z) {
				z = z + 1;
			}
			if (keyCode == e.VK_S) {
			}
			long nanoTime = System.nanoTime();
			if (keyCode == e.VK_LEFT && nanoTime - lTimeU > KEYDELAY
					&& nanoTime - lTimeD > KEYDELAY) {// moves object left
				if (GameFile.iLocX >= 28 && GameFile.iLocY <= 24
						|| GameFile.iLocX >= -44 && GameFile.iLocX <= -36
						&& GameFile.iLocY >= 168 && GameFile.iLocY <= 192
						|| GameFile.iLocX >= 428 && GameFile.iLocY >= 32
						&& GameFile.iLocY <= 1168 || GameFile.iLocX >= 172
						&& GameFile.iLocX <= 180 && GameFile.iLocY >= 1176
						&& GameFile.iLocY <= 1320 || GameFile.iLocX >= 172
						&& GameFile.iLocX <= 180 && GameFile.iLocY >= 936
						&& GameFile.iLocY <= 1024) {
					upStep = -1;
					downStep = -1;
					rightStep = -1;
					leftStep = leftStep + 1;
					player.moveLeft();
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
				if (GameFile.iLocX <= -52 && GameFile.iLocY <= 24
						|| GameFile.iLocX <= -220 && GameFile.iLocX >= -228
						&& GameFile.iLocY <= 192 && GameFile.iLocY >= 32
						|| GameFile.iLocX >= 28 && GameFile.iLocX <= 36
						&& GameFile.iLocY >= 168 && GameFile.iLocY <= 192
						|| GameFile.iLocX >= 116 && GameFile.iLocX <= 124
						&& GameFile.iLocY >= 192 && GameFile.iLocY <= 368
						|| GameFile.iLocX >= -44 && GameFile.iLocX <= -36
						&& GameFile.iLocY >= 376 && GameFile.iLocY <= 464
						|| GameFile.iLocX >= 220 && GameFile.iLocX <= 228
						&& GameFile.iLocY >= 480 && GameFile.iLocY <= 736
						|| GameFile.iLocX >= 212 && GameFile.iLocX <= 220
						&& GameFile.iLocY >= 744 && GameFile.iLocY <= 800
						|| GameFile.iLocX >= 212 && GameFile.iLocX <= 220
						&& GameFile.iLocY >= 880 && GameFile.iLocY <= 1024
						|| GameFile.iLocX >= -36 && GameFile.iLocX <= -28
						&& GameFile.iLocY >= 1224 && GameFile.iLocY <= 1376
						|| GameFile.iLocX >= -44 && GameFile.iLocX <= -36
						&& GameFile.iLocY >= 1032 && GameFile.iLocY <= 1216
						|| GameFile.iLocX >= 52 && GameFile.iLocX <= 60
						&& GameFile.iLocY >= 936 && GameFile.iLocY <= 1024) {
					leftStep = -1;
					rightStep = rightStep + 1;
					downStep = -1;
					upStep = -1;
					player.moveRight();
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
				if (GameFile.iLocX >= -220 && GameFile.iLocX <= -44
						&& GameFile.iLocY >= 192 && GameFile.iLocY <= 192
						|| GameFile.iLocX >= -36 && GameFile.iLocX <= 28
						&& GameFile.iLocY >= 160 && GameFile.iLocY <= 168
						|| GameFile.iLocX >= 36 && GameFile.iLocX <= 116
						&& GameFile.iLocY >= 192 && GameFile.iLocY <= 200
						|| GameFile.iLocX >= -36 && GameFile.iLocX <= 220
						&& GameFile.iLocY >= 464 && GameFile.iLocY <= 472
						|| GameFile.iLocX >= 180 && GameFile.iLocX <= 428
						&& GameFile.iLocY >= 1168 && GameFile.iLocY <= 1174
						|| GameFile.iLocX >= -28 && GameFile.iLocX <= 564
						&& GameFile.iLocY >= 1376 && GameFile.iLocY <= 1384
						|| GameFile.iLocX >= -44 && GameFile.iLocX <= -36
						&& GameFile.iLocY >= 1216 && GameFile.iLocY <= 1224) {
					leftStep = -1;
					downStep = -1;
					rightStep = -1;
					upStep = upStep + 1;
					player.moveUp();
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
				if (GameFile.iLocX <= -60 && GameFile.iLocY <= 32
						|| GameFile.iLocX >= 16 && GameFile.iLocY <= 32
						|| GameFile.iLocX >= -36 && GameFile.iLocX <= 116
						&& GameFile.iLocY >= 368 && GameFile.iLocY <= 376
						|| GameFile.iLocX >= 212 && GameFile.iLocX <= 220
						&& GameFile.iLocY >= 736 && GameFile.iLocY <= 744
						|| GameFile.iLocX >= 180 && GameFile.iLocX <= 556
						&& GameFile.iLocY >= 1320 && GameFile.iLocY <= 1328
						|| GameFile.iLocX >= -36 && GameFile.iLocX <= 52
						&& GameFile.iLocY >= 1024 && GameFile.iLocY <= 1032
						|| GameFile.iLocX >= 180 && GameFile.iLocX <= 212
						&& GameFile.iLocY >= 1024 && GameFile.iLocY <= 1032
						|| GameFile.iLocX >= 60 && GameFile.iLocX <= 172
						&& GameFile.iLocY >= 928 && GameFile.iLocY <= 936) {
					upStep = -1;
					leftStep = -1;
					rightStep = -1;
					downStep = downStep + 1;
					player.moveDown();
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
		leftStep = leftStep % 18;
		upStep = upStep % 18;
		rightStep = rightStep % 18;
		downStep = downStep % 18;
		// Map Change ==3
		g.drawImage(route1, GameFile.iLocX - 229, GameFile.iLocY - 1099, this);
		g.drawImage(exitium, GameFile.iLocX - 229, GameFile.iLocY + 341, this);
		g.drawImage(columnTrees, GameFile.iLocX - 681, GameFile.iLocY - 880,
				this);
		g.drawImage(columnTrees, GameFile.iLocX - 1134, GameFile.iLocY - 880,
				this);
		g.drawImage(columnTrees, GameFile.iLocX - 1587, GameFile.iLocY - 880,
				this);
		g.drawImage(columnTrees, GameFile.iLocX - 681, GameFile.iLocY - 355,
				this);
		g.drawImage(columnTrees, GameFile.iLocX + 892, GameFile.iLocY - 880,
				this);
		g.drawImage(columnTrees, GameFile.iLocX + 892, GameFile.iLocY - 355,
				this);
		g.drawImage(columnTrees, GameFile.iLocX - 229, GameFile.iLocY - 2057,
				this);
		g.drawImage(columnTrees, GameFile.iLocX + 224, GameFile.iLocY - 2057,
				this);
		g.drawImage(columnTrees, GameFile.iLocX + 677, GameFile.iLocY - 2057,
				this);
		g.drawImage(pokeball3, GameFile.iLocX + 620, GameFile.iLocY + 190, this);
		g.drawImage(pokeball3, GameFile.iLocX + 328, GameFile.iLocY - 98, this);
		g.drawImage(pokeball3, GameFile.iLocX + 238, GameFile.iLocY - 624, this);
		g.drawImage(pokeball3, GameFile.iLocX + 750, GameFile.iLocY - 828, this);
		g.drawImage(train1Right, GameFile.iLocX - 128, GameFile.iLocY - 140,
				this);
		g.drawImage(train2Left, GameFile.iLocX + 87, GameFile.iLocY - 650, this);
		g.drawImage(pileBlock, GameFile.iLocX + 130, GameFile.iLocY - 543, this);
		g.drawImage(gate2Left, GameFile.iLocX + 114, GameFile.iLocY - 510, this);
		g.drawImage(mapleLodge, GameFile.iLocX - 1319, GameFile.iLocY - 1840,
				this);

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
		if (z % 2 == 1) {
			g.drawString(GameFile.iLocX + "  " + GameFile.iLocY + "  "
					+ GameFile.iLocation + "  ", 250, 300);
		}
		player.render(g);

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