package com.meritkapital.tradevalidator.core.exceptions.ruleexceptions;

/**
 * Exception for rules
 *
 * @author Evgenii Zagumennov
 */
public class RuleException extends RuntimeException {
    public RuleException(String message) {
        super(message);
    }
}
