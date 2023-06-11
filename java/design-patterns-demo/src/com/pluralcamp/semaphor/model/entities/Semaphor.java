package com.pluralcamp.semaphor.model.entities;

import java.util.Collection;
import java.util.HashSet;

import com.pluralcamp.semaphor.model.contracts.IObserver;
import com.pluralcamp.semaphor.model.contracts.IRgb;
import com.pluralcamp.semaphor.model.contracts.ISemaphor;

//Singleton
//Subject en el patrón Observer
public class Semaphor implements ISemaphor {

	private static Semaphor instance;
	
	private Semaphor() {}
	
	public static synchronized Semaphor getInstance() {
		if(instance == null)
			instance = new Semaphor();
		return instance;
	}
	
	private SemaphorColor semaphorColor;
	
	public SemaphorColor getColor() {
		return this.semaphorColor;
	}

	public void setSemaphorColor(IRgb color) {
		boolean found = false;
		for (Semaphor.SemaphorColor semaphorColor : Semaphor.SemaphorColor.values()) {
			if (semaphorColor.color.equals(color)) {
				this.semaphorColor = semaphorColor;
				found = true;
				this.notifyRegisteredPersons(color);
				break;
			}
		}
		if(!found) {
			throw new IllegalArgumentException();
		}
	}

	Collection<IObserver> personsCollection = new HashSet<IObserver>();
	//Collection<IObserver> personsCollection = new ArrayList<IObserver>();

	@Override
	public void register(IObserver person) {
		this.personsCollection.add(person);
	}

	@Override
	public void unregister(IObserver person) {
		this.personsCollection.remove(person);
	}

	@Override
	public void notifyRegisteredPersons(IRgb color) {
		for (IObserver person : personsCollection) {
			person.update(color);
		}
	}

	public static enum SemaphorColor {

		RED(new Color("Red", IRgb.MAX_VALUE, IRgb.MIN_VALUE, IRgb.MIN_VALUE)),

		GREEN(new Color("Green", IRgb.MIN_VALUE, IRgb.MAX_VALUE, IRgb.MIN_VALUE));

		private IRgb color;

		private SemaphorColor(Color color) {
			this.color = color;
		}

		public IRgb getColor() {
			return this.color;
		}
	}

}
