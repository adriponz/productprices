package com.backend.productprices.domain.productprice.entity;

import com.backend.productprices.application.productprice.search.shared.message.KeyMessageSource;
import com.backend.productprices.domain.productprice.exception.DomainException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class ProductPriceSearchCriteriaTest {
    @Test
    void should_throwError_when_productIdIsNull() {
        final var expectedThrow = Assertions.catchThrowable(() -> new ProductPriceSearchCriteria(null, null, null));

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage(KeyMessageSource.DOMAIN_PRODUCT_ID_IS_REQUIRED);
    }

    @Test
    void should_throwError_when_brandIdIsNull() {
        final var id = 1L;
        final var expectedThrow = Assertions.catchThrowable(() -> new ProductPriceSearchCriteria(id, null, null));

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage(KeyMessageSource.DOMAIN_BRAND_ID_IS_REQUIRED);
    }

    @Test
    void should_throwError_when_dateIsInvalid() {
        final var id = 1L;
        final var expectedThrow = Assertions.catchThrowable(() -> new ProductPriceSearchCriteria(id, id, null));

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage(KeyMessageSource.DOMAIN_DATE_IS_REQUIRED);
    }

    @Test
    void should_createTweet() {
        final var productId = 1L;
        final var brandId = 2L;
        final var date = LocalDateTime.now();
        final var criteria = new ProductPriceSearchCriteria(productId, brandId, date);

        Assertions.assertThat(criteria.productId()).isEqualTo(productId);
        Assertions.assertThat(criteria.brandId()).isEqualTo(brandId);
        Assertions.assertThat(criteria.date()).isEqualTo(date);
    }
}