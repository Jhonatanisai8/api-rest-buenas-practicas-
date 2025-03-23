package com.isai.api_rest_buenas_practicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.isai.api_rest_buenas_practicas.models.dtos.ProductResponse;
import com.isai.api_rest_buenas_practicas.models.entity.Product;

// Esto significa que si ProductMapper necesita convertir un objeto Category, delegará esa conversión a CategoryMapper.
@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    @Mapping(target = "status", expression = "java(mapStatus(product))")
    ProductResponse toProductResponse(Product product);

    default String mapStatus(Product product) {
        return product.getStatus() ? "ACTIVE" : "INACTIVE";
    }
}
