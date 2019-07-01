package com.meritkapital.tradevalidator.rules.forall;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.exceptions.ruleexceptions.RuleException;
import com.meritkapital.tradevalidator.rules.AbstractRule;

import java.time.LocalDate;

public class RuleValueDateAfterOrEqualTradeDate extends AbstractRule {

    @Override
    public void apply(RequestEntity e) throws RuleException {
        LocalDate valueDate = e.getValueDate();

        if(valueDate == null){
            throwRuleException("Value date cannot be null!");
        }

        if(valueDate.isBefore(e.getTradeDate())){
            throwRuleException("Value date cannot be before trade date!");
        }
    }
}
