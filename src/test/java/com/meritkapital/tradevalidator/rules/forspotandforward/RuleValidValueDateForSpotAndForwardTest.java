package com.meritkapital.tradevalidator.rules.forspotandforward;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.exceptions.ruleexceptions.RuleException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleValidValueDateForSpotAndForwardTest {

    @Test
    public void testRuleValidValueDateForSpotAndForwardSuccess(){
        RuleValidValueDateForSpotAndForward rule = new RuleValidValueDateForSpotAndForward();
        RequestEntity entity = RequestEntity.builder()
                .valueDate(LocalDate.of(2017,8,22))
                .build();

        rule.apply(entity);
    }

    @Test(expected = RuleException.class)
    public void testRuleValidValueDateForSpotAndForwardFail(){
        RuleValidValueDateForSpotAndForward rule = new RuleValidValueDateForSpotAndForward();
        RequestEntity entity = RequestEntity.builder()
                .build();

        rule.apply(entity);
    }
}
