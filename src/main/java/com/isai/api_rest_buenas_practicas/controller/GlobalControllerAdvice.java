package com.isai.api_rest_buenas_practicas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.isai.api_rest_buenas_practicas.exceptions.CategoryNotFoundException;
import com.isai.api_rest_buenas_practicas.exceptions.ErrorResponse;
import com.isai.api_rest_buenas_practicas.exceptions.ProductNotFoundException;

import static com.isai.api_rest_buenas_practicas.utils.ErrorCatalog.*;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProductNotFoundException.class)
    public ErrorResponse handlerProductNotFound() {
        return ErrorResponse.builder()
                .code(PRODUCT_NOT_FOUND.getCode())
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(PRODUCT_NOT_FOUND.getMessage())
                .dateTime(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryNotFoundException.class)
    public ErrorResponse handlerCategoryNotFound() {
        return ErrorResponse.builder()
                .code(CATEGORY_NOT_FOUND.getCode())
                .httpStatus(HttpStatus.NOT_FOUND)
                .message(CATEGORY_NOT_FOUND.getMessage())
                .dateTime(LocalDateTime.now())
                .build();
    }

}
