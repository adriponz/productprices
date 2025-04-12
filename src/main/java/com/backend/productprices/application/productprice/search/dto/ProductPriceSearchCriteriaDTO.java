package com.backend.productprices.application.productprice.search.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductPriceSearchCriteriaDTO {
    private Long productId;
    private Long brandId;
    private LocalDateTime date;
}
