package com.backend.productprices.infrastructure.entrypoint.api;

import com.backend.productprices.application.search.SearchProductPrice;
import com.backend.productprices.application.search.dto.ProductPriceDTO;
import com.backend.productprices.application.search.dto.ProductPriceSearchCriteriaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Tag(name = "Prices Query Controller", description = "Controller to query prices")
final class QueryProductPriceController {
    private final SearchProductPrice searchProductPrice;

    QueryProductPriceController(SearchProductPrice searchProductPrice) {
        this.searchProductPrice = searchProductPrice;
    }

    @GetMapping("/brands/{brandId}/products/{productId}/price")
    @Operation(summary = "Get product price by date", description = "Allows you to query the product's price at a specific time")
    public ProductPriceDTO getPrice(@PathVariable Long productId, @PathVariable Long brandId, @RequestParam LocalDateTime date) {
        return searchProductPrice.searchProductPrice(new ProductPriceSearchCriteriaDTO(productId, brandId, date));
    }
}
