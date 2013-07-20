package com.cvgstudios.pokemonchrome.entities;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Player extends Entity implements ActionListener {

	private int xd, yd;
	Timer t;
	int direction = 3;
	int step;

	Image[] left;
	Image[] right;
	Image[] down;
	Image[] up;

	public boolean moving;
	private boolean timerStarted;

	public Player(int x, int y, Image[] l, Image[] r, Image[] d, Image[] u) {
		super(x, y);
		this.left = l;
		this.right = r;
		this.down = d;
		this.up = u;

		this.step = 0;
	}

	@Override
	public void render(Graphics g) {
		move();
		// g.setColor(Color.ORANGE);
		// g.fillRect(x, y, 25, 25);
		if (direction == 1)
			g.drawImage(up[step], x, y, 50, 50, null);
		if (direction == 2)
			g.drawImage(right[step], x, y, 50, 50, null);
		if (direction == 3)
			g.drawImage(down[step], x, y, 50, 50, null);
		if (direction == 4)
			g.drawImage(left[step], x, y, 50, 50, null);

	}

	private void move() {
		x += xd;
		y += yd;
	}// <-- every 10 seconds.

	public void setXD(int val) {
		xd = val;
	}

	public void setYD(int val) {
		yd = val;
	}

	// 1=up,2=right,3=down,4=left
	public void setDirection(int d) {
		direction = d;
		if (moving) {
			if (!timerStarted) {
				t = new Timer(250, this);
				t.start();
			} else
				t.restart();

			timerStarted = true;
			t.setRepeats(true);
		}
	}

	public void resetSteps() {
		step = 0;
		moving = false;
		t.stop();
	}

	public void setMoving() {
		moving = true;
		step = 1;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (step == 1) {
			step = 2;
		} else
			step = 1;
	}

}
