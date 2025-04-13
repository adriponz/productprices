package com.backend.productprices.application.search;

import com.backend.productprices.utils.ProductPriceUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GetProductPriceDTOTest {

    @Test
    void should_transformTo_ProductPriceDTO_from_ProductPrice() {
        final var productPrice = ProductPriceUtils.getDefaultDomain();

        final var result = GetProductPriceDTO.toDTO(productPrice);

        Assertions.assertThat(result.getProductId()).isEqualTo(productPrice.product().id());
        Assertions.assertThat(result.getBrandId()).isEqualTo(productPrice.product().brandId());
        Assertions.assertThat(result.getPriceListId()).isEqualTo(productPrice.pricing().id());
        Assertions.assertThat(result.getPrice().getAmount()).isEqualTo(productPrice.price().amount());
        Assertions.assertThat(result.getPrice().getCurrency()).isEqualTo(productPrice.price().currency().getCode());
        Assertions.assertThat(result.getPricingPeriod().getStartDate()).isEqualTo(productPrice.pricing().period().startDate());
        Assertions.assertThat(result.getPricingPeriod().getEndDate()).isEqualTo(productPrice.pricing().period().endDate());
    }
}