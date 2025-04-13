package com.backend.productprices.domain.entity;

public enum Currency {
    EURO("EUR");

    private final String code;

    Currency(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static Currency of(String code) {
        if (code != null) {
            for (Currency type : Currency.values()) {
                if (type.code.equals(code))
                    return type;
            }
        }
        return null;
    }
}
