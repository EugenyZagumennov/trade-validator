package com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions;

public class MappingException extends RuntimeException {
    public MappingException(String message) {
        super("MappingException: "+message);
    }
}
