package com.backend.productprices.application.productprice.search;

import com.backend.productprices.application.productprice.search.dto.ProductPriceDTO;
import com.backend.productprices.application.productprice.search.dto.ProductPriceSearchCriteriaDTO;

public interface SearchProductPrice {
    ProductPriceDTO searchProductPrice(ProductPriceSearchCriteriaDTO criteriaDTO);
}
