package com.cvgstudios.pokemonchrome.maps;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.cvgstudios.pokemonchrome.GameFile;
import com.cvgstudios.pokemonchrome.entities.Player;
import com.cvgstudios.pokemonchrome.images.Images;

@SuppressWarnings("serial")
public class Tester extends JFrame implements KeyListener {
	Player p;

	private Image dbImage;//
	private Graphics dbg;// double buffer

	Image bg = Images.Route1.getImage();

	Image[] playerUp = { Images.PlayerUp.getImage(),
			Images.PlayerUp1.getImage(), Images.PlayerUp2.getImage() };
	Image[] playerDown = { Images.PlayerDown.getImage(),
			Images.PlayerDown1.getImage(), Images.PlayerDown2.getImage() };
	Image[] playerRight = { Images.PlayerRight.getImage(),
			Images.PlayerRight1.getImage(), Images.PlayerRight2.getImage() };

	Image[] playerLeft = { Images.PlayerLeft.getImage(),
			Images.PlayerLeft1.getImage(), Images.PlayerLeft2.getImage() };

	private boolean keyDown;

	public Tester() {
		// TODO Auto-generated constructor stub

		setTitle("Pokemon Chrome");// Sets the Title
		setSize(600, 600);// Size of Window
		setResizable(false);// Cannot resize the window
		setVisible(true);// Makes it visible
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		addKeyListener(this);
		p = new Player(getWidth() / 2, getHeight() / 2, playerLeft,
				playerRight, playerDown, playerUp);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Tester();

	}

	public void paint(Graphics g) {
		dbImage = createImage(getWidth(), getHeight());
		dbg = dbImage.getGraphics();
		paintComponent(dbg);
		g.drawImage(dbImage, 0, 0, this);
		repaint();
	}

	public void paintComponent(Graphics g) {
		g.drawImage(bg, 0 - (int) GameFile.locX, 0 - (int) GameFile.locY,
				getWidth(), getHeight(), this);
		p.render(g);
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		while (!keyDown) {
			if (e.getKeyCode() == KeyEvent.VK_W) {
				setKeyDown(true);
				p.moveUp();
			} else if (e.getKeyCode() == KeyEvent.VK_A) {
				setKeyDown(true);
				p.moveLeft();
			} else if (e.getKeyCode() == KeyEvent.VK_D) {
				setKeyDown(true);
				p.moveRight();
			} else if (e.getKeyCode() == KeyEvent.VK_S) {
				setKeyDown(true);
				p.moveDown();
			}

		}
	}

	public void setKeyDown(Boolean b) {
		keyDown = b;
	}

	public void keyReleased(KeyEvent e) {
		setKeyDown(false);
		p.stopMovement();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}
