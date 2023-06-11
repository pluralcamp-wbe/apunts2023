package com.pluralcamp.semaphor.controllers;

import java.util.List;

import com.pluralcamp.semaphor.model.entities.Color;

//Simple Factory pattern
public class ColorFactory {

	private List<Color> possibleColors;

	private int currentIndex = 0;

	private Color currentColor;
	
	public ColorFactory(List<Color> colorsList) {
		this.possibleColors = colorsList;
	}

	public Color nextColor() {		
		if (this.currentIndex >= this.possibleColors.size()) {
			this.currentIndex = 0;
		}
		this.currentColor = this.possibleColors.get(this.currentIndex);	
		this.currentIndex++;
		
		return this.currentColor;
	}

}
