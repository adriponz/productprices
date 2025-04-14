package com.backend.productprices.infrastructure.persistence.dao;

import com.backend.productprices.domain.entity.ProductPriceSearchCriteria;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class ProductPriceDAOTest {
    @Autowired
    private ProductPriceDAO productPriceDAO;

    @Test
    void should_returnProductPrice_when_getByCriteria() {
        final var criteria = new ProductPriceSearchCriteria(35455L, 1L, LocalDateTime.of(2020, 6, 14, 16, 0));

        final var result = productPriceDAO.getByCriteria(criteria);

        Assertions.assertThat(result).isNotEmpty();
        result.forEach(productPricePO -> {
            Assertions.assertThat(productPricePO.getProductId()).isEqualTo(35455);
            Assertions.assertThat(productPricePO.getBrandId()).isEqualTo(1L);
            Assertions.assertThat(productPricePO.getStartDate()).isBeforeOrEqualTo(criteria.date());
            Assertions.assertThat(productPricePO.getEndDate()).isAfterOrEqualTo(criteria.date());
        });
    }
}