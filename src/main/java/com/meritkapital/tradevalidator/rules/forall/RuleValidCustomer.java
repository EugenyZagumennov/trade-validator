package com.meritkapital.tradevalidator.rules.forall;

import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.enums.Customer;
import com.meritkapital.tradevalidator.core.exceptions.ruleexceptions.RuleException;
import com.meritkapital.tradevalidator.rules.AbstractRule;

import java.util.HashSet;
import java.util.Set;

/**
 * Rule: customers should be from the list of supported ones
 *
 * @author Evgenii Zagumennov
 */
public class RuleValidCustomer extends AbstractRule {
    private Set<Customer> validCustomers;

    public RuleValidCustomer() {
        validCustomers = new HashSet<>();
        validCustomers.add(Customer.PLUTO1);
        validCustomers.add(Customer.PLUTO2);
    }

    @Override
    public void apply(RequestEntity entity) throws RuleException {
        if(!validCustomers.contains(entity.getCustomer())){
            throwRuleException("Invalid customer!");
        }
    }
}
