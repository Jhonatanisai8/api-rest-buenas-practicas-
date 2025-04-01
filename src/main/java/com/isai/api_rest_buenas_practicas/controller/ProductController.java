package com.isai.api_rest_buenas_practicas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isai.api_rest_buenas_practicas.models.dtos.CreateProductRequest;
import com.isai.api_rest_buenas_practicas.models.dtos.ProductResponse;
import com.isai.api_rest_buenas_practicas.service.implementation.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/findAllProducts")
    public List<ProductResponse> findAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/findByIdProduct/{idProduct}")
    public ProductResponse findByIdProduct(@Validated @PathVariable Long idProduct) {
        return productService.findById(idProduct);
    }

    // lista todos los productos de una categoria
    @GetMapping("/category/{idCategory}")
    public List<ProductResponse> findAllByCategoryId(@Validated @PathVariable Long idCategory) {
        return productService.findAllByCategoryId(idCategory);
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<ProductResponse> saveProductResponse(@Valid @RequestBody CreateProductRequest request) {
        ProductResponse productResponse = productService.save(request);
        return ResponseEntity
                .created(URI.create("/api/products/" + productResponse.getProductId()))
                .body(productResponse);
    }

    @PutMapping("/updateProduct/{idProduct}")
    public ProductResponse updateProduct(
            @PathVariable Long idProduct,
            @Valid @RequestBody CreateProductRequest requestProduct) {
        return productService.update(idProduct, requestProduct);
    }
}
