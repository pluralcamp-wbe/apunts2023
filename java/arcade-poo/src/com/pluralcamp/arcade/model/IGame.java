package com.pluralcamp.arcade.model;

public interface IGame {
	int getLifes();
	void up();
	void down();
	void left();
	public abstract void right();
}
