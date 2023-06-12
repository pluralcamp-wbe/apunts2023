package com.pluralcamp.wbe.persistence.providers.hibernate.impl;

import java.util.List;

import org.hibernate.HibernateException;

import com.pluralcamp.wbe.entities.Color;
import com.pluralcamp.wbe.persistence.api.ColorDAO;
import com.pluralcamp.wbe.persistence.exceptions.DAOException;
import com.pluralcamp.wbe.persistence.providers.hibernate.utils.HibernateUtils;

public class ColorDAOHibernateImpl implements ColorDAO {

	@Override
	public Color getColorById(long id) throws DAOException {
        Color color = null;
        
        try (var session = HibernateUtils.getSessionFactory().openSession()) {
            
            var hql = session.createQuery("FROM Color AS c WHERE c.id = :id");
            hql.setParameter("id", id);
            color = (Color)hql.uniqueResult();       
        }
        catch (HibernateException ex) {
            throw new DAOException(ex);
        }
        
        return color;
	}

	@Override
	public List<Color> getColors() throws DAOException {
		// TODO Auto-generated method stub
		return null;
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
