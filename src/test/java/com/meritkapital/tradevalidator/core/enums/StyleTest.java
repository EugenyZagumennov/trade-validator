package com.meritkapital.tradevalidator.core.enums;

import com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions.InvalidStyleException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StyleTest {

    @Test
    public void testParseStyleSuccess(){
        assertEquals(Style.AMERICAN, Style.parse("AMERICAN"));
        assertEquals(Style.EUROPEAN, Style.parse("EUROPEAN"));
    }

    @Test(expected = InvalidStyleException.class)
    public void testParseStyleFail(){
        Style.parse("CHINEESE");
    }
}
