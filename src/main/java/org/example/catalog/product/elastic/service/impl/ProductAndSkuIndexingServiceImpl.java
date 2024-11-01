package org.example.catalog.product.elastic.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.IndexRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.catalog.product.elastic.dto.ProductSkuIndexResponseDTO;
import org.example.catalog.product.elastic.mapper.ProductSkuIndexMapper;
import org.example.catalog.product.elastic.model.Product;
import org.example.catalog.product.elastic.model.ProductSkuIndex;
import org.example.catalog.product.elastic.model.Sku;
import org.example.catalog.product.elastic.repository.ProductRepository;
import org.example.catalog.product.elastic.repository.SkuRepository;
import org.example.catalog.product.elastic.service.ProductAndSkuIndexingService;
import org.example.catalog.product.elastic.util.ElasticProductCatalogUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductAndSkuIndexingServiceImpl implements ProductAndSkuIndexingService {

    private final ElasticsearchClient elasticsearchClient;
    private final ProductRepository productRepository;
    private final SkuRepository skuRepository;
    private final ProductSkuIndexMapper indexMapper;


    @Override
    @Transactional
    public List<ProductSkuIndexResponseDTO> indexData() {
        deleteExistingIndex();

        List<ProductSkuIndexResponseDTO> indexedProductsAndSkus = new ArrayList<>();

        indexProductsAndSkus(ElasticProductCatalogUtil.ACTIVE_TRUE, indexedProductsAndSkus);
        indexProductsAndSkus(ElasticProductCatalogUtil.ACTIVE_FALSE, indexedProductsAndSkus);

        return indexedProductsAndSkus;
    }

    @Override
    @Transactional
    public void indexProductsAndSkus(boolean isActive, List<ProductSkuIndexResponseDTO> indexedProductsAndSkus) {
        List<Product> products = productRepository.findByActive(isActive);

        products.forEach(product -> {
            List<Sku> skus = skuRepository.findByProductId(product.getId());

            skus.forEach(sku -> {
                try {
                    ProductSkuIndex productSkuIndex = buildProductSkuIndex(product, sku);

                    IndexRequest<ProductSkuIndex> request = new IndexRequest.Builder<ProductSkuIndex>()
                            .index(ElasticProductCatalogUtil.INDEX_NAME)
                            .id(productSkuIndex.getSkuCode())
                            .document(productSkuIndex)
                            .build();

                    elasticsearchClient.index(request);

                    indexedProductsAndSkus.add(indexMapper.toProductSkuIndexResponseDTO(productSkuIndex));

                } catch (Exception e) {
                    log.error("Error indexing document with SKU code: " + sku.getSkuCode(), e);
                }
            });
        });
    }

    @Override
    @Transactional
    public void deleteExistingIndex() {
        try {
            boolean indexExists = elasticsearchClient.indices()
                    .exists(e -> e.index(ElasticProductCatalogUtil.INDEX_NAME))
                    .value();

            if (indexExists) {
                elasticsearchClient.indices().delete(d -> d.index(ElasticProductCatalogUtil.INDEX_NAME));
                log.info("Deleted existing index: " + ElasticProductCatalogUtil.INDEX_NAME);
            } else {
                log.info("Index does not exist: " + ElasticProductCatalogUtil.INDEX_NAME);
            }

        } catch (Exception e) {
            log.error("Index does not exist or cannot be deleted: ", e);
        }
    }

    private ProductSkuIndex buildProductSkuIndex(Product product, Sku sku) {
        return ProductSkuIndex.builder()
                .productId(product.getId())
                .productName(product.getProductName())
                .description(product.getDescription())
                .price(product.getPrice())
                .active(product.isActive())
                .startDate(product.getStartDate())
                .skuCode(sku.getSkuCode())
                .createdAt(sku.getCreatedAt())
                .build();
    }
}
