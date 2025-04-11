package com.backend.productprices.application.productprice.search.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductPriceSearchCriteriaDTO {
    private Integer productId;
    private Integer brandId;
    private LocalDateTime date;
}
