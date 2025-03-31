package com.isai.api_rest_buenas_practicas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isai.api_rest_buenas_practicas.models.dtos.ProductResponse;
import com.isai.api_rest_buenas_practicas.service.implementation.ProductService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/findAllProducts")
    public List<ProductResponse> findAllProducts() {
        return productService.findAll();
    }

}
