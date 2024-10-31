package org.example.catalog.product.elastic.dto.requestdto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SkuRequestDTO {

    private String skuCode;

    private LocalDateTime createdAt;

    private int productId;
}
