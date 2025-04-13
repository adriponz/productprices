package com.backend.productprices.application.search.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PricingPeriodDTO {
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
