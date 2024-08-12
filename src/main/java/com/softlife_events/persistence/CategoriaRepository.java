package com.softlife_events.persistence;

import com.softlife_events.persistence.crud.CategoriaCrudRepository;
import com.softlife_events.persistence.entity.Categorias;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaRepository {

    private CategoriaCrudRepository categoriaCrudRepository;

    private List<Categorias> getAll() {
        return (List<Categorias>) categoriaCrudRepository.findAll();
    }

}
