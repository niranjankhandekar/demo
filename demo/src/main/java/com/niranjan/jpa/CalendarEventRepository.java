package com.niranjan.jpa;

import java.util.List;

import com.niranjan.model.Calendar;
import com.niranjan.model.Events;

public interface CalendarEventRepository {

	public List<Events> getEvents(long calendarId);
	
	public Events addEvent(long calendarId, Events events);
	
	public Calendar getEvent(long calendarId,long eventId);
}
