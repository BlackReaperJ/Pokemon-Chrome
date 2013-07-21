package com.cvgstudios.pokemonchrome.entities;

import java.awt.Image;

public class Player extends Human {

	public Player(int x, int y, Image[] l, Image[] r, Image[] d, Image[] u) {
		super(x, y, l, r, d, u);
	}

	protected int money;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
