package com.cvgstudios.pokemonchrome.maps;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import com.cvgstudios.pokemonchrome.entities.Player;
import com.cvgstudios.pokemonchrome.images.Images;

public class Tester extends JFrame implements KeyListener {

	Player player;
	Image bg = Images.MoveTester.getImage();

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
		player = new Player(200, 200);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Tester();

	}

	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);

		player.render(g);

		g.dispose();
		repaint();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_W) {
			player.setYD(-1);
		} else if (e.getKeyCode() == KeyEvent.VK_A) {
			player.setXD(-1);
		} else if (e.getKeyCode() == KeyEvent.VK_D) {
			player.setXD(+1);
		} else if (e.getKeyCode() == KeyEvent.VK_S) {
			player.setYD(+1);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		player.setXD(0);
		player.setYD(0);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
