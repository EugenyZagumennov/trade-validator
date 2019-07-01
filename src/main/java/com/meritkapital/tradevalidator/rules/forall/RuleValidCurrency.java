package com.meritkapital.tradevalidator.rules.forall;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.enums.Currency;
import com.meritkapital.tradevalidator.core.exceptions.ruleexceptions.RuleException;
import com.meritkapital.tradevalidator.rules.AbstractRule;

import java.util.HashSet;
import java.util.Set;

public class RuleValidCurrency extends AbstractRule {
    private Set<Currency> validCurrencies;

    public RuleValidCurrency() {
        validCurrencies = new HashSet<>();
        validCurrencies.add(Currency.EUR);
        validCurrencies.add(Currency.USD);
    }

    @Override
    public void apply(RequestEntity entity) throws RuleException {
        if(!validCurrencies.contains(entity.getCcyFirst()) ||
           !validCurrencies.contains(entity.getCcySecond()))
        {
            throwRuleException("Invalid currency!");
        }
    }
}
