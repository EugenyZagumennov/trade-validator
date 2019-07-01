package com.meritkapital.tradevalidator.core.enums;

import com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions.InvalidCustomerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {

    @Test
    public void testParseCustomerSuccess(){
        assertEquals(Customer.PLUTO1, Customer.parse("PLUTO1"));
        assertEquals(Customer.PLUTO2, Customer.parse("PLUTO2"));
    }

    @Test(expected = InvalidCustomerException.class)
    public void testParseCustomerFail(){
        Customer.parse("PLUTO3");
    }
}
