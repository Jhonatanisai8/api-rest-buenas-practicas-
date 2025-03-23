package com.isai.api_rest_buenas_practicas.models.dtos;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProductResponse {
    private Long productId;
    private String name;
    private String description;
    private BigDecimal price;
    private String status;
}
