package com.softlife_events.persistence.crud;

import com.softlife_events.persistence.entity.Eventos;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface EventoCrudRepository extends CrudRepository<Eventos, Integer> {
    //Optional<List<Eventos>> findByidEvento (Integer idEvento);
    List<Eventos> findByIdCategoria(Integer idCategoria);
}
