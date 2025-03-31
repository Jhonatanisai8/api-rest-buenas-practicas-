package com.isai.api_rest_buenas_practicas.service;

import java.util.List;

public interface CrudService<T, R, Y> {
    T findById(Long idBuscar);

    List<T> findAll();

    List<T> findAllByCategoryId(Long idBuscar);

    T save(Y entity);

    T update(Long id, Y request);

    void deleteById(Long id);
}
