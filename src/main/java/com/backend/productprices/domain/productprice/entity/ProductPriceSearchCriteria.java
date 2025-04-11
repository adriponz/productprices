package com.backend.productprices.domain.productprice.entity;

import java.time.LocalDateTime;

public record ProductPriceSearchCriteria(Integer productId, Integer brandId, LocalDateTime date) {
}
