package com.pluralcamp.aspects.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx =
				new ClassPathXmlApplicationContext(
						"spring-config.xml");
		
		Shopping purchase = (Purchase)ctx.getBean("purchase");
		System.out.println(purchase);
		try {
			purchase.buy(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Purchase error. Try again later...");
		}
		ctx.close();
	}
}
