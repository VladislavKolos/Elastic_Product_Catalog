package org.example.catalog.product.elastic.repository;

import org.example.catalog.product.elastic.model.Sku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkuRepository extends JpaRepository<Sku, Integer> {
    List<Sku> findByProductId(Integer id);
}
