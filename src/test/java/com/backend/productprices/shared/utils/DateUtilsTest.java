package com.backend.productprices.shared.utils;

import com.backend.productprices.domain.exception.DomainException;
import com.backend.productprices.shared.message.KeyMessageSource;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class DateUtilsTest {

    @Test
    void should_throwError_when_formatIsIncorrect() {
        final var expectedThrow = Assertions.catchThrowable(() -> DateUtils.toLocalDateTime("2020"));

        Assertions.assertThat(expectedThrow).isInstanceOf(DomainException.class)
                .hasMessage(KeyMessageSource.INVALID_DATE_FORMAT);
    }

    @Test
    void should_returnNull_when_sourceIsNull() {
        final var result = DateUtils.toLocalDateTime(null);

        Assertions.assertThat(result).isNull();
    }

    @Test
    void should_createLocalDateTime() {
        final var expected = LocalDateTime.of(2020, 6, 16, 21, 0, 0);
        final var result = DateUtils.toLocalDateTime("2020-06-16T21:00:00");

        Assertions.assertThat(result).isNotNull().isEqualTo(expected);
    }

}