package com.meritkapital.tradevalidator.core.dto;

import lombok.Data;

@Data
public class RequestDto {
    private Integer id;
    private String customer;
    private String ccyPair;
    private String type;
    private String direction;
    private String tradeDate;
    private String amount1;
    private String amount2;
    private Double rate;
    private String valueDate;
    private String legalEntity;
    private String trader;
    private String style;
    private String deliveryDate;
    private String expiryDate;
    private Double premium;
    private String premiumCcy;
    private String premiumType;
    private String premiumDate;
    private String excerciseStartDate;
    private String strategy;
    private String payCcy;
}
