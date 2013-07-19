package com.cvgstudios.pokemonchrome.maps;

import javax.swing.JFrame;

import java.awt.*;
import java.net.URL;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;

import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.cvgstudios.pokemonchrome.images.*;
import com.cvgstudios.pokemonchrome.*;

public class MapleLodge extends JFrame implements ActionListener {
	
	boolean TEMPVARIABLEFORENCOUNTERS = false;
	
	
	final long KEYDELAY = 1000000;
	long lSystime;
	long lTimeL;
	long lTimeU;
	long lTimeR;
	long lTimeD;
	int velX = 4, velY = 4, velFountain = 1, fountainChange = 0;;
	int mapChange = 4;
	private Image dbImage;//
	private Graphics dbg;// double buffer
	int downStep = -1, upStep = -1, leftStep = 0, rightStep = -1;
	Timer tmrFountain = new Timer(120, this);
	int[] party;
	Image route1, down, down1, down2, left, left1, left2, right, right1,
			right2, up, up1, up2, mapleLodge, columnTrees;
	Image fountain1, fountain2, fountainBase, route2;

	File f = new File("PokemonFont.ttf");
	FileInputStream in = new FileInputStream(f);
	Font dFont = Font.createFont(Font.TRUETYPE_FONT, in);
	Font f1 = dFont.deriveFont(40f), f2 = dFont.deriveFont(50f);


	public static void main(String[] args) throws Exception {
		MapleLodge mainMenu = new MapleLodge();
		GameFile.iLocX = 240;
	}

	public MapleLodge() throws Exception {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		mapleLodge = Images.MapleLodge.getImage();
		down = Images.PlayerDown.getImage();
		down1 = Images.PlayerDown1.getImage();
		down2 = Images.PlayerDown2.getImage();
		left = Images.PlayerLeft.getImage();
		left1 = Images.PlayerLeft1.getImage();
		left2 = Images.PlayerLeft2.getImage();
		right = Images.PlayerRight.getImage();
		right1 = Images.PlayerRight1.getImage();
		right2  = Images.PlayerRight2.getImage();
		up = Images.PlayerUp.getImage();
		up1 = Images.PlayerUp1.getImage();
		up2 = Images.PlayerUp2.getImage();
		columnTrees = Images.ColumnTrees.getImage();
		route1 = Images.Route1.getImage();
		fountain1 = Images.NatalieHead.getImage();
		fountain2 = Images.NatalieHead.getImage();
		fountainBase = Images.Natalie.getImage();
		route2 = Images.Route2.getImage();

		addKeyListener(new AL());
		setTitle("Pokemon Chrome");// Sets the Title
		setSize(600, 600);// Size of Window
		setResizable(false);// Cannot resize the window
		setVisible(true);// Makes it visible
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// new musicPlayPoke("Music/NimbasaCity.wav").start();
		
		
		Boundaries.initializeBoundaries();
		
		
	}

	public void actionPerformed(ActionEvent e) {
		if (mapChange == 4) {
			fountainChange = fountainChange + velFountain;
		}
		repaint();
	}

	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();// Get key preseed
			if (keyCode == e.VK_S) {
			}
			long nanoTime = System.nanoTime();
			if (keyCode == e.VK_LEFT && nanoTime - lTimeU > KEYDELAY
					&& nanoTime - lTimeD > KEYDELAY) {// moves object left

				if (BoundaryBox.isMovePossible(GameFile.iLocX, GameFile.iLocY,
						Direction.LEFT, Boundaries.getBoxes())) {
					GameFile.iLocX = GameFile.iLocX + 8;
				}
				
				
				TEMPVARIABLEFORENCOUNTERS = BoundaryBox.isEncountering();

				upStep = -1;
				downStep = -1;
				rightStep = -1;
				leftStep = leftStep + 1;
				lTimeL = nanoTime;
			} else if (keyCode == e.VK_RIGHT && nanoTime - lTimeU > KEYDELAY
					&& nanoTime - lTimeD > KEYDELAY) {// moves object right
				if (BoundaryBox.isMovePossible(GameFile.iLocX, GameFile.iLocY,
						Direction.RIGHT, Boundaries.getBoxes())) {
					GameFile.iLocX = GameFile.iLocX - 8;
				}
				
				TEMPVARIABLEFORENCOUNTERS = BoundaryBox.isEncountering();
				
				upStep = -1;
				leftStep = -1;
				downStep = -1;
				rightStep = rightStep + 1;
				lTimeR = nanoTime;
			} else if (keyCode == e.VK_UP && nanoTime - lTimeL > KEYDELAY
					&& nanoTime - lTimeR > KEYDELAY) {// moves object up
				if (BoundaryBox.isMovePossible(GameFile.iLocX, GameFile.iLocY,
						Direction.UP, Boundaries.getBoxes())) {
					GameFile.iLocY = GameFile.iLocY + 8;
					
					TEMPVARIABLEFORENCOUNTERS = BoundaryBox.isEncountering();
					
				}
				leftStep = -1;
				downStep = -1;
				rightStep = -1;
				upStep = upStep + 1;
				lTimeU = nanoTime;
			} else if (keyCode == e.VK_DOWN && nanoTime - lTimeL > KEYDELAY
					&& nanoTime - lTimeR > KEYDELAY) {// moves object down
				if (BoundaryBox.isMovePossible(GameFile.iLocX, GameFile.iLocY, Direction.DOWN, Boundaries.getBoxes())) {
					GameFile.iLocY = GameFile.iLocY - 8;
				}
				
				
				TEMPVARIABLEFORENCOUNTERS = BoundaryBox.isEncountering();
				
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
		if (mapChange == 4) {
			g.drawImage(columnTrees, GameFile.iLocX - 112,
					GameFile.iLocY + 461, this);
			g.drawImage(columnTrees, GameFile.iLocX - 565,
					GameFile.iLocY + 461, this);
			g.drawImage(columnTrees, GameFile.iLocX - 1018,
					GameFile.iLocY + 461, this);
			g.drawImage(mapleLodge, GameFile.iLocX - 750, GameFile.iLocY - 497,
					this);
			g.drawImage(route1, GameFile.iLocX + 341, GameFile.iLocY + 244,
					this);
			g.drawImage(columnTrees, GameFile.iLocX + 341,
					GameFile.iLocY - 714, this);
			g.drawImage(columnTrees, GameFile.iLocX - 1203,
					GameFile.iLocY - 497, this);
			g.drawImage(fountainBase, GameFile.iLocX - 241,
					GameFile.iLocY + 18, this);
			g.drawImage(route2, GameFile.iLocX - 750, GameFile.iLocY - 1497,
					this);
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

		if (mapChange == 4) {
			tmrFountain.start();
			if (fountainChange % 2 == 0) {
				g.drawImage(fountain1, GameFile.iLocX - 230,
						GameFile.iLocY - 30, this);
			} else if (fountainChange % 2 == 1) {
				g.drawImage(fountain2, GameFile.iLocX - 229,
						GameFile.iLocY - 30, this);
			}
		}
		g.drawString(GameFile.iLocX + "  " + GameFile.iLocY + "  " + mapChange
				+ "  " + (TEMPVARIABLEFORENCOUNTERS ? "YOU HAVE FOUND WILD POKEMONS OMGOMGOMGOMG" : "No Pokemon"), 250, 300);

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
	
	
	enum Boundaries{
		
		RightFenceLodge(new BoundaryBox(0, -24, 40, 840)),
		LeftFenceLodge(new BoundaryBox(984, 936, 1808, -152)),
		TopFenceLodge(new BoundaryBox(0, 864, 792, 840)),
		BottomFenceLodge(new BoundaryBox(-144, 976, -112, -152)),
		
		LeftArmPokelab(new BoundaryBox(664, 552, 576, 784)),
		
		RidgeTest(new BoundaryBox(632, 600, 1232, 848, Direction.LEFT)),
		
		GrassTest(new BoundaryBox(-400, -512, -408, -328, 0.05f)),
		
		;
		
		BoundaryBox theBoundary;
		static BoundaryBox[] theBoxes;
		
		
		private Boundaries(BoundaryBox theBox){
			theBoundary = theBox;
		}
		
		public BoundaryBox getBox(){
			return theBoundary;
		}
		
		public static void initializeBoundaries(){
			Boundaries[] theBoundaries = Boundaries.values();
			
			theBoxes = new BoundaryBox[theBoundaries.length];
			
			for (int i = 0; i < theBoundaries.length; i ++){
				theBoxes[i] = theBoundaries[i].getBox();
			}
		}
		
		public static BoundaryBox[] getBoxes(){
			return theBoxes;
		}
		
	}
	
}

