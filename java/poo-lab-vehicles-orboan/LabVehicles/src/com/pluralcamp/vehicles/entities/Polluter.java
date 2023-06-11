package com.pluralcamp.vehicles.entities;

public interface Polluter {
	void expulsaCO2();
	default void carburant() {
		System.out.println("Mi carburante es gasolina");
	}
}
