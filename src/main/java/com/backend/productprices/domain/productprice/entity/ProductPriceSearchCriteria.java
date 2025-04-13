package com.backend.productprices.domain.productprice.entity;

import com.backend.productprices.shared.message.KeyMessageSource;
import com.backend.productprices.domain.productprice.exception.DomainException;

import java.time.LocalDateTime;

public record ProductPriceSearchCriteria(Long productId, Long brandId, LocalDateTime date) {
    public ProductPriceSearchCriteria {
        if (productId == null) {
            throw new DomainException(KeyMessageSource.PRODUCT_ID_IS_REQUIRED);
        }
        if (brandId == null) {
            throw new DomainException(KeyMessageSource.BRAND_ID_IS_REQUIRED);
        }
        if (date == null) {
            throw new DomainException(KeyMessageSource.DATE_IS_REQUIRED);
        }
    }
}
