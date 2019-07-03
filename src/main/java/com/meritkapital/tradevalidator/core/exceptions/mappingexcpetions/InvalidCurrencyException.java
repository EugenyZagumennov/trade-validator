package com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions;

/**
 * Exception for invalid currencies
 *
 * @author Evgenii Zagumennov
 */
public class InvalidCurrencyException extends MappingException {
    public InvalidCurrencyException(String value) {
        super("Value '" + value + "' for currency is invalid!");
    }
}
