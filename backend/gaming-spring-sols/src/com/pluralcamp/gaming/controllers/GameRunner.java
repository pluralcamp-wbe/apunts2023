package com.pluralcamp.gaming.controllers;

import com.pluralcamp.gaming.entities.IGame;

public class GameRunner {

	private IGame game;


	public GameRunner(IGame game) {
		this.game = game;
	}
	
	public void setGame(IGame game) {
		this.game = game;
	}
	
	public void run() {
		System.out.println("Running game is " + 
					this.game.getClass().getSimpleName());
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
