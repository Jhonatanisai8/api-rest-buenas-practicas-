package com.isai.api_rest_buenas_practicas.models.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateProductRequest {

    @NotEmpty(message = "Name is required")
    private String nameProduct;

    private String description;

    @NotNull(message = "Price is required")
    private BigDecimal price;

    @NotNull(message = "Category Id is required")
    private Long categoryId;
}
