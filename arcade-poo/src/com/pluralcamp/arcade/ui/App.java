package com.pluralcamp.arcade.ui;

import java.util.Scanner;

import com.pluralcamp.arcade.controllers.GamePlayer;
import com.pluralcamp.arcade.model.IGame;
import com.pluralcamp.arcade.model.MarioGame;
import com.pluralcamp.arcade.model.SuperContraGame;

public class App {

	public static void main(String[] args) {
		
		System.out.println("---> Arcade Games POO Demo <---");
		
		//MarioGame		
		int numberOfLifes = askLifes();
		IGame game = new MarioGame(numberOfLifes);		
		GamePlayer gamePlayer = new GamePlayer(game);
		gamePlayer.play();	
		
		
		//SuperContraGame		
		IGame game2 = new SuperContraGame(numberOfLifes);
		GamePlayer gamePlayer2 = new GamePlayer(game2);
		gamePlayer2.play();
		
		
	}

	
	private static int askLifes() {
		Scanner read = new Scanner(System.in);
		System.out.print("\nHow many lifes do you need? ");
		int lifes = read.nextInt();
		read.close();
		return lifes;		
	}
}
