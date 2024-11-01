package org.example.catalog.product.elastic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductSkuIndexResponseDTO {

    private int productId;
    private String productName;
    private String description;
    private BigDecimal price;
    private boolean active;
    private LocalDate startDate;
    private String skuCode;
    private LocalDateTime createdAt;
}
