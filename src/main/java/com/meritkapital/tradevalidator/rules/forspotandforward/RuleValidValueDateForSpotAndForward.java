package com.meritkapital.tradevalidator.rules.forspotandforward;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.exceptions.ruleexceptions.RuleException;
import com.meritkapital.tradevalidator.rules.AbstractRule;

public class RuleValidValueDateForSpotAndForward extends AbstractRule {

    /**
     * Actually, I'm not sure what means "validate the value date against the product type",
     * but I guess thar value date should not be null
     */
    @Override
    public void apply(RequestEntity entity) throws RuleException {
        if(entity.getValueDate() == null){
            throwRuleException("Value date should nor be null!");
        }
    }
}
