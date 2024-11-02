package com.geca.alumniCircle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geca.alumniCircle.model.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
