package com.backend.productprices.domain.repository;

import com.backend.productprices.domain.entity.ProductPrice;
import com.backend.productprices.domain.entity.ProductPriceSearchCriteria;

import java.util.Optional;

public interface SearchProductPriceRepository {
    Optional<ProductPrice> getByCriteria(ProductPriceSearchCriteria criteria);
}
