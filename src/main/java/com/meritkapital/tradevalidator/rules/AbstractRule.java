package com.meritkapital.tradevalidator.rules;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.exceptions.ruleexceptions.RuleException;

/**
 * Super class for rules
 *
 * @author Evgenii Zagumennov
 */
public abstract class AbstractRule {
    protected void throwRuleException(String message){
        throw new RuleException(String.format("%s: %s", this.getClass().getSimpleName(), message));
    }

    public abstract void apply(RequestEntity entity) throws RuleException;
}
