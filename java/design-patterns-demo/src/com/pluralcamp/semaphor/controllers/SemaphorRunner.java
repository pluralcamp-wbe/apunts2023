package com.pluralcamp.semaphor.controllers;

import java.util.ArrayList;
import java.util.List;

import com.pluralcamp.semaphor.model.contracts.IRgb;
import com.pluralcamp.semaphor.model.contracts.ISemaphor;
import com.pluralcamp.semaphor.model.entities.Color;
import com.pluralcamp.semaphor.model.entities.Semaphor;

public class SemaphorRunner implements Runnable {

	private ISemaphor semaphor;
	private ColorFactory colorFactory;

	public SemaphorRunner(ISemaphor semaphor) {
		this.semaphor = semaphor;

		List<Color> semaphorColors = new ArrayList<>();
		for (Semaphor.SemaphorColor semaphorColor : Semaphor.SemaphorColor.values()) {
			semaphorColors.add((Color) semaphorColor.getColor());
		}
		this.colorFactory = new ColorFactory(semaphorColors);
	}

	public void run() {
		IRgb color = colorFactory.nextColor();
		System.out.println("\n--- Semaphor changes to " + color.toString());
		this.semaphor.setSemaphorColor(color);
	}

}
