package com.isai.api_rest_buenas_practicas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.isai.api_rest_buenas_practicas.exceptions.CategoryNotFoundException;
import com.isai.api_rest_buenas_practicas.exceptions.ErrorResponse;
import com.isai.api_rest_buenas_practicas.exceptions.ProductNotFoundException;

import static com.isai.api_rest_buenas_practicas.utils.ErrorCatalog.*;

import java.time.LocalDateTime;
import java.util.Collections;

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException argumentNotValidException) {

        BindingResult result = argumentNotValidException.getBindingResult();
        return ErrorResponse.builder()
                .code(INVALID_PRODUCT.getCode())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .message(INVALID_PRODUCT.getMessage())
                .detailMessages(result.getFieldErrors()
                        .stream()
                        .map(fieldError -> fieldError.getDefaultMessage())
                        .toList())
                .dateTime(LocalDateTime.now())
                .build();
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResponse handlerInternalServerError(
            Exception exception) {

        return ErrorResponse.builder()
                .code(GENERIC_ERROR.getCode())
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .message(GENERIC_ERROR.getMessage())
                .detailMessages(Collections.singletonList(exception.getMessage()))
                .dateTime(LocalDateTime.now())
                .build();
    }

}
