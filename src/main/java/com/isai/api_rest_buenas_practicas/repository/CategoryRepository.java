package com.isai.api_rest_buenas_practicas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.isai.api_rest_buenas_practicas.models.entity.Category;

@Repository
public interface CategoryRepository
        extends JpaRepository<Category, Long> {

}