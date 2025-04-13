package com.backend.productprices.infrastructure.persistence.repository;

import com.backend.productprices.domain.entity.Currency;
import com.backend.productprices.domain.entity.Price;
import com.backend.productprices.domain.entity.Pricing;
import com.backend.productprices.domain.entity.PricingPeriod;
import com.backend.productprices.domain.entity.Product;
import com.backend.productprices.domain.entity.ProductPrice;
import com.backend.productprices.infrastructure.persistence.model.ProductPricePO;

final class ProductPriceMapper {
    static ProductPrice getFromPersistence(ProductPricePO productPricePO) {
        final var product = new Product(productPricePO.getProductId(), productPricePO.getBrandId());
        final var price = new Price(productPricePO.getPrice(), Currency.of(productPricePO.getCurrency()));
        final var period = new PricingPeriod(productPricePO.getStartDate(), productPricePO.getEndDate());
        final var pricing = new Pricing(productPricePO.getPriceListId(), period, productPricePO.getPriority());
        return new ProductPrice(product, price, pricing);
    }
}
