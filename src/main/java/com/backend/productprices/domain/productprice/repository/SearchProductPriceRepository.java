package com.backend.productprices.domain.productprice.repository;

import com.backend.productprices.domain.productprice.entity.ProductPrice;
import com.backend.productprices.domain.productprice.entity.ProductPriceSearchCriteria;

import java.util.Optional;

public interface SearchProductPriceRepository {
    Optional<ProductPrice> getByCriteria(ProductPriceSearchCriteria criteria);
}
