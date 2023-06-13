package com.pluralcamp.wbe.persistence.utils;

import com.pluralcamp.wbe.persistence.api.ColorDAO;
import com.pluralcamp.wbe.persistence.api.EmployeeDAO;
import com.pluralcamp.wbe.persistence.api.EventDAO;
import com.pluralcamp.wbe.persistence.providers.hibernate.impl.ColorDAOHibernateImpl;
import com.pluralcamp.wbe.persistence.providers.jdbcsp.EmployeeDAOJDBCSPImpl;
import com.pluralcamp.wbe.persistence.providers.jdbcsp.EventDAOJDBCSPImpl;

public class DAOFactory {

	private ColorDAO colorDAO;
	private EmployeeDAO employeeDAO;
	private EventDAO eventDAO;
	
	public synchronized ColorDAO getColorDAO() {
		if(this.colorDAO == null)
			this.colorDAO = new ColorDAOHibernateImpl();
		return colorDAO;		
	}
	
	public EmployeeDAO getEmployeeDAO() {
		if(this.employeeDAO == null)
			this.employeeDAO = new EmployeeDAOJDBCSPImpl();
		return employeeDAO;
	}
	
	public EventDAO getEventDAO() {
		if(this.eventDAO == null){
			this.eventDAO = new EventDAOJDBCSPImpl();
		}
		return eventDAO;
	}
	
	
	
}
