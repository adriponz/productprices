package com.backend.productprices.infrastructure.persistence.model.productprice;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductPricePO {
    private Long productId;
    private Long brandId;
    private Double price;
    private String currency;
    private Long priceListId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priority;
}
