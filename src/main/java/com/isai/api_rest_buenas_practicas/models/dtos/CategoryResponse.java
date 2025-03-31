package com.isai.api_rest_buenas_practicas.models.dtos;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CategoryResponse {
    private Long categoryId;
    private String nameCategory;
}
