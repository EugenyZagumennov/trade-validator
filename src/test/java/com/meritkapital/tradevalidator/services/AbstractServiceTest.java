package com.meritkapital.tradevalidator.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meritkapital.tradevalidator.core.dto.RequestDtoList;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

public abstract class AbstractServiceTest {

    protected RequestDtoList getJsonTestData(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = ResourceUtils.getFile("classpath:"+fileName);
        return objectMapper.readValue(file, RequestDtoList.class);
    }
}
