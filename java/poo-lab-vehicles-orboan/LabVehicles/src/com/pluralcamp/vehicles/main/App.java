package com.pluralcamp.vehicles.main;

import com.pluralcamp.vehicles.entities.*;

public class App {
	
	
	public static void main(String[] args) {
		
		System.out.println("");
		System.out.println("--> Fase 1 <---");
		Car cotxe = new Car();
		cotxe.accelerate();
		
		MotorByke moto = new MotorByke();
		moto.frenar();
		
		Bus autobus = new Bus();
		autobus.loadPassengers();
		
		Train tren = new Train();
		tren.turnLightsOn();
		
		System.out.println("");
		System.out.println("--> Fase 2 <---");
		
		Vehicle[] vehiculos = {cotxe,moto,autobus,tren};
		
		for(Vehicle v : vehiculos) {
			v.accelerate();
		}
		
		
		System.out.println("");
		System.out.println("--> Fase 3 <---");
		
		Polluter[] contaminantes = {cotxe, moto, autobus};
		
		for(Polluter contaminante: contaminantes) {
			//Los contaminantes expulsan CO2
			contaminante.expulsaCO2();
		}
		
	}
	
	
}
