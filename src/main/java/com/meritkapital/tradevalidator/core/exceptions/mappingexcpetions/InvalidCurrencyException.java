package com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions;

public class InvalidCurrencyException extends MappingException {
    public InvalidCurrencyException(String value) {
        super("Value '" + value + "' for currency is invalid!");
    }
}
