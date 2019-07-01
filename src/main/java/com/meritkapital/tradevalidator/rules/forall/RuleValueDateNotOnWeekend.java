package com.meritkapital.tradevalidator.rules.forall;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.exceptions.ruleexceptions.RuleException;
import com.meritkapital.tradevalidator.rules.AbstractRule;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class RuleValueDateNotOnWeekend extends AbstractRule {

    @Override
    public void apply(RequestEntity entity) throws RuleException {
        LocalDate valueDate = entity.getValueDate();

        if(valueDate == null){
            throwRuleException("Value date cannot be null!");
        }

        DayOfWeek valueDayOfWeek = entity.getValueDate().getDayOfWeek();

        if(valueDayOfWeek == DayOfWeek.SATURDAY || valueDayOfWeek == DayOfWeek.SUNDAY){
            throwRuleException("Value date cannot fall on weekend");
        }
    }
}
