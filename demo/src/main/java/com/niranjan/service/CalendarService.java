package com.niranjan.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niranjan.jpa.CalendarEventRepository;
import com.niranjan.model.Calendar;
import com.niranjan.model.Events;

@Repository
@Transactional(readOnly = true)
public class CalendarService implements CalendarEventRepository
{
	 @PersistenceContext
	   EntityManager entityManager;

	@Override
	public List<Events> getEvents(long calendarId) {
		List<Events> calendarEvents = new ArrayList<Events>();
		
		return calendarEvents;
	}

	@Override
	public Events addEvent(long calendarId, Events events) {
		
		return null;
	}

	@Override
	public Calendar getEvent(long calendarId, long eventId) {
		 Query query = entityManager.createNativeQuery("SELECT c.*,e.* FROM calendar c,events e as e " +
	                "WHERE c.id = ? and e.eventid = ?", Calendar.class);
	        query.setParameter(1, calendarId );
	        query.setParameter(2, eventId );
	        return (Calendar) query.getResultList().get(0);
	}
}
