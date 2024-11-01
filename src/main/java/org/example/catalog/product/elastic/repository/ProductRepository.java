package org.example.catalog.product.elastic.repository;

import org.example.catalog.product.elastic.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByActive(boolean active);
}
