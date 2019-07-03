package com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions;

/**
 * Super class for exceptions for mappings
 *
 * @author Evgenii Zagumennov
 */
public class MappingException extends RuntimeException {
    public MappingException(String message) {
        super("MappingException: "+message);
    }
}
