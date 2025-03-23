package com.isai.api_rest_buenas_practicas.models.dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL) // algun campo sea nulo no se muestra en la respuesta
public class ProductResponse {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private CategoryResponse category;
    private String status;
}
