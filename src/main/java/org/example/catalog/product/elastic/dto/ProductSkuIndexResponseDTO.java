package org.example.catalog.product.elastic.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductSkuIndexResponseDTO {

    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("product_name")
    private String productName;

    private String description;
    private BigDecimal price;
    private boolean active;

    @JsonProperty("start_date")
    private LocalDate startDate;

    @JsonProperty("sku_code")
    private String skuCode;

    @JsonProperty("create_at")
    private LocalDateTime createdAt;
}
