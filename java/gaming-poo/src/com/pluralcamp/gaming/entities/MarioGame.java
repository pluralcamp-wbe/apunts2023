package com.pluralcamp.gaming.entities;

public class MarioGame implements IGame {
	
	@Override
	public void up() {
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
