package com.isai.api_rest_buenas_practicas.service;

import java.util.List;

public interface CrudService<T, R> {
    T findById(Long idBuscar);

    List<T> findAll();

    List<T> findAllByCategoryId(Long idBuscar);

    T save(T entity);

    T update(Long id, R request);

    void deleteById(Long id);
}
