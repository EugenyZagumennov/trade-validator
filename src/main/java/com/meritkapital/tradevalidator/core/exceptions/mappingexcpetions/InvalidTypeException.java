package com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions;

/**
 * Exception for invalid types
 *
 * @author Evgenii Zagumennov
 */
public class InvalidTypeException extends MappingException {
    public InvalidTypeException(String value) {
        super("Value '" + value + "' for type is invalid!");
    }
}
