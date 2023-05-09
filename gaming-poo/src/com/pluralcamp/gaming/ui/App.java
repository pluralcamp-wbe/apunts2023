package com.pluralcamp.gaming.ui;

import com.pluralcamp.gaming.controllers.GameRunner;
import com.pluralcamp.gaming.entities.*;

public class App {

	public static void main(String[] args) {
		
		IGame game = new SuperContraGame();
		
		GameRunner runner1 = new GameRunner(game);
		runner1.run();
		
		
		
		game = new MarioGame();
		
		runner1.setGame(game);
		runner1.run();
		
		

	}

}












