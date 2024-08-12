package com.softlife_events.domain.repository;

import com.softlife_events.domain.Event;
import com.softlife_events.persistence.entity.Eventos;

import java.util.List;
import java.util.Optional;

public interface EventRepository {
    List<Event> getAll();
    Optional<List<Event>> getByCategory (int categoryId);
    Optional<Event> getEvent (int eventId);
    Event save (Event event);
    void delete (int eventId);

}
