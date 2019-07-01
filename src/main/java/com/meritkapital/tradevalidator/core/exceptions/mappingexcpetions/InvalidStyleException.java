package com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions;

public class InvalidStyleException extends MappingException{
    public InvalidStyleException(String value) {
        super("Value '" + value + "' for style is invalid!");
    }
}
