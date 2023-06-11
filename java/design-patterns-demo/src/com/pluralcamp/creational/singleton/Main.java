package com.pluralcamp.creational.singleton;

public class Main {

	public static void main(String[] args) {
		
		
		Captain captain = Captain.getInstance();
		
		
		Captain captain2 = Captain.getInstance();
		
		
		
		System.out.println(captain);
			
		System.out.println(captain2);
		
		//Captain captain2 = new Captain("Kirk", "Enterprise");
		//System.out.println(captain2);

	}

}
