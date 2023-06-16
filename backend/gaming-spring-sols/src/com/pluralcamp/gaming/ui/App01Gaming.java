package com.pluralcamp.gaming.ui;

import com.pluralcamp.gaming.controllers.GameRunner;
import com.pluralcamp.gaming.entities.*;

public class App01Gaming {

	public static void main(String[] args) {
		
		System.out.println("");
		
		//1- Object Creation
		IGame game = new SuperContraGame(); 
		
		//2- Object Creation + Wiring dependencies
		//Game is a dependency of the GameRunner class
		//game is being injected
		GameRunner runner1 = new GameRunner(game); 
		runner1.run();
		
//		System.out.println("");
//		
//		game = new MarioGame();
//		
//		runner1.setGame(game);
//		runner1.run();
//		
//		System.out.println("");
//		
//		game = new PacmanGame();
//		
//		runner1.setGame(game);
//		runner1.run();
	}

}












