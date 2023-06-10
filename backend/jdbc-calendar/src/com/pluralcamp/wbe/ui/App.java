package com.pluralcamp.wbe.ui;

import java.util.List;

import com.pluralcamp.wbe.entities.Color;
import com.pluralcamp.wbe.persistence.api.ColorDAO;
import com.pluralcamp.wbe.persistence.exceptions.DAOException;
import com.pluralcamp.wbe.persistence.providers.jdbc.ColorDAOJDBCImpl;

public class App {

	public static void main(String[] args) {
		ColorDAO colorDAO = new ColorDAOJDBCImpl();
	    
		//Obtener un único color por su id
		try {
            var c = colorDAO.getColorById(5);
            if (c != null) {
                System.out.println(c.toString());
            }
            
        } catch (DAOException ex) {
            System.out.printf("Error:: %s %n", ex.getMessage());
        }
		
		
		//Obtener un único color por su id
		try {
            List<Color> colors = colorDAO.getColors();
            for(Color c : colors) {
                System.out.println(c.toString());
            }
            
        } catch (DAOException ex) {
            System.out.printf("Error:: %s %n", ex.getMessage());
        }

	}

}
