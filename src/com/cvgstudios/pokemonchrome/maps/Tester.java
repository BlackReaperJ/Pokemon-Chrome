package com.cvgstudios.pokemonchrome.maps;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.cvgstudios.pokemonchrome.entities.Player;
import com.cvgstudios.pokemonchrome.images.Images;

public class Tester extends JFrame implements KeyListener {

	Player player;
	Image bg = Images.MoveTester.getImage();

	Image[] playerUp = { Images.PlayerUp.getImage(),
			Images.PlayerUp1.getImage(), Images.PlayerUp2.getImage() };
	Image[] playerDown = { Images.PlayerDown.getImage(),
			Images.PlayerDown1.getImage(), Images.PlayerDown2.getImage() };
	Image[] playerRight = { Images.PlayerRight.getImage(),
			Images.PlayerRight1.getImage(), Images.PlayerRight2.getImage() };

	Image[] playerLeft = { Images.PlayerLeft.getImage(),
			Images.PlayerLeft1.getImage(), Images.PlayerLeft2.getImage() };

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
		player = new Player(200, 200, playerLeft, playerRight, playerDown,
				playerUp);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Tester();

	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);

		player.render(g);
		g.dispose();
		repaint();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			player.setMoving();
			player.setYD(-1);
			player.setDirection(1);
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			player.setMoving();
			player.setXD(-1);
			player.setDirection(4);
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			player.setMoving();
			player.setXD(+1);
			player.setDirection(2);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			player.setMoving();
			player.setYD(+1);
			player.setDirection(3);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		player.setXD(0);
		player.setYD(0);
		player.resetSteps();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
