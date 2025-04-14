package com.backend.productprices.shared.utils;

import com.backend.productprices.domain.exception.DomainException;
import com.backend.productprices.shared.message.KeyMessageSource;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class DateUtils {
    private static final List<DateTimeFormatter> FORMATTERS = List.of(
            DateTimeFormatter.ISO_DATE_TIME,
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"),
            DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"),
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"),
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")
    );

    public static LocalDateTime toLocalDateTime(String source) {
        if (source == null) {
            return null;
        }

        String date = source.trim();

        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                return LocalDateTime.parse(date, formatter);
            } catch (Exception ignored) {}
        }

        try {
            return OffsetDateTime.parse(date).toLocalDateTime();
        } catch (Exception ignored) {}

        try {
            return ZonedDateTime.parse(date).toLocalDateTime();
        } catch (Exception ignored) {}

        throw new DomainException(KeyMessageSource.INVALID_DATE_FORMAT);
    }
}
