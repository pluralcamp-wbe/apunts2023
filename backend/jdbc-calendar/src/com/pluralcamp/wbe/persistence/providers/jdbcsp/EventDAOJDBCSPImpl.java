package com.pluralcamp.wbe.persistence.providers.jdbcsp;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.pluralcamp.wbe.entities.Color;
import com.pluralcamp.wbe.entities.Event;
import com.pluralcamp.wbe.persistence.api.EventDAO;
import com.pluralcamp.wbe.persistence.exceptions.DAOException;

public class EventDAOJDBCSPImpl implements EventDAO {

	@Override
	public Event getEventById(long id) throws DAOException {
		Event event = null;

		// Paso 1: Obtener un conexión con la BD
		String url = "jdbc:mysql://localhost:3306/calendar?serverTimeZone=Europe/Paris";
		String username = "orboan";
		String password = "pluralcamp";
		String query = "CALL getEventById(?)";

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
					event = getEventFrom(reader);
				}
			} // reader is automatically closed here
		} // sentSQL and connection are automatically closed here
		catch (SQLException ex) {
			throw new DAOException(ex);
		}

		return event;
	}

	@Override
	public List<Event> getEvents() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEvents(int offset, int count) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEvents(String searchTerm) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEvents(String searchTerm, int offset, int count) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getNumOfEvents() throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

	private Event getEventFrom(ResultSet reader) throws SQLException {
		var backgroundColor = new Color(reader.getString("bc.name"), reader.getInt("bc.red"), reader.getInt("bc.green"),
				reader.getInt("bc.blue"));
		backgroundColor.setId(reader.getLong("bc.id"));

		var textColor = new Color(reader.getString("tc.name"), reader.getInt("tc.red"), reader.getInt("tc.green"),
				reader.getInt("tc.blue"));
		textColor.setId(reader.getLong("tc.id"));

		var event = new Event(reader.getString("e.name"), reader.getDate("e.date").toLocalDate(),
				reader.getTime("e.startTime").toLocalTime(), reader.getTime("e.endTime").toLocalTime(),
				reader.getString("e.place"), reader.getString("e.description"), backgroundColor, textColor,
				reader.getBoolean("e.visible"));
		event.setRegistrationDate(reader.getTimestamp("e.registrationDate").toLocalDateTime());
		event.setId(reader.getLong("e.id"));

		return event;

	}

}
