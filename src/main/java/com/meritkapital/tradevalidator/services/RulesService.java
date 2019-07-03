package com.meritkapital.tradevalidator.services;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.rules.AbstractRule;
import com.meritkapital.tradevalidator.rules.RulesBundle;
import com.meritkapital.tradevalidator.rules.forall.RuleValidCurrency;
import com.meritkapital.tradevalidator.rules.forall.RuleValidCustomer;
import com.meritkapital.tradevalidator.rules.forall.RuleValueDateAfterOrEqualTradeDate;
import com.meritkapital.tradevalidator.rules.forall.RuleValueDateNotOnWeekend;
import com.meritkapital.tradevalidator.rules.foroptions.RuleExpirePremiumDeliveryDates;
import com.meritkapital.tradevalidator.rules.foroptions.RuleStyleEuropeanOrAmerican;
import com.meritkapital.tradevalidator.rules.foroptions.RuleExerciseDateBetweenTradeAndExpiry;
import com.meritkapital.tradevalidator.rules.forspotandforward.RuleValidValueDateForSpotAndForward;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.meritkapital.tradevalidator.core.enums.Type.*;

/**
 * Service which applies rules for a {@link RequestEntity}
 *
 * @author Evgenii Zagumennov
 */
@Service
public class RulesService {
    private AbstractRule[] rulesForAll = {
            new RuleValueDateAfterOrEqualTradeDate(),
            new RuleValueDateNotOnWeekend(),
            new RuleValidCustomer(),
            new RuleValidCurrency()
    };

    private AbstractRule[] rulesForSpotAndForward = {
        new RuleValidValueDateForSpotAndForward()
    };

    private AbstractRule[] rulesForOptions = {
        new RuleStyleEuropeanOrAmerican(),
        new RuleExerciseDateBetweenTradeAndExpiry(),
        new RuleExpirePremiumDeliveryDates()
    };

    public List<String> applyRules(RequestEntity entity){
        List<String> result  = new ArrayList<>();
        result.addAll(applyRulesArray(entity, rulesForAll));

        if(FXSPOT == entity.getType() || FORWARD == entity.getType()){
            result.addAll(applyRulesArray(entity, rulesForSpotAndForward));
        }

        if(OPTION == entity.getType()){
            result.addAll(applyRulesArray(entity, rulesForOptions));
        }

        return result;
    }

    private List<String> applyRulesArray(RequestEntity entity, AbstractRule[] rules){
        return RulesBundle.builder()
                   .object(entity)
                   .rules(rules)
                   .build()
                   .applyRules();
    }
}
