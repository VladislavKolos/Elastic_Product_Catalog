package org.example.catalog.product.elastic.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.catalog.product.elastic.dto.ProductSkuIndexResponseDTO;
import org.example.catalog.product.elastic.model.ProductSkuIndex;
import org.example.catalog.product.elastic.service.ProductAndSkuIndexingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/index")
@RequiredArgsConstructor
public class ProductAndSkuIndexingController {

    private final ProductAndSkuIndexingService productAndSkuIndexingService;

    @PostMapping("/create")
    public ResponseEntity<List<ProductSkuIndexResponseDTO>> createDataInElasticsearch() {
        List<ProductSkuIndexResponseDTO> productSkuList = productAndSkuIndexingService.indexData();

        log.info("The document was successfully indexed");

        return ResponseEntity.ok(productSkuList);
    }
}
