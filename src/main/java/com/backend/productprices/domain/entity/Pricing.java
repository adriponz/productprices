package com.backend.productprices.domain.entity;

public record Pricing(Long id, PricingPeriod period, Integer priority) {
}
