package com.cvgstudios.pokemonchrome.entities;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends Entity {

	private int xd, yd;

	public Player(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	public void render(Graphics g) {
		move();
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 25, 25);
	}

	private void move() {
		x += xd;
		y += yd;
	}

	public void setXD(int val) {
		xd = val;
	}

	public void setYD(int val) {
		yd = val;
	}

}
