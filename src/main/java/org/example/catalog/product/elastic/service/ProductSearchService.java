package org.example.catalog.product.elastic.service;

import org.example.catalog.product.elastic.dto.ProductSkuIndexResponseDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductSearchService {

    List<ProductSkuIndexResponseDTO> searchProducts(String keyword);
}
