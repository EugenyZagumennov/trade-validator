package com.meritkapital.tradevalidator.core.enums;

import com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions.InvalidCurrencyException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyTest {

    @Test
    public void testParseCurrencySuccess(){
        assertEquals(Currency.USD, Currency.parse("USD"));
        assertEquals(Currency.EUR, Currency.parse("EUR"));
    }

    @Test(expected = InvalidCurrencyException.class)
    public void testParseCurrencyFail(){
        Currency.parse("RUB");
    }
}
