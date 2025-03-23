package com.isai.api_rest_buenas_practicas.mapper;

import org.mapstruct.Mapper;

import com.isai.api_rest_buenas_practicas.models.dtos.CategoryResponse;
import com.isai.api_rest_buenas_practicas.models.entity.Category;

//lo podemos inyectar como un componente de spring
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse toCategoryResponse(Category category);
}
