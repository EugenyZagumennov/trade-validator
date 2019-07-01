package com.meritkapital.tradevalidator.core.entities;

import com.meritkapital.tradevalidator.core.enums.*;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class RequestEntity {
    private Integer id;
    private Customer customer;
    private Currency ccyFirst;
    private Currency ccySecond;
    private Type type;
    private Direction direction;
    private LocalDate tradeDate;
    private BigDecimal amount1;
    private BigDecimal amount2;
    private Double rate;
    private LocalDate valueDate;
    private String legalEntity;
    private String trader;
    private Style style;
    private LocalDate deliveryDate;
    private LocalDate expiryDate;
    private Double premium;
    private Currency premiumCcy;
    private String premiumType;
    private LocalDate premiumDate;
    private LocalDate excerciseStartDate;
    private String strategy;
    private Currency payCcy;
}
