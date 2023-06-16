package com.pluralcamp.aspects.annotations;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ItemsValidator {

	//antes
	@Before("execution(* com.pluralcamp.aspects.annotations.Purchase.buy(..))")
	public void checkAmount() {
		System.out.println("Comprobando que "
				+ "la cantidad de items sea correcta...");
	}
	
	//después
	@AfterReturning("execution(* com.pluralcamp.aspects.annotations.Purchase.buy(..))")
	public void pack() {
		System.out.println("Empaquetando los productos...");
	}
	
	//después de lanzar una excepción
	@AfterThrowing("execution(* com.pluralcamp.aspects.annotations.Purchase.buy(..))")
	public void fileComplain() {
		System.out.println("Queja por productos "
				+ "defectuosos");
	}
}
