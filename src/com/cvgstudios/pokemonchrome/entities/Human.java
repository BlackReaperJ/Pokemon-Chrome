package com.cvgstudios.pokemonchrome.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

/*
 * create a new class called human extends entity and put most of this stuff in there
 */

public class Human extends Entity implements ActionListener {
	protected int money;
	boolean screenLocked;
	private double xd;
	private double yd;

	Timer t;
	TimerTask task;

	int direction = 3;
	int step;

	Image[] left;
	Image[] right;
	Image[] down;
	Image[] up;

	public boolean moving;
	private boolean timerStarted;

	public Human(int x, int y, Image[] l, Image[] r, Image[] d, Image[] u) {
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
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 50, 50);
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
	}

	public void setXD(double d) {
		xd = d;
	}

	public void setYD(int val) {
		yd = val;
	}

	// 1=up,2=right,3=down,4=left
	public void setDirection(int d) {
		direction = d;
		if (moving) {
			if (!timerStarted) {
				t = new Timer();
				task = new TimerTask() {
					public void run() {
						if (step == 1) {
							step = 2;
						} else
							step = 1;
					}
				};
				t.scheduleAtFixedRate(task, 0, 125);
				task.run();
			}
			timerStarted = true;
		}
	}

	public void stopMovement() {
		if (moving) {
			setXD(0);
			setYD(0);
			step = 0;
			moving = false;
			t.cancel();
			t.purge();
			timerStarted = false;
		}
	}

	public void setMoving() {
		moving = true;
		step = 1;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void moveUp() {
		this.setMoving();
		this.setYD(-1);
		this.setDirection(1);
	}

	public void moveRight() {
		this.setMoving();
		this.setXD(+1);
		this.setDirection(2);
	}

	public void moveDown() {
		this.setMoving();
		this.setYD(+1);
		this.setDirection(3);
	}

	public void moveLeft() {
		this.setMoving();
		this.setXD(-0.5);
		this.setDirection(4);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	}

}
