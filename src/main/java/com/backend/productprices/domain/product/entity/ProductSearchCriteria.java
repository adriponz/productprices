package com.backend.productprices.domain.product.entity;

import java.time.LocalDateTime;

public record ProductSearchCriteria(Integer productId, Integer brandId, LocalDateTime date) {
}
