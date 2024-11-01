package org.example.catalog.product.elastic.service.impl;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.SearchRequest;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.catalog.product.elastic.dto.ProductSkuIndexResponseDTO;
import org.example.catalog.product.elastic.mapper.ProductSkuIndexMapper;
import org.example.catalog.product.elastic.model.ProductSkuIndex;
import org.example.catalog.product.elastic.service.ProductSearchService;
import org.example.catalog.product.elastic.util.ElasticProductCatalogUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductSearchServiceImpl implements ProductSearchService {

    private final ElasticsearchClient elasticsearchClient;

    private final ProductSkuIndexMapper indexMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProductSkuIndexResponseDTO> searchProducts(String keyword) {
        List<ProductSkuIndexResponseDTO> responseDTOList = new ArrayList<>();

        try {
            SearchRequest searchRequest = SearchRequest.of(s -> s
                    .index(ElasticProductCatalogUtil.INDEX_NAME)
                    .query(q -> q
                            .multiMatch(m -> m
                                    .query(keyword)
                                    .fields("productName", "description")
                            )
                    )
            );
            SearchResponse<ProductSkuIndex> searchResponse = elasticsearchClient.search(searchRequest,
                    ProductSkuIndex.class);

            responseDTOList = searchResponse.hits().hits().stream()
                    .map(Hit::source)
                    .map(indexMapper::toProductSkuIndexResponseDTO)
                    .toList();

        } catch (Exception e) {
            log.error("Error while searching: ", e);
        }
        return responseDTOList;
    }
}
