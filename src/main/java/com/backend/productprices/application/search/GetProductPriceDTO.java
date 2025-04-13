package com.backend.productprices.application.search;

import com.backend.productprices.application.search.dto.PriceDTO;
import com.backend.productprices.application.search.dto.PricingPeriodDTO;
import com.backend.productprices.application.search.dto.ProductPriceDTO;
import com.backend.productprices.domain.entity.ProductPrice;

final class GetProductPriceDTO {
    static ProductPriceDTO toDTO(ProductPrice productPrice) {

        final var productPriceDTO = new ProductPriceDTO();
        productPriceDTO.setProductId(productPrice.product().id());
        productPriceDTO.setBrandId(productPrice.product().brandId());
        productPriceDTO.setPriceListId(productPrice.pricing().id());
        productPriceDTO.setPrice(new PriceDTO(productPrice.price().amount(), productPrice.price().currency().getCode()));
        productPriceDTO.setPricingPeriod(new PricingPeriodDTO(productPrice.pricing().period().startDate(), productPrice.pricing().period().endDate()));
        return productPriceDTO;
    }
}
