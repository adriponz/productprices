package com.backend.productprices.utils;

import com.backend.productprices.application.search.dto.PriceDTO;
import com.backend.productprices.application.search.dto.PricingPeriodDTO;
import com.backend.productprices.application.search.dto.ProductPriceDTO;
import com.backend.productprices.domain.entity.Currency;
import com.backend.productprices.domain.entity.Price;
import com.backend.productprices.domain.entity.Pricing;
import com.backend.productprices.domain.entity.PricingPeriod;
import com.backend.productprices.domain.entity.Product;
import com.backend.productprices.domain.entity.ProductPrice;
import com.backend.productprices.infrastructure.persistence.model.ProductPricePO;

import java.time.LocalDateTime;

public class ProductPriceUtils {

    private static final Long PRODUCT_ID = 1L;
    private static final Long BRAND_ID = 1L;
    private static final Long PRICE_LIST_ID = 1L;
    private static final Double PRICE_AMOUNT = 1.2D;
    private static final Currency PRICE_CURRENCY = Currency.EURO;
    private static final Integer PRIORITY = 1;
    private static final LocalDateTime START_DATE = LocalDateTime.now();
    private static final LocalDateTime END_DATE = LocalDateTime.now().plusMonths(1);

    public static ProductPrice getDefaultDomain() {
        final var product = new Product(PRODUCT_ID, BRAND_ID);
        final var price = new Price(PRICE_AMOUNT, PRICE_CURRENCY);
        final var period = new PricingPeriod(START_DATE, END_DATE);
        final var pricing = new Pricing(PRICE_LIST_ID, period, PRIORITY);
        return new ProductPrice(product, price, pricing);
    }

    public static ProductPriceDTO getDefaultDTO() {
        final var productPriceDTO = new ProductPriceDTO();
        productPriceDTO.setProductId(PRODUCT_ID);
        productPriceDTO.setBrandId(BRAND_ID);
        productPriceDTO.setPriceListId(PRICE_LIST_ID);
        productPriceDTO.setPrice(new PriceDTO(PRICE_AMOUNT, PRICE_CURRENCY.getCode()));
        productPriceDTO.setPricingPeriod(new PricingPeriodDTO(START_DATE, END_DATE));
        return productPriceDTO;
    }

    public static ProductPricePO getDefaultPersistence() {
        final var productPricePO = new ProductPricePO();
        productPricePO.setProductId(PRODUCT_ID);
        productPricePO.setBrandId(BRAND_ID);
        productPricePO.setPriceListId(PRICE_LIST_ID);
        productPricePO.setPrice(PRICE_AMOUNT);
        productPricePO.setCurrency(PRICE_CURRENCY.getCode());
        productPricePO.setStartDate(START_DATE);
        productPricePO.setEndDate(END_DATE);
        productPricePO.setPriority(PRIORITY);
        return productPricePO;
    }
}
