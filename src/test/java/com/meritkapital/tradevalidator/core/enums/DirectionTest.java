package com.meritkapital.tradevalidator.core.enums;

import com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions.InvalidDirectionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DirectionTest {

    @Test
    public void testParseDirectionSuccess(){
        assertEquals(Direction.BUY, Direction.parse("BUY"));
        assertEquals(Direction.SELL, Direction.parse("SELL"));
    }

    @Test(expected = InvalidDirectionException.class)
    public void testParseDirectionFail(){
        Direction.parse("buy");
    }
}
