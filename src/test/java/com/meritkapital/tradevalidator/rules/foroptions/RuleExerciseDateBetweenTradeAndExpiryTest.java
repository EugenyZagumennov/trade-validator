package com.meritkapital.tradevalidator.rules.foroptions;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.enums.Style;
import com.meritkapital.tradevalidator.core.exceptions.ruleexceptions.RuleException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleExerciseDateBetweenTradeAndExpiryTest {

    @Test
    public void testRuleExerciseDateBetweenTradeAndExpirySuccess(){
        RuleExerciseDateBetweenTradeAndExpiry rule = new RuleExerciseDateBetweenTradeAndExpiry();
        RequestEntity entity = RequestEntity.builder()
                .style(Style.AMERICAN)
                .excerciseStartDate(LocalDate.of(2017, 8, 15))
                .tradeDate(LocalDate.of(2017, 8, 11))
                .expiryDate(LocalDate.of(2017, 8, 20))
                .build();

        rule.apply(entity);
    }

    @Test(expected = RuleException.class)
    public void testRuleExerciseDateBetweenTradeAndExpiryFail(){
        RuleExerciseDateBetweenTradeAndExpiry rule = new RuleExerciseDateBetweenTradeAndExpiry();
        RequestEntity entity = RequestEntity.builder()
                .style(Style.AMERICAN)
                .excerciseStartDate(LocalDate.of(2017, 8, 11))
                .tradeDate(LocalDate.of(2017, 8, 11))
                .expiryDate(LocalDate.of(2017, 8, 20))
                .build();

        rule.apply(entity);
    }
}
