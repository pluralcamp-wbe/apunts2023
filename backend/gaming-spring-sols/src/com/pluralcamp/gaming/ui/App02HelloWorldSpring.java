package com.pluralcamp.gaming.ui;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.pluralcamp.gaming.config.Address;
import com.pluralcamp.gaming.config.HelloWorldConfiguration;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		
		System.out.println("");
		
		//1 - Launch a Spring Context -
		
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(
						HelloWorldConfiguration.class); 
		
		
		//2 - CONFIGURE the things we want Spring to manage 
		//HelloWorldConfiguration class - @Configuration class
		//method name() with @Bean annotation
		
		//Retrieving beans managed by Spring IOC container (context)
		Object beanName = context.getBean("name"); //method's name
		System.out.println(beanName);
		
		Object beanAge = context.getBean("age");
		System.out.println(beanAge);
		
		Object beanPerson = context.getBean("person");
		System.out.println(beanPerson);
		
		
		//-------
		
		System.out.println(context.getBean("student"));		
		
		Object beanAddress = context.getBean("adressa");		
		System.out.println(beanAddress);
		
		//Autowiring:
		//Multiple candidates throws an Exception!! -> @Primary / @Qualifier
		System.out.println(context.getBean(Address.class));
		
		
		Object beanBritish = context.getBean("british");		
		System.out.println(beanBritish);
		
		context.close();

	}

}












