package com.pluralcamp.wbe.persistence.providers.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pluralcamp.wbe.entities.Color;
import com.pluralcamp.wbe.persistence.api.ColorDAO;
import com.pluralcamp.wbe.persistence.exceptions.DAOException;

public class ColorDAOJDBCImpl implements ColorDAO {

	@Override
	public Color getColorById(long id) throws DAOException {
		Color color = null;

		// Paso 1: Obtener un conexión con la BD
		String url = "jdbc:mysql://localhost:3306/calendar?serverTimeZone=Europe/Paris";
		String username = "orboan";
		String password = "pluralcamp";
		String query = "SELECT id, name, red, green, blue FROM colors WHERE id = ?";
		Connection connection = null;
		// Paso 2: Crear un Statement (canal para enviar una query)
		PreparedStatement sentSQL = null;
		// Paso 3: Crear el canal para leer el Resultado (respuesta a mi query).
		ResultSet reader = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			sentSQL = connection.prepareStatement(query);
			sentSQL.setLong(1, id);
			reader = sentSQL.executeQuery();
			if (reader.next()) {
				// ORM : mapear la fila con el objeto de tipo Color
				color = getColorFrom(reader);
			}
		} catch (SQLException ex) {
			throw new DAOException(ex);
		} finally {
			try { // Paso 4: cerrar los recursos SIEMPRE EN ORDEN INVERSO
				reader.close();
				sentSQL.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return color;
	}

	// Mapeo fila - objeto
	private Color getColorFrom(ResultSet reader) throws SQLException {
		var color = new Color(reader.getString("name"),
				reader.getInt("red"),
				reader.getInt("green"),
				reader.getInt("blue"));
		color.setId(reader.getLong("id"));
		return color;
	}

	@Override
	public List<Color> getColors() throws DAOException {
		List<Color> colors = new ArrayList<>();

		// Paso 1: Obtener un conexión con la BD
		String url = "jdbc:mysql://localhost:3306/calendar?serverTimeZone=Europe/Paris";
		String username = "orboan";
		String password = "pluralcamp";
		String query = "SELECT id, name, red, green, blue FROM colors";
		Connection connection = null;
		// Paso 2: Crear un Statement (canal para enviar una query)
		PreparedStatement sentSQL = null;
		// Paso 3: Crear el canal para leer el Resultado (respuesta a mi query).
		ResultSet reader = null;
		try {
			connection = DriverManager.getConnection(url, username, password);
			sentSQL = connection.prepareStatement(query);
			reader = sentSQL.executeQuery();
			while (reader.next()) {
				// ORM : mapear la fila con el objeto de tipo Color
				Color color = getColorFrom(reader);
				colors.add(color);
			}
		} catch (SQLException ex) {
			throw new DAOException(ex);
		} finally {
			try { // Paso 4: cerrar los recursos SIEMPRE EN ORDEN INVERSO
				reader.close();
				sentSQL.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return colors;
	}

	@Override
	public List<Color> getColors(int offset, int count) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Color> getColors(String searchTerm) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Color> getColors(String searchTerm, int offset, int count) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getNumOfColors() throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}

}
