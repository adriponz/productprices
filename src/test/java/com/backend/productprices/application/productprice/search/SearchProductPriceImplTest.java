package com.backend.productprices.application.productprice.search;

import com.backend.productprices.application.productprice.search.dto.ProductPriceSearchCriteriaDTO;
import com.backend.productprices.domain.productprice.entity.ProductPriceSearchCriteria;
import com.backend.productprices.domain.productprice.exception.ResourceNotFoundException;
import com.backend.productprices.domain.productprice.repository.SearchProductPriceRepository;
import com.backend.productprices.utils.ProductPriceUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class SearchProductPriceImplTest {
    @InjectMocks
    private SearchProductPriceImpl searchProductPrices;
    @Mock
    private SearchProductPriceRepository searchProductPriceRepository;

    @Test
    void should_throwError_when_productPriceNotExist() {
        final var criteriaDTO = new ProductPriceSearchCriteriaDTO();
        criteriaDTO.setProductId(1);
        criteriaDTO.setBrandId(1);
        criteriaDTO.setDate(LocalDateTime.now());
        final var criteria = new ProductPriceSearchCriteria(criteriaDTO.getProductId(), criteriaDTO.getBrandId(), criteriaDTO.getDate());
        BDDMockito.given(searchProductPriceRepository.getByCriteria(criteria)).willReturn(Optional.empty());

        final var expectedThrow = Assertions.catchThrowable(() -> searchProductPrices.searchProductPrice(criteriaDTO));

        Assertions.assertThat(expectedThrow).isInstanceOf(ResourceNotFoundException.class)
                .hasMessage("Price not found");
    }

    @Test
    void should_returnResult_when_searchProductPrice() {
        final var productPrice = ProductPriceUtils.getDefaultDomain();
        final var criteriaDTO = new ProductPriceSearchCriteriaDTO();
        criteriaDTO.setProductId(productPrice.product().id());
        criteriaDTO.setBrandId(productPrice.product().brandId());
        criteriaDTO.setDate(LocalDateTime.now());
        final var criteria = new ProductPriceSearchCriteria(criteriaDTO.getProductId(), criteriaDTO.getBrandId(), criteriaDTO.getDate());
        BDDMockito.given(searchProductPriceRepository.getByCriteria(criteria)).willReturn(Optional.of(productPrice));

        final var result = searchProductPrices.searchProductPrice(criteriaDTO);

        Assertions.assertThat(result).isEqualTo(ProductPriceUtils.getDefaultDTO());
    }
}