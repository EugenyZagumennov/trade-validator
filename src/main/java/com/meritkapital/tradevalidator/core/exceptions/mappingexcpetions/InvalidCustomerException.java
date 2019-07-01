package com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions;

public class InvalidCustomerException extends MappingException {
    public InvalidCustomerException(String value) {
        super("Value '" + value + "' for customer is invalid!");
    }
}
