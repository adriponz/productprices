package com.backend.productprices.application.productprice.search.dto;

import lombok.Data;

@Data
public class ProductPriceDTO {
    private Long productId;
    private Long brandId;
    private PriceDTO price;
    private Long priceListId;
    private PricingPeriodDTO pricingPeriod;

}
