package com.pluralcamp.pair.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pluralcamp.pair.entities.Event;
import com.pluralcamp.pair.entities.Money;
import com.pluralcamp.pair.entities.Pair;
import com.pluralcamp.pair.entities.Person;
import com.pluralcamp.pair.entities.Student;
import com.pluralcamp.pair.entities.Ticket;

public class App {

	public static void main(String[] args) {
		
		//InfoEvent infoEvent = new InfoEvent();
		
		Pair<Event,Person[]> infoEvent = new Pair<>();
		infoEvent.setKey(new Event());
		infoEvent.setValue(new Person[5]);		

		//Payment payment = new Payment();
		Pair<Money,Ticket[]> payment = new Pair<>();
		payment.setKey(new Money());
		payment.setValue(new Ticket[12]);
		
		List<Pair<Money,Ticket[]>> pagosAnuales = new ArrayList<>();
		
		
		Pair<String,Person> pair = new Pair<>();
		pair.setKey("12345678K");
		pair.setValue(new Person("Pepet", "Cases"));
		
		
		//Map
		Map<String, String> dataPersons = new HashMap<>();
		dataPersons.put("12345678A", "Laura Casamitjana");
		dataPersons.put("98765439Z", "Josep Casacuberta");
		dataPersons.put("45645632P", "Miquel Queralt");
		dataPersons.put("23498755H", "Eulalia Forners");
		dataPersons.put("07651206T", "Abril Nevada");
		
		List<Pair<String,Person>> persons  = new ArrayList<>();
		
		
		for(Map.Entry<String,String> entry: dataPersons.entrySet()) {
			
			//Creo un nou Pair que ficaré dins de la llista de pairs:
			Pair<String, Person> par = new Pair<>();
			
			//Obtinc el String dni que ficaré en el Pair creat
			String dni = entry.getKey();
			
			//Obtinc el nom i cognom (strings) que necessito per a crear
			//un objecte de tipus Person
			String[] nombreCompleto = entry.getValue().split(" ");
			String nombre = nombreCompleto[0];
			String apellido = nombreCompleto[1];
			
			//Creo l'objecte de tipus Person amb el nom i cognom trobats
			Person persona = new Person(nombre, apellido);
			
			//Assigno la clau (String dni) i el valor (Person persona)
			//al pair creat abans
			par.setKey(dni);
			par.setValue(persona);
			
			//Amb el pair ja complet, el fico dins de la llista de pairs
			persons.add(par);
			
		}
		
		for(Pair<String,Person> par : persons) {
			System.out.println(par.toString());
		}
		
		
		
	}

}
