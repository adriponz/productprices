package com.backend.productprices.domain.productprice.entity;

public enum Currency {
    EURO("EUR");

    private final String code;

    Currency(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
