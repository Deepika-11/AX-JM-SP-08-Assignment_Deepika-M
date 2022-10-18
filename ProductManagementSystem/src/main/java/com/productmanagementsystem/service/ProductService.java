package com.productmanagementsystem.service;

import com.productmanagementsystem.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    String saveProduct(Product product);
    List<Product> getAllProducts();
    Optional<Product> getProductBasedOnName(String name);
}
