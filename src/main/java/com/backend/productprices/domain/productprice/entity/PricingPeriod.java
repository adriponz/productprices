package com.backend.productprices.domain.productprice.entity;

import java.time.LocalDateTime;

public record PricingPeriod(LocalDateTime startDate, LocalDateTime endDate) {
}
