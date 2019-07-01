package com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions;

public class InvalidTypeException extends MappingException {
    public InvalidTypeException(String value) {
        super("Value '" + value + "' for type is invalid!");
    }
}
