package com.backend.productprices.domain.product.entity;

import java.time.LocalDateTime;

public record PricingPeriod(LocalDateTime startDate, LocalDateTime endDate) {
}
