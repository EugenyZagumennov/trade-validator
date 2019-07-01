package com.meritkapital.tradevalidator.rules.forall;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.enums.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RuleValidCustomerTest {

    @Test
    public void testRuleValidCustomer(){
        RuleValidCustomer rule = new RuleValidCustomer();

        for(Customer customer : Customer.values()) {
            RequestEntity entity =
                    RequestEntity.builder()
                            .customer(customer)
                            .build();

            rule.apply(entity);
        }
    }
}