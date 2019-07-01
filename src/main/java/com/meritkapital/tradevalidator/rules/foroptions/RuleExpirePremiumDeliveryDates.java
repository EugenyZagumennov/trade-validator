package com.meritkapital.tradevalidator.rules.foroptions;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.exceptions.ruleexceptions.RuleException;
import com.meritkapital.tradevalidator.rules.AbstractRule;

import java.time.LocalDate;

public class RuleExpirePremiumDeliveryDates extends AbstractRule {

    @Override
    public void apply(RequestEntity entity) throws RuleException {
        LocalDate premiumDate = entity.getPremiumDate();
        LocalDate deliveryDate = entity.getDeliveryDate();
        LocalDate expireDate = entity.getExpiryDate();

        if(premiumDate == null){
            throwRuleException("Premium date cannot be null!");
        }
        if(deliveryDate == null){
            throwRuleException("Delivery date cannot be null!");
        }
        if(expireDate == null){
            throwRuleException("Expire date cannot be null!");
        }

        if(!validateExpireAndPremiumDates(expireDate, premiumDate, deliveryDate)){
            throwRuleException("Exercise date should be after trade date and before expire date!");
        }

    }

    private boolean validateExpireAndPremiumDates(LocalDate expireDate, LocalDate premiumDate, LocalDate deliveryDate){
        return expireDate.isBefore(deliveryDate) && premiumDate.isBefore(deliveryDate);
    }
}
