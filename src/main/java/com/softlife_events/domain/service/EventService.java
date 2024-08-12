package com.softlife_events.domain.service;

import com.softlife_events.domain.Event;
import com.softlife_events.domain.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAll() {
        return eventRepository.getAll();
    }

    public Optional<Event> getEvent(int eventId) {
        return eventRepository.getEvent(eventId);
    }

    public Optional<List<Event>> getByCategory (int categoryId) {
        return eventRepository.getByCategory(categoryId);
    }

    public Event save (Event event) {
        return eventRepository.save(event);
    }

    public boolean delete (int eventId) {
        return getEvent(eventId).map(event -> {
            eventRepository.delete(eventId);
            return true;
        }).orElse(false);
    }

    public Optional<Event> updateEvent(int eventId, Event updatedEvent) {
        return getEvent(eventId).map(existingEvent -> {
            existingEvent.setName(updatedEvent.getName());
            existingEvent.setDateStart(updatedEvent.getDateStart());
            existingEvent.setDateEnd(updatedEvent.getDateEnd());
            existingEvent.setCategoryId(updatedEvent.getCategoryId());
            existingEvent.setPrice(updatedEvent.getPrice());
            existingEvent.setActive(updatedEvent.isActive());

            return eventRepository.save(existingEvent);
        });
    }


}
