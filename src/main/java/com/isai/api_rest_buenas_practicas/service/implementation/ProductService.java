package com.isai.api_rest_buenas_practicas.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.isai.api_rest_buenas_practicas.exceptions.CategoryNotFoundException;
import com.isai.api_rest_buenas_practicas.exceptions.ProductNotFoundException;
import com.isai.api_rest_buenas_practicas.mapper.ProductMapper;
import com.isai.api_rest_buenas_practicas.models.dtos.CategoryResponse;
import com.isai.api_rest_buenas_practicas.models.dtos.CreateProductRequest;
import com.isai.api_rest_buenas_practicas.models.dtos.ProductResponse;
import com.isai.api_rest_buenas_practicas.models.entity.Product;
import com.isai.api_rest_buenas_practicas.repository.CategoryRepository;
import com.isai.api_rest_buenas_practicas.repository.ProductRepository;
import com.isai.api_rest_buenas_practicas.service.CrudService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService
        implements CrudService<ProductResponse, CategoryResponse, CreateProductRequest> {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final ProductMapper productMapper;

    @Override
    public ProductResponse findById(Long idBuscar) {
        return productRepository.findById(idBuscar)
                .map(product -> productMapper.toProductResponse(product))
                .orElseThrow(ProductNotFoundException::new);
    }

    @Override
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(product -> productMapper.toProductResponse(product))
                .toList();
    }

    @Override
    public List<ProductResponse> findAllByCategoryId(Long idBuscar) {
        return categoryRepository.findById(idBuscar)
                .map(category -> productRepository.findAllByCategory(category))
                .map(products -> products.stream()
                        .map(produt -> productMapper.toProductResponse(produt))
                        .toList())
                .orElseThrow(() -> new CategoryNotFoundException());
    }

    @Override
    public ProductResponse save(CreateProductRequest request) {
        return categoryRepository.findById(request.getCategoryId())
                .map(category -> {
                    Product product = new Product();
                    product.setNameProduct(request.getNameProduct());
                    product.setDescription(request.getDescription());
                    product.setPrice(request.getPrice());
                    product.setCategory(category);
                    product.setStatus(true);
                    return productRepository.save(product);
                })
                .map(product -> productMapper.toProductResponse(product))
                .orElseThrow(() -> new CategoryNotFoundException());

    }

    @Override
    public ProductResponse update(Long id, CategoryResponse request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
