package com.meritkapital.tradevalidator.rules.foroptions;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.enums.Style;
import com.meritkapital.tradevalidator.core.exceptions.ruleexceptions.RuleException;
import com.meritkapital.tradevalidator.rules.AbstractRule;

/**
 * Rule: style should be American or European
 *
 * @author Evgenii Zagumennov
 */
public class RuleStyleEuropeanOrAmerican extends AbstractRule {
    @Override
    public void apply(RequestEntity entity) throws RuleException {
        Style style = entity.getStyle();
        if(style != Style.AMERICAN && style != Style.EUROPEAN){
            throwRuleException("Style should be American or European!");
        }
    }
}
