package com.example.apiperformancetesting.repository;

import com.example.apiperformancetesting.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
