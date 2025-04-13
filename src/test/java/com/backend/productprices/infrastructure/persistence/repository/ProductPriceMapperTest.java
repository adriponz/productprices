package com.backend.productprices.infrastructure.persistence.repository;

import com.backend.productprices.utils.ProductPriceUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ProductPriceMapperTest {
    @Test
    void should_transformTo_ProductPrice_from_ProductPricePO() {
        final var productPricePO = ProductPriceUtils.getDefaultPersistence();

        final var result = ProductPriceMapper.getFromPersistence(productPricePO);

        Assertions.assertThat(result.product().id()).isEqualTo(productPricePO.getProductId());
        Assertions.assertThat(result.product().brandId()).isEqualTo(productPricePO.getBrandId());
        Assertions.assertThat(result.price().amount()).isEqualTo(productPricePO.getPrice());
        Assertions.assertThat(result.price().currency().getCode()).isEqualTo(productPricePO.getCurrency());
        Assertions.assertThat(result.pricing().id()).isEqualTo(productPricePO.getPriceListId());
        Assertions.assertThat(result.pricing().priority()).isEqualTo(productPricePO.getPriority());
        Assertions.assertThat(result.pricing().period().startDate()).isEqualTo(productPricePO.getStartDate());
        Assertions.assertThat(result.pricing().period().endDate()).isEqualTo(productPricePO.getEndDate());
    }
}