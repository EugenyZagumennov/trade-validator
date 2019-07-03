package com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions;

/**
 * Exception for invalid styles
 *
 * @author Evgenii Zagumennov
 */
public class InvalidStyleException extends MappingException{
    public InvalidStyleException(String value) {
        super("Value '" + value + "' for style is invalid!");
    }
}
