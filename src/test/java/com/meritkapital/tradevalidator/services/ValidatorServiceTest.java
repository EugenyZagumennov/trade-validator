package com.meritkapital.tradevalidator.services;

import com.meritkapital.tradevalidator.core.dto.RequestDtoList;
import com.meritkapital.tradevalidator.core.dto.ResponseDto;
import com.meritkapital.tradevalidator.core.dto.ResponseDtoList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatorServiceTest extends AbstractServiceTest{

	@Autowired
	private ValidatorService validatorService;

	@Test
	public void testValidateFullData() throws IOException {
		RequestDtoList dtoList = getJsonTestData("full_test_data.json");
		ResponseDtoList result = validatorService.validate(dtoList);

		assertEquals(dtoList.getTest().size(), result.getContent().size());
		for(ResponseDto dto : result.getContent()){
		    if(dto.isSuccess()){
		        assertNull(dto.getMessages());
            }else{
		        assertNotNull(dto.getMessages());
		        assertTrue(dto.getMessages().size() > 0);
            }
        }
	}

    @Test
    public void testValidateCorrectData() throws IOException {
        RequestDtoList dtoList = getJsonTestData("correct_data.json");
        ResponseDtoList result = validatorService.validate(dtoList);

        Optional<ResponseDto> unsuccessfullResult = result.getContent()
                .stream()
                .filter(dto -> !dto.isSuccess())
                .findAny();

        assertFalse(unsuccessfullResult.isPresent());
    }

    @Test
    public void testValidateSingleError() throws IOException {
        RequestDtoList dtoList = getJsonTestData("single_error_data.json");
        ResponseDtoList result = validatorService.validate(dtoList);

        assertEquals(1, result.getContent().size());

        ResponseDto dto = result.getContent().get(0);
        assertFalse(dto.isSuccess());
        assertEquals(1, dto.getMessages().size());
        assertTrue(dto.getMessages().get(0).equals("MappingException: Value 'PLUTO3' for customer is invalid!"));
    }


    @Test
    public void testValidateMultiError() throws IOException {
        RequestDtoList dtoList = getJsonTestData("multi_error_data.json");
        ResponseDtoList result = validatorService.validate(dtoList);

        assertEquals(1, result.getContent().size());

        ResponseDto dto = result.getContent().get(0);
        assertFalse(dto.isSuccess());
        assertEquals(3, dto.getMessages().size());
        assertTrue(dto.getMessages().contains("RuleValueDateAfterOrEqualTradeDate: Value date cannot be null!"));
        assertTrue(dto.getMessages().contains("RuleValueDateNotOnWeekend: Value date cannot be null!"));
        assertTrue(dto.getMessages().contains("RuleExerciseDateBetweenTradeAndExpiry: Exercise date should be after trade date and before expiry date!"));
    }
}
