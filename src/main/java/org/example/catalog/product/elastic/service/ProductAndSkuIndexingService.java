package org.example.catalog.product.elastic.service;

import org.example.catalog.product.elastic.dto.ProductSkuIndexResponseDTO;
import org.example.catalog.product.elastic.model.ProductSkuIndex;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ProductAndSkuIndexingService {

    List<ProductSkuIndexResponseDTO> indexData();

    void indexProductsAndSkus(boolean isActive, List<ProductSkuIndexResponseDTO> indexedProductsAndSkus);

    void deleteExistingIndex();
}
