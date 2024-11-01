package org.example.catalog.product.elastic.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSkuIndex {

    private int productId;
    private String productName;
    private String description;
    private BigDecimal price;
    private boolean active;
    private LocalDate startDate;
    private String skuCode;
    private LocalDateTime createdAt;
}
