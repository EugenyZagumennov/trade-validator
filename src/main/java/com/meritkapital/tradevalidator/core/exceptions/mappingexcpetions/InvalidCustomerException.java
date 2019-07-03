package com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions;

/**
 * Exception for invalid customers
 *
 * @author Evgenii Zagumennov
 */
public class InvalidCustomerException extends MappingException {
    public InvalidCustomerException(String value) {
        super("Value '" + value + "' for customer is invalid!");
    }
}
