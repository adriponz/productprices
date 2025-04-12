package com.backend.productprices.infrastructure.entrypoint.api.productprice;

import com.backend.productprices.application.productprice.search.SearchProductPrice;
import com.backend.productprices.application.productprice.search.dto.ProductPriceDTO;
import com.backend.productprices.application.productprice.search.dto.ProductPriceSearchCriteriaDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
final class QueryProductPriceController {
    private final SearchProductPrice searchProductPrice;

    QueryProductPriceController(SearchProductPrice searchProductPrice) {
        this.searchProductPrice = searchProductPrice;
    }

    @GetMapping
    public ProductPriceDTO getByCriteria(@ModelAttribute ProductPriceSearchCriteriaDTO criteria) {
        return searchProductPrice.searchProductPrice(criteria);
    }
}
