package com.pluralcamp.arcade.controllers;

import com.pluralcamp.arcade.model.IGame;


public class GamePlayer {

	private IGame game;
	
	//Constructor
	public GamePlayer(IGame game) {
		this.game = game;
	}
	
	//Setter
	public void setMarioGame(IGame game) {
		this.game = game;
	}
	
	//Behavior
	public void play() {
		System.out.printf("%nJugando a %s con %d vidas:%n", 
				this.game.getClass().getSimpleName(),
				this.game.getLifes());
		this.game.up();
		this.game.down();
		this.game.left();
		this.game.right();
	}
	
	
}
