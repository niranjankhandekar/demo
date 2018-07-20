package com.niranjan.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.niranjan.jpa.CalendarRepository;
import com.niranjan.model.Calendar;
import com.niranjan.model.Events;

@RestController
public class CalendarController 
{
	@Autowired
	private CalendarRepository calendarRepository;
	@GetMapping("/calendars/{calendarId}/events")
	public List<Calendar> retrieveCoursesForStudent(@PathVariable Iterable<Long> calendarId) {
		return calendarRepository.findAllById(calendarId);
	}

	@PostMapping("/calendars/{calendarId}/events")
	public ResponseEntity<Void> addEvent(
			@PathVariable long calendarId, @RequestBody Events event) {

		Events events = calendarRepository.addEvent( calendarId, event);

		if (events == null)
			return ResponseEntity.noContent().build();

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path(
				"/{id}").buildAndExpand(events.getEventid()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping("/calendars/{calendarId}/events/{eventId}")
	public Calendar getEvent(@PathVariable long calendarId,
			@PathVariable long eventId) {
		return calendarRepository.getEvent(calendarId, eventId);
	}

}
