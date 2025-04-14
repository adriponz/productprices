package com.backend.productprices.domain.repository;

import com.backend.productprices.domain.entity.ProductPrice;
import com.backend.productprices.domain.entity.ProductPriceSearchCriteria;

import java.util.List;

public interface SearchProductPriceRepository {
    List<ProductPrice> getByCriteria(ProductPriceSearchCriteria criteria);
}
