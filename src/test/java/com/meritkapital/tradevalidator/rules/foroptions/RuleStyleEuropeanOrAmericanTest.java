package com.meritkapital.tradevalidator.rules.foroptions;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.enums.Style;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleStyleEuropeanOrAmericanTest {

    @Test
    public void testRuleStyleEuropeanOrAmerican(){
        for(Style style: Style.values()) {
            RuleStyleEuropeanOrAmerican rule = new RuleStyleEuropeanOrAmerican();
            RequestEntity entity = RequestEntity.builder()
                    .style(style)
                    .build();

            rule.apply(entity);
        }
    }
}