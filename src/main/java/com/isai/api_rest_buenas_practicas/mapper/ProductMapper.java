package com.isai.api_rest_buenas_practicas.mapper;

import org.mapstruct.Mapper;

import com.isai.api_rest_buenas_practicas.models.dtos.ProductResponse;
import com.isai.api_rest_buenas_practicas.models.entity.Product;
// Esto significa que si ProductMapper necesita convertir un objeto Category, delegará esa conversión a CategoryMapper.
@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {
    ProductResponse toProductResponse(Product product);
}
