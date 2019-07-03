package com.meritkapital.tradevalidator.rules;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper for a bundle of some rules
 *
 * @author Evgenii Zagumennov
 */
@Builder
public class RulesBundle {
    private RequestEntity object;
    private AbstractRule[] rules;

    public List<String> applyRules(){
        List<String> messages = new ArrayList<>();

        for(AbstractRule rule: rules) {
            try {
                rule.apply(object);
            }catch (Exception e){
                messages.add(e.getMessage());
            }
        }

        return messages;
    }
}
