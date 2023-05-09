package com.pluralcamp.demopoo.main;

import com.pluralcamp.demopoo.entities.Chair;
import com.pluralcamp.demopoo.entities.Closet;
import com.pluralcamp.demopoo.entities.Color;
import com.pluralcamp.demopoo.entities.Furniture;
import com.pluralcamp.demopoo.entities.Table;

public class App {

	public static void main(String[] args) {
		
		//Table
		Furniture taula = new Table("fusta", 
				72.0, 120.0, 80.0, new Color(), true);
		double volumTaula = taula.volume();
		System.out.println("La taula té un volum de " + volumTaula);
		((Table)taula).extend();
		System.out.println(taula.toString());
		
		//Chair
		Chair silla = new Chair("pvc", 160.0, 60.0, 55.0,
				new Color(), true);
		System.out.println("La silla tiene un volumen de "
				+ silla.volume());
		silla.move();
		System.out.println(silla.toString());
		
		//Closet
		Color green = new Color("Green", 0, 255, 0);
		Closet armari = new Closet("madera", 
				130.0, 200.0, 70.0, green, 4);
		System.out.println("Armari de volum igual a "
				+ armari.volume());
		armari.open();		
		System.out.println(armari);
		
		//Es pot fer una instància de la superclasse
		//si i només si no es abstracta
		//Furniture
		Furniture moble = new Furniture(
				"madera", 50.0, 45.0, 30.0, new Color());
		System.out.println(moble.toString());
		
		
		System.out.println("");
		System.out.println("---- Ejemplo de Polimorfismo usando un array ----");
		System.out.println("");
		
		//Meter todos los muebles en un array 
		//de muebles
		Furniture[] muebles = {taula, silla, armari, moble};
		
		for(Furniture mueble : muebles) {
			System.out.println("");
			System.out.println(mueble.getClass().getSimpleName());
			System.out.println(mueble.toString());
		}
		System.out.println("");
		System.out.println("------- Otro ejemplo de polimorfismo ---------");
		System.out.println("");
		
		Furniture mueble = taula;
		System.out.println(mueble.getClass().getName());
		
		mueble = silla;
		System.out.println(mueble.getClass().getName());
		
		mueble = armari;
		System.out.println(mueble.getClass().getName());
		
		mueble = moble;
		System.out.println(mueble.getClass().getName());
		
		
		
	}

}
