package com.productmanagementsystem.controller;

import com.productmanagementsystem.model.Product;
import com.productmanagementsystem.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/save")
    public ResponseEntity<?> saveProductDetails(@RequestBody Product product) {
       String msg = productServiceImpl.saveProduct(product);
       return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productServiceImpl.getAllProducts(), HttpStatus.FOUND);
    }

    @GetMapping("/get/name/{name}")
    public ResponseEntity<?> getProductByName(@PathVariable("name") String name) {
        Product product = productServiceImpl.getProductBasedOnName(name).get();
        return new ResponseEntity<>(product, HttpStatus.FOUND);
    }

}