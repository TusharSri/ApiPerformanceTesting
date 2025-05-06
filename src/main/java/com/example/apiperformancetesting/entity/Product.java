package com.example.apiperformancetesting.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    public long productId;

    @Column(name = "productName", nullable = false)
    public String productName;

    @Column(name = "productPrice", nullable = false)
    public long productPrice;

    @Column(name = "productQuantity", nullable = false)
    public long productQuantity;
}
