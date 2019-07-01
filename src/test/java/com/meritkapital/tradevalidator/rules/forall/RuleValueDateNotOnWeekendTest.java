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
public class RuleValueDateNotOnWeekendTest {

    @Test
    public void testRuleValueDateNotOnWeekendSuccess(){
        RuleValueDateNotOnWeekend rule = new RuleValueDateNotOnWeekend();
        RequestEntity entity = RequestEntity.builder()
                .valueDate(LocalDate.of(2017,8, 21)) //MONDAY
                .build();

        rule.apply(entity);
    }

    @Test(expected = RuleException.class)
    public void testRuleValueDateNotOnWeekendFail(){
        RuleValueDateNotOnWeekend rule = new RuleValueDateNotOnWeekend();
        RequestEntity entity = RequestEntity.builder()
                .valueDate(LocalDate.of(2017,8, 20)) //SUNDAY
                .build();

        rule.apply(entity);
    }
}
