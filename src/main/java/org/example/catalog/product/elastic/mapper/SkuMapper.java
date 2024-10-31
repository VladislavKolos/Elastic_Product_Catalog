package org.example.catalog.product.elastic.mapper;

import org.example.catalog.product.elastic.dto.requestdto.SkuRequestDTO;
import org.example.catalog.product.elastic.dto.responsedto.SkuResponseDTO;
import org.example.catalog.product.elastic.model.Sku;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface SkuMapper {

    @Mapping(source = "product", target = "product")
    SkuResponseDTO toSkuResponseDTO(Sku sku);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "productId", target = "product.id")
    Sku toSku(SkuRequestDTO skuRequestDTO);
}
