package com.backend.productprices.infrastructure.entrypoint.api.productprice;

import com.backend.productprices.application.productprice.search.SearchProductPrice;
import com.backend.productprices.application.productprice.search.dto.ProductPriceDTO;
import com.backend.productprices.application.productprice.search.dto.ProductPriceSearchCriteriaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
@Tag(name = "Prices Query Controller", description = "Controller to query prices")
final class QueryProductPriceController {
    private final SearchProductPrice searchProductPrice;

    QueryProductPriceController(SearchProductPrice searchProductPrice) {
        this.searchProductPrice = searchProductPrice;
    }

    @GetMapping
    @Operation(summary = "Get price by criteria", description = "Allows you to query the product's price at a specific time")
    public ProductPriceDTO getByCriteria(@ModelAttribute ProductPriceSearchCriteriaDTO criteria) {
        return searchProductPrice.searchProductPrice(criteria);
    }
}
