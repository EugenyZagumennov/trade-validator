package com.meritkapital.tradevalidator.core.enums;

import com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions.InvalidTypeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TypeTest {

    @Test
    public void testParseTypeSuccess(){
        assertEquals(Type.FORWARD, Type.parse("Forward"));
        assertEquals(Type.FXSPOT, Type.parse("Spot"));
        assertEquals(Type.OPTION, Type.parse("VanillaOption"));
    }

    @Test(expected = InvalidTypeException.class)
    public void testParseTypeFail(){
        Type.parse("FORWARD");
    }
}