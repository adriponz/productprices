package com.backend.productprices.application.search;

import com.backend.productprices.application.search.dto.ProductPriceDTO;
import com.backend.productprices.application.search.dto.ProductPriceSearchCriteriaDTO;

public interface SearchProductPrice {
    ProductPriceDTO searchProductPrice(ProductPriceSearchCriteriaDTO criteriaDTO);
}
