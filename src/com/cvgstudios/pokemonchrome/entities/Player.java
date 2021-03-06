package com.cvgstudios.pokemonchrome.entities;

import java.awt.Image;

public class Player extends Human {

	public Player(int x, int y, Image[] l, Image[] r, Image[] d, Image[] u) {
		super(x, y, l, r, d, u);

		screenLocked = true;
	}

	protected int money;
	protected int badges;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getBadges() {
		return badges;
	}

	public void setBadges(int badges) {
		this.badges = badges;
	}

}
