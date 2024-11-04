package org.example.catalog.product.elastic.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.catalog.product.elastic.dto.ProductSkuIndexResponseDTO;
import org.example.catalog.product.elastic.service.ProductSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductSearchController {

    private final ProductSearchService productSearchService;

    @GetMapping("/search")
    public ResponseEntity<List<ProductSkuIndexResponseDTO>> searchProducts(@RequestParam String keyword) {
        List<ProductSkuIndexResponseDTO> responseDTOList = productSearchService.searchProducts(keyword);

        log.info("Products/documents found successfully");

        return ResponseEntity.ok(responseDTOList);
    }
}
