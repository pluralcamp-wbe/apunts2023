package com.pluralcamp.arcade.model;

public class MarioGame implements IGame {

	private int lifes = 3;
	
	public MarioGame() {}
	
	public MarioGame(int lifes) {
		this.setLifes(lifes);
	}
	
	
	@Override
	public int getLifes() {
		return this.lifes;
	}
		
	public void setLifes(int lifes) {
		this.lifes = lifes;
	}
	
	//Behavior
	@Override
	public void up(){
		System.out.println("Jump");
	}
	
	@Override
	public void down() {
		System.out.println("Go into a hole");
	}
	
	@Override
	public void left() {
		System.out.println("Go back");
	}
	
	@Override
	public void right() {
		System.out.println("Accelerate");
	}	
}
