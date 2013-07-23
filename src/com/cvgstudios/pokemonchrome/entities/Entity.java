package com.cvgstudios.pokemonchrome.entities;

import java.awt.Graphics;

public abstract class Entity {
	protected int x;
	protected int y;
	protected int width;
	protected int height;

	public Entity(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void render(Graphics g) {
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
