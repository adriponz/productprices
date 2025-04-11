package com.backend.productprices.infrastructure.persistence.repository.productprice;

import com.backend.productprices.domain.productprice.entity.ProductPrice;
import com.backend.productprices.domain.productprice.entity.ProductPriceSearchCriteria;
import com.backend.productprices.domain.productprice.repository.SearchProductPriceRepository;
import com.backend.productprices.infrastructure.persistence.dao.productprice.ProductPriceDAO;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
final class SearchProductPriceRepositoryImpl implements SearchProductPriceRepository {
    private final ProductPriceDAO productPriceDAO;

    SearchProductPriceRepositoryImpl(ProductPriceDAO productPriceDAO) {
        this.productPriceDAO = productPriceDAO;
    }

    @Override
    public Optional<ProductPrice> getByCriteria(ProductPriceSearchCriteria criteria) {
        return productPriceDAO.getByCriteria(criteria).map(ProductPriceMapper::getFromPersistence);
    }
}
