package com.backend.productprices.domain.entity;

import java.time.LocalDateTime;

public record PricingPeriod(LocalDateTime startDate, LocalDateTime endDate) {
}
