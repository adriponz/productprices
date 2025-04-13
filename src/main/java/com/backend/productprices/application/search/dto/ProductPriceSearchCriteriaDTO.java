package com.backend.productprices.application.search.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPriceSearchCriteriaDTO {
    private Long productId;
    private Long brandId;
    private LocalDateTime date;
}
