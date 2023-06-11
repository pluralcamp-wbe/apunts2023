package com.pluralcamp.wbe.persistence.providers.jdbcsp;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pluralcamp.wbe.entities.Employee;
import com.pluralcamp.wbe.persistence.api.EmployeeDAO;
import com.pluralcamp.wbe.persistence.exceptions.DAOException;

public class EmployeeDAOJDBCSPImpl implements EmployeeDAO {

	@Override
	public Employee getEmployeeById(long id) throws DAOException {
		Employee employee = null;

		// Paso 1: Obtener un conexión con la BD
		String url = "jdbc:mysql://localhost:3306/calendar?serverTimeZone=Europe/Paris";
		String username = "orboan";
		String password = "pluralcamp";
		String query = "CALL getEmployeeById(?)";

		// try-with-resources (need to implement Autoclosable)
		try (
				// Paso 1: Obtener un conexión con la BD
				var connection = DriverManager.getConnection(url, username, password);
				// Paso 2: Crear un Statement (canal para enviar una query)
				var sentSQL = connection.prepareCall(query);

		) {
			sentSQL.setLong(1, id);
			// Paso 3: Crear el canal para leer el Resultado (respuesta a mi query).
			try (var reader = sentSQL.executeQuery()) {
				if (reader.next()) {
					// ORM : mapear la fila con el objeto de tipo Color
					employee = getEmployeeFrom(reader);
				}
			} // reader is automatically closed here
		} // sentSQL and connection are automatically closed here
		catch (SQLException ex) {
			throw new DAOException(ex);
		}

		return employee;
	}

	// Mapeo fila - objeto
	private Employee getEmployeeFrom(ResultSet reader) throws SQLException {
		var employee = new Employee(reader.getString("code"), reader.getString("firstname"),
				reader.getString("lastname"), Employee.Gender.valueOf(reader.getString("gender")),
				reader.getDate("birthDate").toLocalDate(), reader.getDate("hireDate").toLocalDate(),
				reader.getDouble("monthlySalary"), reader.getInt("payments"));
		employee.setId(reader.getLong("id"));
		return employee;
	}

	@Override
	public List<Employee> getEmployees() throws DAOException {
		List<Employee> employees = new ArrayList<>();

		// Paso 1: Obtener un conexión con la BD
		String url = "jdbc:mysql://localhost:3306/calendar?serverTimeZone=Europe/Paris";
		String username = "orboan";
		String password = "pluralcamp";
		String query = "CALL getEmployees()";

		// try-with-resources (need to implement Autoclosable)
		try (
				// Paso 1: Obtener un conexión con la BD
				var connection = DriverManager.getConnection(url, username, password);
				// Paso 2: Crear un Statement (canal para enviar una query) --> CallableStatement
				var sentSQL = connection.prepareCall(query);
				// Paso 3: Crear el canal para leer el Resultado (respuesta a mi query).
				var reader = sentSQL.executeQuery()

		) {
			while (reader.next()) {
				// ORM : mapear la fila con el objeto de tipo Color
				employees.add(getEmployeeFrom(reader));
			}
		} // reader, sentSQL and connection are automatically closed here
		catch (SQLException ex) {
			throw new DAOException(ex);
		}

		return employees;
	}

	@Override
	public List<Employee> getEmployees(int offset, int count) throws DAOException {
		List<Employee> employees = new ArrayList<>();

		// Paso 1: Obtener un conexión con la BD
		String url = "jdbc:mysql://localhost:3306/calendar?serverTimeZone=Europe/Paris";
		String username = "orboan";
		String password = "pluralcamp";
		String query = "CALL searchEmployeesByRange(?,?)";

		// try-with-resources (need to implement Autoclosable) 
		try (
				// Paso 1: Obtener un conexión con la BD
				var connection = DriverManager.getConnection(url, username, password);
				// Paso 2: Crear un Statement (canal para enviar una query) --> CallableStatement
				var sentSQL = connection.prepareCall(query);

		) {
			sentSQL.setInt(1, offset);
			sentSQL.setInt(2, count);
			try ( // Paso 3: Crear el canal para leer el Resultado (respuesta a mi query).
					var reader = sentSQL.executeQuery()) {
				while (reader.next()) {
					// ORM : mapear la fila con el objeto de tipo Color
					employees.add(getEmployeeFrom(reader));
				}
			}
		} // reader, sentSQL and connection are automatically closed here
		catch (SQLException ex) {
			throw new DAOException(ex);
		}

		return employees;
	}

	@Override
	public List<Employee> getEmployees(String searchTerm) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getEmployees(String searchTerm, int offset, int count) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getNumOfEmployees() throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Employee addEmployee(Employee employee) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
