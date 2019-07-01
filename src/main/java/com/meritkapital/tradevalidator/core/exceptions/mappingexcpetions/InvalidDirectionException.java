package com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions;

public class InvalidDirectionException extends MappingException{
    public InvalidDirectionException(String value) {
        super("Value '" + value + "' for direction is invalid!");
    }
}
