package com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions;

/**
 * Exception for invalid directions
 *
 * @author Evgenii Zagumennov
 */
public class InvalidDirectionException extends MappingException{
    public InvalidDirectionException(String value) {
        super("Value '" + value + "' for direction is invalid!");
    }
}
