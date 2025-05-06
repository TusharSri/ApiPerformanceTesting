package com.example.apiperformancetesting.util;

import com.example.apiperformancetesting.entity.Product;
import com.example.apiperformancetesting.payload.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring") // Makes it a Spring Bean automatically
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    ProductDTO toProductDTO(Product product);

    Product toProduct(ProductDTO productDTO);
}
