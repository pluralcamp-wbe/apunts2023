package com.pluralcamp.wbe.persistence.providers.jdbcsp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pluralcamp.wbe.entities.Color;
import com.pluralcamp.wbe.persistence.api.ColorDAO;
import com.pluralcamp.wbe.persistence.exceptions.DAOException;

public class ColorDAOJDBCSPImpl implements ColorDAO {

	@Override
	public Color getColorById(long id) throws DAOException {
		Color color = null;
		//TODO with CallableStatement
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
		//TODO with CallableStatement
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
