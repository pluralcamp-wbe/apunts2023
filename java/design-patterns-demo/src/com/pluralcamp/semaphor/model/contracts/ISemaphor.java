package com.pluralcamp.semaphor.model.contracts;

//Interface parte del patrón Observer
public interface ISemaphor {
	void register(IObserver person);

	void unregister(IObserver person);

	void notifyRegisteredPersons(IRgb color);
	
	void setSemaphorColor(IRgb color);
}
