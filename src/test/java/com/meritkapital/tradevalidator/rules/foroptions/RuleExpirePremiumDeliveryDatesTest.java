package com.meritkapital.tradevalidator.rules.foroptions;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.exceptions.ruleexceptions.RuleException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleExpirePremiumDeliveryDatesTest {

    @Test
    public void testRuleExpirePremiumDeliveryDatesSuccess(){
        RuleExpirePremiumDeliveryDates rule = new RuleExpirePremiumDeliveryDates();
        RequestEntity entity = RequestEntity.builder()
                .expiryDate(LocalDate.of(2017,8,11))
                .premiumDate(LocalDate.of(2017,8,15))
                .deliveryDate(LocalDate.of(2017,8,22))
                .build();

        rule.apply(entity);
    }

    @Test(expected = RuleException.class)
    public void testRuleExpirePremiumDeliveryDatesFail(){
        RuleExpirePremiumDeliveryDates rule = new RuleExpirePremiumDeliveryDates();
        RequestEntity entity = RequestEntity.builder()
                .expiryDate(LocalDate.of(2017,8,22))
                .premiumDate(LocalDate.of(2017,8,22))
                .deliveryDate(LocalDate.of(2017,8,22))
                .build();

        rule.apply(entity);
    }
}
