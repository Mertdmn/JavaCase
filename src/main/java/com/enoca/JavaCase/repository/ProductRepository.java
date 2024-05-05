package com.enoca.JavaCase.repository;

import com.enoca.JavaCase.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
