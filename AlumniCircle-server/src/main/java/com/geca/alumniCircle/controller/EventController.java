package com.geca.alumniCircle.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geca.alumniCircle.model.Event;
import com.geca.alumniCircle.service.EventService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/events")
public class EventController {

	@Autowired
	EventService eventService;

	@GetMapping("")
	public List<Event> getAllEvents() {
		return eventService.getAllEvents();
	}

	@GetMapping("/{id}")
	public Optional<Event> getEvent(@PathVariable Long id) {
		return eventService.getEvent(id);
	}

	@PostMapping("/add")
	public Event addEvent(@RequestBody Event event) {
		return eventService.addEvent(event);
	}

	@PutMapping("/update/{id}")
	public Event updateEvent(@PathVariable String id, @RequestBody Event event) {
		return eventService.updateEvent(event);
	}

	@PutMapping("/update")
	public Event updateEvent1(@RequestBody Event event) {
		return eventService.updateEvent(event);
	}

	@DeleteMapping("delete/{id}")
	public Optional<Event> deleteEvent(@PathVariable Long id) {
		Optional<Event> event = eventService.getEvent(id);
		eventService.deleteEvent(id);
		return event;
	}

}
