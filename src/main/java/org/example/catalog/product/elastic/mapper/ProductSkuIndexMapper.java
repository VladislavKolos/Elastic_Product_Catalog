package org.example.catalog.product.elastic.mapper;

import org.example.catalog.product.elastic.dto.ProductSkuIndexResponseDTO;
import org.example.catalog.product.elastic.model.ProductSkuIndex;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ProductSkuIndexMapper {

    ProductSkuIndexResponseDTO toProductSkuIndexResponseDTO(ProductSkuIndex productSkuIndex);


}
