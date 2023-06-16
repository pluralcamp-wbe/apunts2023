package com.pluralcamp.aspects.annotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = "com.pluralcamp.aspects.annotations")
@EnableAspectJAutoProxy
public class Purchase implements Shopping {

	@Override
	public void buy(boolean error) throws Exception {
		if(error) {
			throw new Exception("Algo fue mal...");
		}
		System.out.println("Procesando la compra...");
	}
}
