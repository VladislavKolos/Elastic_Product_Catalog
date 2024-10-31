package org.example.catalog.product.elastic.mapper;

import org.example.catalog.product.elastic.dto.requestdto.ProductRequestDTO;
import org.example.catalog.product.elastic.dto.responsedto.ProductResponseDTO;
import org.example.catalog.product.elastic.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponseDTO toProductResponseDTO(Product product);

    @Mapping(target = "id", ignore = true)
    Product toProduct(ProductRequestDTO productRequestDTO);
}
