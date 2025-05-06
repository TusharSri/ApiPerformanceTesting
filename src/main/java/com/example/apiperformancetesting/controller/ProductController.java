package com.example.apiperformancetesting.controller;

import com.example.apiperformancetesting.payload.ProductDTO;
import com.example.apiperformancetesting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productController")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/allAsync")
    ResponseEntity<List<ProductDTO>> getAllProductsAsync() {
        // This is release change
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
}
