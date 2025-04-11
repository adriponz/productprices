package com.backend.productprices.domain.product.repository;

import com.backend.productprices.domain.product.entity.ProductPrice;
import com.backend.productprices.domain.product.entity.ProductSearchCriteria;

import java.util.Optional;

public interface SearchProductRepository {
    Optional<ProductPrice> getByCriteria(ProductSearchCriteria criteria);
}
