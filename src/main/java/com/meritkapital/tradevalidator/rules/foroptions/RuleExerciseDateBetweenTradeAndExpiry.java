package com.meritkapital.tradevalidator.rules.foroptions;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.enums.Style;
import com.meritkapital.tradevalidator.core.exceptions.ruleexceptions.RuleException;
import com.meritkapital.tradevalidator.rules.AbstractRule;

import java.time.LocalDate;

public class RuleExerciseDateBetweenTradeAndExpiry extends AbstractRule {
    @Override
    public void apply(RequestEntity entity) throws RuleException {
        if(entity.getStyle() != Style.AMERICAN){
            return;
        }

        LocalDate exerciseDate = entity.getExcerciseStartDate();
        LocalDate tradeDate = entity.getTradeDate();
        LocalDate expireDate = entity.getExpiryDate();

        if(exerciseDate == null){
            throwRuleException("Exercise date cannot be null!");
        }
        if(tradeDate == null){
            throwRuleException("Trade date cannot be null!");
        }
        if(expireDate == null){
            throwRuleException("Expire date cannot be null!");
        }

        if(!validateExerciseDate(exerciseDate, tradeDate, expireDate)){
            throwRuleException("Exercise date should be after trade date and before expiry date!");
        }

    }

    private boolean validateExerciseDate(LocalDate exerciseDate, LocalDate tradeDate, LocalDate expireDate){
        return exerciseDate.isAfter(tradeDate) && exerciseDate.isBefore(expireDate);
    }
}
