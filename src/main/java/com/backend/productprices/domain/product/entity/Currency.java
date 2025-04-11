package com.backend.productprices.domain.product.entity;

public enum Currency {
    EURO("EUR");

    private final String code;

    Currency(String code) {
        this.code = code;
    }
}
