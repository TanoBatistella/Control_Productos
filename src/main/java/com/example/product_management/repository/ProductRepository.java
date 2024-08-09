package com.example.product_management.repository;

   import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product_management.model.Product;

   public interface ProductRepository extends JpaRepository<Product, Long> {
   }