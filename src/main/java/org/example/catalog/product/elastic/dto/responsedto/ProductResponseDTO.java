package org.example.catalog.product.elastic.dto.responsedto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    private int id;

    private String productName;

    private String description;

    private BigDecimal price;

    private boolean active;

    private LocalDate startDate;
}
