package com.example.apiperformancetesting.service;

import com.example.apiperformancetesting.payload.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
}
