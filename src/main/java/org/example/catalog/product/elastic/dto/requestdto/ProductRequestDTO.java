package org.example.catalog.product.elastic.dto.requestdto;

import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

    private String productName;

    private String description;

    private BigDecimal price;

    private boolean active;

    private LocalDate startDate;
}
