package com.isai.api_rest_buenas_practicas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.isai.api_rest_buenas_practicas.models.dtos.ProductResponse;
import com.isai.api_rest_buenas_practicas.models.entity.Product;
import static com.isai.api_rest_buenas_practicas.utils.Constants.*;

// Esto significa que si ProductMapper necesita convertir un objeto Category, delegará esa conversión a CategoryMapper.
@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    @Mapping(target = "status", expression = "java(mapStatus(product))")
    ProductResponse toProductResponse(Product product);

    default String mapStatus(Product product) {
        return product.getStatus() ? ACTIVE_STATUS : INACTIVE_STATUS;
    }
}
