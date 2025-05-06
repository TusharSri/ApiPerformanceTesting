package com.example.apiperformancetesting.service.impl;

import com.example.apiperformancetesting.entity.Product;
import com.example.apiperformancetesting.payload.ProductDTO;
import com.example.apiperformancetesting.repository.ProductRepository;
import com.example.apiperformancetesting.service.ProductService;
import com.example.apiperformancetesting.util.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> allProducts = productRepository.findAll()
                .stream()
                .map(productMapper::toProductDTO)
                .toList();

        return allProducts;
    }

    // Use Executor to fetch products in parallel
    //TODO - check for parallel streams also
    public CompletableFuture<List<ProductDTO>> getAllProductsAsync() {
        return CompletableFuture.supplyAsync(() -> {
            return productRepository.findAll()
                    .stream()
                    .map(productMapper::toProductDTO)
                    .toList();
        }, threadPoolExecutor);
    }


}

