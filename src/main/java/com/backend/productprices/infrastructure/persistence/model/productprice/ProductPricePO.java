package com.backend.productprices.infrastructure.persistence.model.productprice;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductPricePO {
    private Integer productId;
    private Integer brandId;
    private Double price;
    private String currency;
    private Integer priceListId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Integer priority;
}
