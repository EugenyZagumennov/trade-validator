package com.meritkapital.tradevalidator.rules.forall;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.exceptions.ruleexceptions.RuleException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleValueDateAfterOrEqualTradeDateTest {

    @Test
    public void testRuleValueDateAfterOrEqualTradeDateSuccess(){
        RuleValueDateAfterOrEqualTradeDate rule = new RuleValueDateAfterOrEqualTradeDate();
        RequestEntity entity = RequestEntity.builder()
                .valueDate(LocalDate.of(2017,8,22))
                .tradeDate(LocalDate.of(2017,8,11))
                .build();

        rule.apply(entity);
    }

    @Test(expected = RuleException.class)
    public void testRuleValueDateAfterOrEqualTradeDateFail(){
        RuleValueDateAfterOrEqualTradeDate rule = new RuleValueDateAfterOrEqualTradeDate();
        RequestEntity entity = RequestEntity.builder()
                .valueDate(LocalDate.of(2017,8,11))
                .tradeDate(LocalDate.of(2017,8,22))
                .build();

        rule.apply(entity);
    }
}
