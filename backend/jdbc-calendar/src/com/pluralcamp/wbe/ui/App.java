package com.pluralcamp.wbe.ui;

import java.util.List;

import com.pluralcamp.wbe.entities.Color;
import com.pluralcamp.wbe.persistence.api.ColorDAO;
import com.pluralcamp.wbe.persistence.api.EmployeeDAO;
import com.pluralcamp.wbe.persistence.api.EventDAO;
import com.pluralcamp.wbe.persistence.exceptions.DAOException;
import com.pluralcamp.wbe.persistence.providers.hibernate.impl.ColorDAOHibernateImpl;
import com.pluralcamp.wbe.persistence.providers.jdbc.ColorDAOJDBCImpl;
import com.pluralcamp.wbe.persistence.providers.jdbcsp.EmployeeDAOJDBCSPImpl;
import com.pluralcamp.wbe.persistence.providers.jdbcsp.EventDAOJDBCSPImpl;
import com.pluralcamp.wbe.persistence.utils.DAOFactory;

public class App {

	public static void main(String[] args) {
		
		DAOFactory daoFactory = new DAOFactory();
		
		ColorDAO colorDAO = daoFactory.getColorDAO();
		EmployeeDAO employeeDAO = daoFactory.getEmployeeDAO();
		EventDAO eventDAO = daoFactory.getEventDAO();

		
		printColorById(colorDAO, 5);

		printAllColors(colorDAO);

		printEmployeeById(employeeDAO, 1);

		printAllEmployees(employeeDAO);

		printEmployees(employeeDAO, 1, 2);

		printEventById(eventDAO, 1);

	}

	private static void printColorById(ColorDAO colorDAO, int id) {

		// Obtener un único color por su id
		try {
			var c = colorDAO.getColorById(id);
			if (c != null) {
				System.out.println(c.toString());
			}

		} catch (DAOException ex) {
			System.out.printf("Error:: %s %n", ex.getMessage());
		}
	}

	private static void printAllColors(ColorDAO colorDAO) {
		// Obtener un único color por su id
		try {
			List<Color> colors = colorDAO.getColors();
			for (Color c : colors) {
				System.out.println(c.toString());
			}

		} catch (DAOException ex) {
			System.out.printf("Error:: %s %n", ex.getMessage());
		}
	}

	private static void printEmployeeById(EmployeeDAO employeeDAO, int id) {

		// Obtener un único color por su id
		try {
			var e = employeeDAO.getEmployeeById(id);
			if (e != null) {
				System.out.println(e.toString());
			}

		} catch (DAOException ex) {
			System.out.printf("Error:: %s %n", ex.getMessage());
		}
	}

	private static void printAllEmployees(EmployeeDAO employeeDAO) {

		// Obtener un único color por su id
		try {
			var employees = employeeDAO.getEmployees();
			for (var e : employees) {
				System.out.println(e.toString());
			}

		} catch (DAOException ex) {
			System.out.printf("Error:: %s %n", ex.getMessage());
		}
	}

	private static void printEmployees(EmployeeDAO employeeDAO, int offset, int count) {

		// Obtener un único color por su id
		try {
			var employees = employeeDAO.getEmployees(offset,count);
			for (var e : employees) {
				System.out.println(e.toString());
			}

		} catch (DAOException ex) {
			System.out.printf("Error:: %s %n", ex.getMessage());
		}
	}

	private static void printEventById(EventDAO eventDAO, int id) {

		// Obtener un único color por su id
		try {
			var e = eventDAO.getEventById(id);
			if (e != null) {
				System.out.println(e.toString());
			}

		} catch (DAOException ex) {
			System.out.printf("Error:: %s %n", ex.getMessage());
		}
	}

}
