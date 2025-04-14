package com.backend.productprices.infrastructure.persistence.repository;

import com.backend.productprices.domain.entity.ProductPriceSearchCriteria;
import com.backend.productprices.infrastructure.persistence.dao.ProductPriceDAO;
import com.backend.productprices.utils.ProductPriceUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class SearchProductPriceRepositoryImplTest {
    @InjectMocks
    private SearchProductPriceRepositoryImpl searchProductPriceRepository;
    @Mock
    private ProductPriceDAO productPriceDAO;

    @Test
    void should_returnResult_when_getByCriteria() {
        final var productPricePO = ProductPriceUtils.getDefaultPersistence();
        final var criteria = new ProductPriceSearchCriteria(productPricePO.getProductId(), productPricePO.getBrandId(), LocalDateTime.now());
        BDDMockito.given(productPriceDAO.getByCriteria(criteria)).willReturn(List.of(productPricePO));

        final var result = searchProductPriceRepository.getByCriteria(criteria);

        Assertions.assertThat(result).contains(ProductPriceUtils.getDefaultDomain());
    }

    @Test
    void should_returnEmpty_when_getByCriteria_and_priceNotExists() {
        final var productPricePO = ProductPriceUtils.getDefaultPersistence();
        final var criteria = new ProductPriceSearchCriteria(productPricePO.getProductId(), productPricePO.getBrandId(), LocalDateTime.now());
        BDDMockito.given(productPriceDAO.getByCriteria(criteria)).willReturn(Collections.emptyList());

        final var result = searchProductPriceRepository.getByCriteria(criteria);

        Assertions.assertThat(result).isEmpty();
    }
}