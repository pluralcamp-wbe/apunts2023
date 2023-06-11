package com.pluralcamp.wbe.persistence.api;

import java.util.List;

import com.pluralcamp.wbe.entities.Event;
import com.pluralcamp.wbe.persistence.exceptions.DAOException;

public interface EventDAO {
    Event getEventById(long id) throws DAOException;
    List<Event> getEvents() throws DAOException;
    List<Event> getEvents(int offset, int count) throws DAOException;
    List<Event> getEvents(String searchTerm) throws DAOException;
    List<Event> getEvents(String searchTerm, int offset, int count) throws DAOException;

    long getNumOfEvents() throws DAOException;
}
