package com.isai.api_rest_buenas_practicas.models.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreateProductRequest {

    @NotEmpty(message = "Name is required")
    private String name;

    private String description;

    @NotNull(message = "Price is required")
    private BigDecimal price;

    @NotNull(message = "Category Id is required")
    private Long categoryId;
}
