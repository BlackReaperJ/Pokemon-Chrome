package pokeMain;

import javax.swing.JFrame; 
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.*;
import java.awt.Font;
import java.net.URL;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.*;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Route1 extends JFrame implements ActionListener{
	ClassLoader cl = Route1.class.getClassLoader();
	URL imageURL = cl.getResource("Pictures/Maps/Route1.png"), imageURL2 = cl.getResource("Pictures/Sprites/Player/Down.png"), imageURL3 = cl.getResource("Pictures/Sprites/Player/Down1.png"),
			imageURL4 = cl.getResource("Pictures/Sprites/Player/Down2.png"),imageURL5 = cl.getResource("Pictures/Sprites/Player/Left.png"),imageURL6 = cl.getResource("Pictures/Sprites/Player/Left1.png"),
			imageURL7 = cl.getResource("Pictures/Sprites/Player/Left2.png"), imageURL8 = cl.getResource("Pictures/Sprites/Player/Right.png"), imageURL9 = cl.getResource("Pictures/Sprites/Player/Right1.png"), 
			imageURL10 = cl.getResource("Pictures/Sprites/Player/Right2.png"), imageURL11 = cl.getResource("Pictures/Sprites/Player/Up.png"), imageURL12 = cl.getResource("Pictures/Sprites/Player/Up1.png"),
			imageURL13 = cl.getResource("Pictures/Sprites/Player/Up2.png"),imageURL14 = cl.getResource("Pictures/Maps/Exitium.png"), imageURL15 = cl.getResource("Pictures/Sprites/Structures/ColumnTrees.png"),
			imageURL16 = cl.getResource("Pictures/Sprites/Misc/Pokeball3.png"),imageURL17 = cl.getResource("Pictures/Sprites/NPC/Trainer1/Trainer1Right.png"),imageURL18 = cl.getResource("Pictures/Sprites/NPC/Trainer1/Trainer1Right1.png"),
			imageURL19 = cl.getResource("Pictures/Sprites/NPC/Trainer1/Trainer1Right2.png"),imageURL20 = cl.getResource("Pictures/Sprites/NPC/Trainer1/Trainer1Left.png"),imageURL21 = cl.getResource("Pictures/Sprites/NPC/Trainer1/Trainer1Left1.png"),
			imageURL22 = cl.getResource("Pictures/Sprites/NPC/Trainer1/Trainer1Left2.png"),imageURL23 = cl.getResource("Pictures/Sprites/NPC/Trainer2/Trainer2Right.png"),imageURL24 = cl.getResource("Pictures/Sprites/NPC/Trainer2/Trainer2Right1.png"),
			imageURL25 = cl.getResource("Pictures/Sprites/NPC/Trainer2/Trainer2Right2.png"),imageURL26 = cl.getResource("Pictures/Sprites/NPC/Trainer2/Trainer2Left.png"),imageURL27 = cl.getResource("Pictures/Sprites/NPC/Trainer2/Trainer2Left1.png"),
			imageURL28 = cl.getResource("Pictures/Sprites/NPC/Trainer2/Trainer2Left2.png"),imageURL29 = cl.getResource("Pictures/Sprites/Structures/PileBlock.png"), imageURL30 = cl.getResource("Pictures/Sprites/NPC/Gate/Gate2Left.png"),
			imageURL31 = cl.getResource("Pictures/Sprites/NPC/Gate/Gate2Down.png"),imageURL32 = cl.getResource("Pictures/Maps/MapleLodge.png");

	final long KEYDELAY = 1000000;
	long lSystime;
	long lTimeL;
	long lTimeU;
	long lTimeR;
	long lTimeD;
	int velX =4, velY =4, z =0;
	private Image dbImage;//
	private Graphics dbg;//double buffer
	int downStep = -1, upStep = 0, leftStep = -1, rightStep = -1;
	int [] party;
	Image route1, down, down1, down2, left, left1, left2, right, right1, right2, up, up1, up2, exitium, mapleLodge;
	Image columnTrees, pokeball3,train1Right,train1Right1,train1Right2,train1Left,train1Left1,train1Left2;
	Image train2Right,train2Right1,train2Right2,train2Left,train2Left1,train2Left2, pileBlock, gate2Left, gate2Down;

	File f = new File("PokemonFont.ttf");
	FileInputStream in = new FileInputStream(f);
	Font dFont = Font.createFont(Font.TRUETYPE_FONT, in);
	Font f1 = dFont.deriveFont(40f), f2 = dFont.deriveFont(50f);

	public static void main(String[ ] args) throws Exception{
		Route1 mainMenu = new Route1();
	}  
	public Route1()throws Exception{
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		route1 = toolkit.createImage(imageURL);
		down= toolkit.createImage(imageURL2);
		down1 = toolkit.createImage(imageURL3);
		down2 = toolkit.createImage(imageURL4);
		left = toolkit.createImage(imageURL5);
		left1 = toolkit.createImage(imageURL6);
		left2 = toolkit.createImage(imageURL7);
		right = toolkit.createImage(imageURL8);
		right1 = toolkit.createImage(imageURL9);
		right2  = toolkit.createImage(imageURL10);
		up = toolkit.createImage(imageURL11);
		up1 = toolkit.createImage(imageURL12);
		up2 = toolkit.createImage(imageURL13);
		exitium = toolkit.createImage(imageURL14);
		columnTrees = toolkit.createImage(imageURL15);
		pokeball3 = toolkit.createImage(imageURL16);
		train1Right = toolkit.createImage(imageURL17);
		train1Right1 = toolkit.createImage(imageURL18);
		train1Right2 = toolkit.createImage(imageURL19); 
		train1Left = toolkit.createImage(imageURL20);
		train1Left1 = toolkit.createImage(imageURL21);
		train1Left2 = toolkit.createImage(imageURL22);
		train2Right = toolkit.createImage(imageURL23);
		train2Right1 = toolkit.createImage(imageURL24);
		train2Right2 = toolkit.createImage(imageURL25);
		train2Left = toolkit.createImage(imageURL26);
		train2Left1 = toolkit.createImage(imageURL27);
		train2Left2 = toolkit.createImage(imageURL28);
		pileBlock = toolkit.createImage(imageURL29);
		gate2Left = toolkit.createImage(imageURL30);
		gate2Down = toolkit.createImage(imageURL31);
		mapleLodge = toolkit.createImage(imageURL32);

		addKeyListener(new AL());
		setTitle("Pokemon Chrome");//Sets the Title
		setSize(600, 600);//Size of Window
		setResizable(false);//Cannot resize the window
		setVisible(true);//Makes it visible
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//new musicPlayPoke("Music/NimbasaCity.wav").start();
		GameFile.iLocX = GameFile.iLocX +4;
	} 
	public void actionPerformed(ActionEvent e){
	}
	public class AL extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			int keyCode = e.getKeyCode();//Get key preseed
			if (keyCode ==e.VK_Z) { 
				z = z +1;
			}
			if (keyCode ==e.VK_S) {
			}
			long nanoTime = System.nanoTime();
			if (keyCode ==e.VK_LEFT && nanoTime - lTimeU > KEYDELAY && nanoTime - lTimeD > KEYDELAY) {//moves object left
				if (GameFile.iLocX >= 28 && GameFile.iLocY <= 24 || GameFile.iLocX >= -44 && GameFile.iLocX <= -36 && GameFile.iLocY >=168 && GameFile.iLocY <= 192 || GameFile.iLocX >= 428 && GameFile.iLocY >=32 && GameFile.iLocY <= 1168 || GameFile.iLocX >= 172 && GameFile.iLocX <= 180 && GameFile.iLocY >=1176 && GameFile.iLocY <= 1320 || GameFile.iLocX >= 172 && GameFile.iLocX <= 180 && GameFile.iLocY >=936 && GameFile.iLocY <= 1024) {
					upStep = -1;
					downStep = -1;
					rightStep = -1;
					leftStep = leftStep +1;
				}
				else{
					GameFile.iLocX = GameFile.iLocX + 8;
					upStep = -1;
					downStep = -1;
					rightStep = -1;
					leftStep = leftStep +1;
					lTimeL = nanoTime;   
				}
			}
			else if (keyCode ==e.VK_RIGHT && nanoTime - lTimeU > KEYDELAY && nanoTime - lTimeD  > KEYDELAY) {//moves object right
				if (GameFile.iLocX <= -52 && GameFile.iLocY <= 24 || GameFile.iLocX <= -220 && GameFile.iLocX >= -228 && GameFile.iLocY <= 192 && GameFile.iLocY >= 32 || GameFile.iLocX >= 28 && GameFile.iLocX <= 36 && GameFile.iLocY >=168 && GameFile.iLocY <= 192 || GameFile.iLocX >= 116 && GameFile.iLocX <= 124 && GameFile.iLocY >=192 && GameFile.iLocY <= 368 || GameFile.iLocX >= -44 && GameFile.iLocX <= -36 && GameFile.iLocY >=376 && GameFile.iLocY <= 464 || GameFile.iLocX >= 220 && GameFile.iLocX <= 228 && GameFile.iLocY >=480 && GameFile.iLocY <= 736 || GameFile.iLocX >= 212 && GameFile.iLocX <= 220 && GameFile.iLocY >=744 && GameFile.iLocY <= 800  || GameFile.iLocX >= 212 && GameFile.iLocX <= 220 && GameFile.iLocY >=880 && GameFile.iLocY <= 1024 || GameFile.iLocX >= -36 && GameFile.iLocX <= -28 && GameFile.iLocY >=1224 && GameFile.iLocY <= 1376 || GameFile.iLocX >= -44 && GameFile.iLocX <= -36 && GameFile.iLocY >=1032 && GameFile.iLocY <= 1216 || GameFile.iLocX >= 52 && GameFile.iLocX <= 60 && GameFile.iLocY >=936 && GameFile.iLocY <= 1024) {
					leftStep = -1;
					rightStep = rightStep +1;
					downStep =-1;
					upStep =-1;
				}
				else{
					GameFile.iLocX = GameFile.iLocX - 8;
					upStep = -1;
					leftStep = -1;
					downStep = -1;
					rightStep = rightStep +1;
					lTimeR = nanoTime;
				}
			}
			else if (keyCode ==e.VK_UP && nanoTime - lTimeL > KEYDELAY && nanoTime - lTimeR > KEYDELAY) {//moves object up
				if (GameFile.iLocX >= -220 && GameFile.iLocX <= -44 && GameFile.iLocY >= 192 && GameFile.iLocY <= 192 || GameFile.iLocX >= -36 && GameFile.iLocX <= 28 && GameFile.iLocY >= 160 && GameFile.iLocY <= 168 || GameFile.iLocX >= 36 && GameFile.iLocX <= 116 && GameFile.iLocY >= 192 && GameFile.iLocY <= 200 || GameFile.iLocX >= -36 && GameFile.iLocX <= 220 && GameFile.iLocY >= 464 && GameFile.iLocY <= 472 || GameFile.iLocX >= 180 && GameFile.iLocX <= 428 && GameFile.iLocY >= 1168 && GameFile.iLocY <= 1174 || GameFile.iLocX >= -28 && GameFile.iLocX <= 564 && GameFile.iLocY >=1376 && GameFile.iLocY <= 1384 || GameFile.iLocX >= -44 && GameFile.iLocX <= -36 && GameFile.iLocY >=1216 && GameFile.iLocY <= 1224) {
					leftStep = -1;
					downStep = -1;
					rightStep = -1;
					upStep = upStep +1;
				}
				else{
					GameFile.iLocY = GameFile.iLocY  + 8;
					leftStep = -1;
					downStep = -1;
					rightStep = -1;
					upStep = upStep +1;
					lTimeU = nanoTime;
				}
			}
			else if (keyCode ==e.VK_DOWN && nanoTime - lTimeL > KEYDELAY && nanoTime - lTimeR > KEYDELAY) {//moves object down
				if (GameFile.iLocX <= -60 && GameFile.iLocY <= 32 || GameFile.iLocX >= 16 && GameFile.iLocY <= 32 || GameFile.iLocX >= -36 && GameFile.iLocX <= 116 && GameFile.iLocY >=368 && GameFile.iLocY <= 376 || GameFile.iLocX >= 212 && GameFile.iLocX <= 220 && GameFile.iLocY >=736 && GameFile.iLocY <= 744 || GameFile.iLocX >= 180 && GameFile.iLocX <= 556 && GameFile.iLocY >=1320 && GameFile.iLocY <= 1328 || GameFile.iLocX >= -36 && GameFile.iLocX <= 52 && GameFile.iLocY >=1024 && GameFile.iLocY <= 1032 || GameFile.iLocX >= 180 && GameFile.iLocX <= 212 && GameFile.iLocY >=1024 && GameFile.iLocY <= 1032 || GameFile.iLocX >= 60 && GameFile.iLocX <= 172 && GameFile.iLocY >=928 && GameFile.iLocY <= 936) {
					upStep = -1;
					leftStep = -1;
					rightStep = -1;
					downStep = downStep +1;
				}
				else{
					GameFile.iLocY= GameFile.iLocY -8;
					upStep = -1;
					leftStep = -1;
					rightStep = -1;
					downStep = downStep +1;
					lTimeD = nanoTime;
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

	public void paintComponent(Graphics g) {
		g.setFont(f1);
		leftStep = leftStep % 18;
		upStep = upStep % 18;
		rightStep = rightStep % 18;
		downStep = downStep % 18;
		//Map Change ==3
				g.drawImage(route1, GameFile.iLocX -229, GameFile.iLocY- 1099  , this); 
				g.drawImage(exitium, GameFile.iLocX - 229, GameFile.iLocY + 341, this); 
				g.drawImage(columnTrees,GameFile.iLocX- 681, GameFile.iLocY - 880,this);
				g.drawImage(columnTrees,GameFile.iLocX- 1134, GameFile.iLocY - 880,this);
				g.drawImage(columnTrees,GameFile.iLocX- 1587, GameFile.iLocY - 880,this);
				g.drawImage(columnTrees,GameFile.iLocX- 681, GameFile.iLocY - 355,this);
				g.drawImage(columnTrees,GameFile.iLocX + 892, GameFile.iLocY - 880,this);
				g.drawImage(columnTrees,GameFile.iLocX + 892, GameFile.iLocY - 355,this);
				g.drawImage(columnTrees,GameFile.iLocX - 229, GameFile.iLocY - 2057,this);
				g.drawImage(columnTrees,GameFile.iLocX + 224, GameFile.iLocY - 2057,this);
				g.drawImage(columnTrees,GameFile.iLocX + 677, GameFile.iLocY - 2057,this);
				g.drawImage(pokeball3, GameFile.iLocX + 620, GameFile.iLocY + 190, this); 
				g.drawImage(pokeball3, GameFile.iLocX + 328, GameFile.iLocY -98, this); 
				g.drawImage(pokeball3, GameFile.iLocX + 238, GameFile.iLocY -624, this);
				g.drawImage(pokeball3, GameFile.iLocX + 750, GameFile.iLocY -828, this);
				g.drawImage(train1Right, GameFile.iLocX -128, GameFile.iLocY -140, this);
				g.drawImage(train2Left, GameFile.iLocX + 87, GameFile.iLocY -650, this);
				g.drawImage(pileBlock, GameFile.iLocX + 130, GameFile.iLocY -543, this);
				g.drawImage(gate2Left, GameFile.iLocX + 114, GameFile.iLocY -510, this);
				g.drawImage(mapleLodge, GameFile.iLocX-1319, GameFile.iLocY- 1840, this);

				if (downStep >= 12 ) {
					g.drawImage(down2, 300, 300, this);
				}
				else if (downStep >= 6) {
					g.drawImage(down1, 300, 300, this);
				}
				else if (downStep >= 0) {
					g.drawImage(down, 300, 300, this);
				}

				if (upStep >= 12 ) {
					g.drawImage(up2, 300, 300, this);
				}
				else if (upStep >= 6) {
					g.drawImage(up1, 300, 300, this);
				}
				else if (upStep >= 0) {
					g.drawImage(up, 300, 300, this);
				}

				if (rightStep >= 12 ) {
					g.drawImage(right2, 300, 300, this);
				}
				else if (rightStep >= 6) {
					g.drawImage(right1, 300, 300, this);
				}
				else if (rightStep >= 0) {
					g.drawImage(right, 300, 300, this);
				}

				if (leftStep >= 12 ) {
					g.drawImage(left2, 300, 300, this);
				}
				else if (leftStep >= 6) {
					g.drawImage(left1, 300, 300, this);
				}
				else if (leftStep >= 0) {
					g.drawImage(left, 300, 300, this);
				}
				if(z %2 ==1){
					g.drawString(GameFile.iLocX + "  " +  GameFile.iLocY + "  " + GameFile.iLocation + "  ", 250 ,300);
				}
				//       Graphics2D g2 = (Graphics2D)g;
				//       for(int GameFile.iLocX=0;GameFile.iLocX<=600;GameFile.iLocX+=25){
					//       g2.drawLine(GameFile.iLocX,0,GameFile.iLocX,600);
				//       g2.drawString(""+GameFile.iLocX,GameFile.iLocX,20);
				//      }
				//      for(int GameFile.iLocY=0;GameFile.iLocY<=600;GameFile.iLocY+=25){
				//        g2.drawLine(0,GameFile.iLocY,600,GameFile.iLocY);
				//        g2.drawString(""+GameFile.iLocY,0,GameFile.iLocY+20);
				//     }
				repaint();
	}

}