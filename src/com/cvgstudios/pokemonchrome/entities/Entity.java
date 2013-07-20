package com.cvgstudios.pokemonchrome.entities;

import java.awt.Graphics;

public abstract class Entity {
	protected int money;
	protected int badges;

	protected int x;
	protected int y;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void render(Graphics g) {

	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getBadges() {
		return badges;
	}

	public void setBadges(int money) {
		this.badges = badges;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
