package com.meritkapital.tradevalidator.core.enums;

import com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions.InvalidCurrencyException;

/**
 * Supported currencies
 *
 * @author Evgenii Zagumennov
 */
public enum Currency {
    EUR("EUR"), USD("USD");

    private String name;

    Currency(String name) {
        this.name = name;
    }

    public static Currency parse(String str){
        if(str == null){
            return null;
        }

        switch (str){
            case "EUR": return EUR;
            case "USD": return USD;
            default: throw new InvalidCurrencyException(str);
        }
    }
}
