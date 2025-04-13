package com.backend.productprices.domain.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CurrencyTest {
    @Test
    void should_returnNull_when_codeDoesNotExist() {
        final var result = Currency.of("ERROR");
        Assertions.assertThat(result).isNull();
    }

    @Test
    void should_returnCurrency_when_codeDoesExist() {
        final var result = Currency.of(Currency.EURO.getCode());
        Assertions.assertThat(result).isEqualTo(Currency.EURO);
    }
}