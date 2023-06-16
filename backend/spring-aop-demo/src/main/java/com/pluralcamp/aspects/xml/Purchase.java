package com.pluralcamp.aspects.xml;

public class Purchase extends Shopping {

	@Override
	public void buy(boolean error) throws Exception {
		if(error)
			throw new Exception("Something went wrong");
		System.out.println("Processing the purchase...");
	}

}
