package com.backend.productprices.application.productprice.search;

import com.backend.productprices.application.productprice.search.dto.PriceDTO;
import com.backend.productprices.application.productprice.search.dto.PricingPeriodDTO;
import com.backend.productprices.application.productprice.search.dto.ProductPriceDTO;
import com.backend.productprices.domain.productprice.entity.ProductPrice;

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
