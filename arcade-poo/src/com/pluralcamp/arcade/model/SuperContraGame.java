package com.pluralcamp.arcade.model;

public class SuperContraGame implements IGame {
	
	private int lifes = 5;
	
	public SuperContraGame() {}
	
	public SuperContraGame(int lifes) {
		this.lifes = lifes;
	}
	
	@Override
	public int getLifes() {
		return this.lifes;
	}
	
	//Behavior
	@Override
	public void up(){
		System.out.println("Up");
	}
	
	@Override
	public void down() {
		System.out.println("Sit down");
	}
	
	@Override
	public void left() {
		System.out.println("Go back");
	}
	
	@Override
	public void right() {
		System.out.println("Shoot a bullet");
	}		
	
}
