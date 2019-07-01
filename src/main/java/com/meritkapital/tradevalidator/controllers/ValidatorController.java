package com.meritkapital.tradevalidator.controllers;

import com.meritkapital.tradevalidator.services.ValidatorService;
import com.meritkapital.tradevalidator.core.dto.RequestDtoList;
import com.meritkapital.tradevalidator.core.dto.ResponseDtoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/validator")
public class ValidatorController {

    @Autowired
    private ValidatorService validatorService;

    @PostMapping
    public @ResponseBody ResponseDtoList processRequest(@RequestBody RequestDtoList dtoList){
        return validatorService.validate(dtoList);
    }
}
