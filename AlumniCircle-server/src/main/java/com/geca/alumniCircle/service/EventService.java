package com.geca.alumniCircle.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geca.alumniCircle.model.Event;
import com.geca.alumniCircle.repository.EventRepository;

@Service
public class EventService {
	
	@Autowired
	EventRepository eventRepository;
	
	public Event addEvent(Event event) {
		return eventRepository.save(event);
	}
	
	public Event updateEvent(Event event) {
		return eventRepository.save(event);
	}
	
	public List<Event> getAllEvents(){
		return eventRepository.findAll();
	}
	
	public Optional<Event> getEvent(long id) {
		return eventRepository.findById(id);
		
	}
	
	public void deleteEvent(long id) {
		eventRepository.deleteById(id);
	}
}
