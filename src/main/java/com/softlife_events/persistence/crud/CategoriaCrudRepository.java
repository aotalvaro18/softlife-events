package com.softlife_events.persistence.crud;

import com.softlife_events.persistence.entity.Categorias;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaCrudRepository extends CrudRepository<Categorias, Integer> {
    Optional<List<Categorias>> findByIdCategoria (Integer id_categoria);

}
