package com.softlife_events.persistence;

import com.softlife_events.domain.Event;
import com.softlife_events.domain.repository.EventRepository;
import com.softlife_events.persistence.crud.EventoCrudRepository;
import com.softlife_events.persistence.entity.Eventos;
import com.softlife_events.persistence.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.hibernate.query.Order.asc;

@Repository
public class EventoRepository implements EventRepository {

    @Autowired
    private EventoCrudRepository eventoCrudRepository;

    @Autowired
    private EventMapper mapper;
    @Override
    public List<Event> getAll() {
        List<Eventos> eventos = (List<Eventos>) eventoCrudRepository.findAll();
        return mapper.toEvents(eventos);
    }

    @Override
    public Optional<List<Event>> getByCategory(int categoryId) {
        List<Eventos> eventos = eventoCrudRepository.findByIdCategoria(categoryId);
        return Optional.of(mapper.toEvents(eventos));
    }

    @Override
    public Optional<Event> getEvent (int eventId) {
        return eventoCrudRepository.findById(eventId).map(eventos -> mapper.toEvent(eventos));
    }

    @Override
    public Event save(Event event) {
        Eventos eventos = mapper.toEventos(event);
        return mapper.toEvent(eventoCrudRepository.save(eventos));
    }

    @Override
    public void delete(int eventId) {
        eventoCrudRepository.deleteById(eventId);

    }


}
