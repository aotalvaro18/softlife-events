package com.softlife_events.persistence.mapper;

import com.softlife_events.domain.Event;
import com.softlife_events.persistence.entity.Eventos;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {EventMapper.class})
public interface EventMapper {

    @Mappings({
     @Mapping(source = "idEvento", target = "eventId"),
     @Mapping(source = "nombre", target = "name"),
     @Mapping(source = "fechaInicial", target = "dateStart"),
     @Mapping(source = "fechaFinal", target = "dateEnd"),
     @Mapping(source = "idCategoria", target = "categoryId"),
     @Mapping(source = "valor", target = "price"),
     @Mapping(source = "estado", target = "active")
    })
    Event toEvent (Eventos eventos);
    List<Event> toEvents(List<Eventos> eventos);

    @InheritInverseConfiguration
    Eventos toEventos (Event event);

}
