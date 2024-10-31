package org.example.catalog.product.elastic.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkuResponseDTO {

    private int id;

    private String skuCode;

    private LocalDateTime createdAt;

    private ProductResponseDTO product;
}
