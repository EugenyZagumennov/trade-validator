package com.meritkapital.tradevalidator.restcontrollers;

import com.meritkapital.tradevalidator.services.ValidatorService;
import com.meritkapital.tradevalidator.core.dto.RequestDtoList;
import com.meritkapital.tradevalidator.core.dto.ResponseDtoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestValidatorController {

    @Autowired
    private ValidatorService validatorService;

    @PostMapping("/validator")
    public @ResponseBody ResponseDtoList processRequest(@RequestBody RequestDtoList dtoList){
        return validatorService.validate(dtoList);
    }
}
