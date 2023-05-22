package com.pluralcamp.semaphor.ui.console;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.pluralcamp.semaphor.controllers.SemaphorRunner;
import com.pluralcamp.semaphor.model.contracts.IObserver;
import com.pluralcamp.semaphor.model.contracts.ISemaphor;
import com.pluralcamp.semaphor.model.entities.Person;
import com.pluralcamp.semaphor.model.entities.Semaphor;

public class Main {
	
	//interval for semaphor in miliseconds
	private static final int INTERVAL = 3000;

	public static void main(String[] args) {

		ISemaphor semaphor = Semaphor.getInstance();
		SemaphorRunner semaphorRunner = new SemaphorRunner(semaphor);

		IObserver laura = new Person("Laura");
		IObserver quim = new Person("Quim");

		ScheduledExecutorService s = Executors.newScheduledThreadPool(1);
		s.scheduleWithFixedDelay(semaphorRunner, 0, INTERVAL, TimeUnit.MILLISECONDS);

		ISemaphor semaphor2; 
		
		while (true) {
			registerObserver(laura, semaphor, 0);
			registerObserver(quim, semaphor, 0);

			semaphor2 = Semaphor.getInstance();//Singleton

			unregisterObserver(laura, semaphor2, INTERVAL * 3);
			unregisterObserver(quim, semaphor2, INTERVAL * 2);

			registerObserver(laura, semaphor2, INTERVAL * 3);

			registerObserver(quim, semaphor2, INTERVAL * 2);
			
			unregisterObserver(quim, semaphor, INTERVAL * 2);
			
		}

	}

	private static void registerObserver(IObserver observer, ISemaphor subject, int delay) {
		try {
			Thread.sleep(delay);
			System.out.println("\nRegistering " + observer.toString() + "...");
			subject.register(observer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void unregisterObserver(IObserver observer, ISemaphor subject, int delay) {
		try {
			Thread.sleep(delay);
			System.out.println("\nUnregistering " + observer.toString() + "...");
			subject.unregister(observer);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
