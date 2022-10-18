package com.productmanagementsystem.repository;

import com.productmanagementsystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select * from product where product_Id=:id",nativeQuery = true)
    Optional<Product> findProductById(String id);
}
