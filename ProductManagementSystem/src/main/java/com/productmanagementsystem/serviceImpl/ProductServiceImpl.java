package com.productmanagementsystem.serviceImpl;

import com.productmanagementsystem.exception.IdAlreadyExistsException;
import com.productmanagementsystem.exception.InvalidProductIdException;
import com.productmanagementsystem.model.Product;
import com.productmanagementsystem.repository.ProductRepository;
import com.productmanagementsystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public String saveProduct(Product product) {
        if(productRepository.findProductById(product.getProductId()).isPresent()){
            throw new IdAlreadyExistsException();
        }
        productRepository.save(product);
        return "Product details saved successfully";
    }

    @Override
    public List<Product> getAllProducts() {
        if(productRepository.findAll().size() == 0 )
            throw new InvalidProductIdException();
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public Optional<Product> getProductBasedOnName(String name) {
        if(!productRepository.findProductById(name).isPresent()){
            throw new InvalidProductIdException();
        }
        return productRepository.findProductById(name);
    }

}
