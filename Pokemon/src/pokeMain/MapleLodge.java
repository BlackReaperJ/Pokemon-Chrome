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

public class MapleLodge extends JFrame implements ActionListener{
  ClassLoader cl = MapleLodge.class.getClassLoader();
  URL imageURL = cl.getResource("Pictures/Maps/MapleLodge.png"), imageURL2 = cl.getResource("Pictures/Sprites/Player/Down.png"), imageURL3 = cl.getResource("Pictures/Sprites/Player/Down1.png"),
    imageURL4 = cl.getResource("Pictures/Sprites/Player/Down2.png"),imageURL5 = cl.getResource("Pictures/Sprites/Player/Left.png"),imageURL6 = cl.getResource("Pictures/Sprites/Player/Left1.png"),
    imageURL7 = cl.getResource("Pictures/Sprites/Player/Left2.png"), imageURL8 = cl.getResource("Pictures/Sprites/Player/Right.png"), imageURL9 = cl.getResource("Pictures/Sprites/Player/Right1.png"), 
    imageURL10 = cl.getResource("Pictures/Sprites/Player/Right2.png"), imageURL11 = cl.getResource("Pictures/Sprites/Player/Up.png"), imageURL12 = cl.getResource("Pictures/Sprites/Player/Up1.png"),
    imageURL13 = cl.getResource("Pictures/Sprites/Player/Up2.png"), imageURL14 = cl.getResource("Pictures/Sprites/Structures/ColumnTrees.png"),imageURL15 = cl.getResource("Pictures/Maps/Route1.png"),
    imageURL16 = cl.getResource("Pictures/Sprites/Structures/Fountain1.png"), imageURL17 = cl.getResource("Pictures/Sprites/Structures/Fountain2.png"),imageURL18 = cl.getResource("Pictures/Sprites/Structures/FountainBase.png"),
    imageURL19 = cl.getResource("Pictures/Maps/Route2.png");
  
  final long KEYDELAY = 1000000;
  long lSystime;
  long lTimeL;
  long lTimeU;
  long lTimeR;
  long lTimeD;
  int velX =4, velY =4,velFountain = 1, fountainChange =0;;
  int mapChange = 4;
  private Image dbImage;//
  private Graphics dbg;//double buffer
  int downStep = -1, upStep = -1, leftStep = 0, rightStep = -1;
  Timer tmrFountain= new Timer(120, this);
  int [] party;
  Image route1, down, down1, down2, left, left1, left2, right, right1, right2, up, up1, up2,mapleLodge, columnTrees;
  Image fountain1,fountain2, fountainBase, route2;
  
  File f = new File("PokemonFont.ttf");
  FileInputStream in = new FileInputStream(f);
  Font dFont = Font.createFont(Font.TRUETYPE_FONT, in);
  Font f1 = dFont.deriveFont(40f), f2 = dFont.deriveFont(50f);
  
  public static void main(String[ ] args) throws Exception{
    MapleLodge mainMenu = new MapleLodge();
  }  
  public MapleLodge()throws Exception{
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    mapleLodge = toolkit.createImage(imageURL);
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
    columnTrees = toolkit.createImage(imageURL14);
    route1 = toolkit.createImage(imageURL15);
    fountain1 = toolkit.createImage(imageURL16);
    fountain2 = toolkit.createImage(imageURL17);
    fountainBase = toolkit.createImage(imageURL18);
    route2 = toolkit.createImage(imageURL19);
    
    addKeyListener(new AL());
    setTitle("Pokemon Chrome");//Sets the Title
    setSize(600, 600);//Size of Window
    setResizable(false);//Cannot resize the window
    setVisible(true);//Makes it visible
    setBackground(Color.BLACK);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //new musicPlayPoke("Music/NimbasaCity.wav").start();
  } 
  public void actionPerformed(ActionEvent e){
     if(mapChange ==4){
         fountainChange = fountainChange + velFountain;
       }
     repaint();
  }
  public class AL extends KeyAdapter {
    public void keyPressed(KeyEvent e){
      int keyCode = e.getKeyCode();//Get key preseed
      if (keyCode ==e.VK_S) {
      }
      long nanoTime = System.nanoTime();
      if (keyCode ==e.VK_LEFT && nanoTime - lTimeU > KEYDELAY && nanoTime - lTimeD > KEYDELAY) {//moves object left
        GameFile.iLocX = GameFile.iLocX + 8;
        upStep = -1;
        downStep = -1;
        rightStep = -1;
        leftStep = leftStep +1;
        lTimeL = nanoTime;
      }
      else if (keyCode ==e.VK_RIGHT && nanoTime - lTimeU > KEYDELAY && nanoTime - lTimeD  > KEYDELAY) {//moves object right
        GameFile.iLocX = GameFile.iLocX - 8;
        upStep = -1;
        leftStep = -1;
        downStep = -1;
        rightStep = rightStep +1;
        lTimeR = nanoTime;
      }
      else if (keyCode ==e.VK_UP && nanoTime - lTimeL > KEYDELAY && nanoTime - lTimeR > KEYDELAY) {//moves object up
        GameFile.iLocY = GameFile.iLocY  + 8;
        leftStep = -1;
        downStep = -1;
        rightStep = -1;
        upStep = upStep +1;
        lTimeU = nanoTime;
      }
      else if (keyCode ==e.VK_DOWN && nanoTime - lTimeL > KEYDELAY && nanoTime - lTimeR > KEYDELAY) {//moves object down
        GameFile.iLocY= GameFile.iLocY -8;
        upStep = -1;
        leftStep = -1;
        rightStep = -1;
        downStep = downStep +1;
        lTimeD = nanoTime;
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
    if (mapChange ==4){
      g.drawImage(columnTrees, GameFile.iLocX-112, GameFile.iLocY +461, this);
      g.drawImage(columnTrees, GameFile.iLocX-565, GameFile.iLocY +461, this);
      g.drawImage(columnTrees, GameFile.iLocX-1018, GameFile.iLocY +461, this);
      g.drawImage(mapleLodge, GameFile.iLocX - 750, GameFile.iLocY -497 , this);  
      g.drawImage(route1, GameFile.iLocX+341, GameFile.iLocY + 244, this);
      g.drawImage(columnTrees, GameFile.iLocX+341, GameFile.iLocY - 714, this);
      g.drawImage(columnTrees, GameFile.iLocX-1203, GameFile.iLocY - 497, this);
      g.drawImage(fountainBase, GameFile.iLocX-241, GameFile.iLocY + 18, this);
      g.drawImage(route2, GameFile.iLocX-750, GameFile.iLocY-1497,this);
    }
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
    
    if(mapChange ==4) {
      tmrFountain.start();
      if(fountainChange %2==0){
        g.drawImage(fountain1, GameFile.iLocX-230, GameFile.iLocY-30, this);
      }
      else if(fountainChange %2==1){
        g.drawImage(fountain2,GameFile.iLocX- 229, GameFile.iLocY-30, this);
      }
    }
    g.drawString(GameFile.iLocX + "  " +  GameFile.iLocY + "  " + mapChange + "  ", 250 ,300);
    
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