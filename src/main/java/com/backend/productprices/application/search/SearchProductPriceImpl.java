package com.backend.productprices.application.search;

import com.backend.productprices.application.search.dto.ProductPriceDTO;
import com.backend.productprices.application.search.dto.ProductPriceSearchCriteriaDTO;
import com.backend.productprices.shared.message.KeyMessageSource;
import com.backend.productprices.domain.entity.ProductPriceSearchCriteria;
import com.backend.productprices.domain.exception.ResourceNotFoundException;
import com.backend.productprices.domain.repository.SearchProductPriceRepository;
import org.springframework.stereotype.Service;

@Service
final class SearchProductPriceImpl implements SearchProductPrice {
    private final SearchProductPriceRepository searchProductPriceRepository;

    SearchProductPriceImpl(SearchProductPriceRepository searchProductPriceRepository) {
        this.searchProductPriceRepository = searchProductPriceRepository;
    }

    @Override
    public ProductPriceDTO searchProductPrice(ProductPriceSearchCriteriaDTO criteriaDTO) {
        final var criteria = new ProductPriceSearchCriteria(criteriaDTO.getProductId(), criteriaDTO.getBrandId(), criteriaDTO.getDate());
        final var productPrice = searchProductPriceRepository.getByCriteria(criteria)
                .orElseThrow(() -> new ResourceNotFoundException(KeyMessageSource.PRICE_NOT_FOUND));
        return GetProductPriceDTO.toDTO(productPrice);
    }
}
