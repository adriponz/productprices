package com.backend.productprices.application.productprice.search.dto;

import lombok.Data;

@Data
public class ProductPriceDTO {
    private Integer productId;
    private Integer brandId;
    private PriceDTO price;
    private Integer priceListId;
    private PricingPeriodDTO pricingPeriod;

}
