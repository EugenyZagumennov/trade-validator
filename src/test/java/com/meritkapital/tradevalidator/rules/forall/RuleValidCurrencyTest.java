package com.meritkapital.tradevalidator.rules.forall;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.enums.Currency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleValidCurrencyTest {

    @Test
    public void testRuleValidCurrency(){
        RuleValidCurrency rule = new RuleValidCurrency();

        for(Currency curr: Currency.values()) {
            RequestEntity entity =
                    RequestEntity.builder()
                            .ccyFirst(curr)
                            .ccySecond(curr)
                            .build();

            rule.apply(entity);
        }
    }
}
