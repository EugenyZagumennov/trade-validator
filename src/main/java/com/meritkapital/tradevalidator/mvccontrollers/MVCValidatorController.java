package com.meritkapital.tradevalidator.mvccontrollers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meritkapital.tradevalidator.core.dto.RequestDtoList;
import com.meritkapital.tradevalidator.core.dto.ResponseDtoList;
import com.meritkapital.tradevalidator.services.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/view")
public class MVCValidatorController {

    @Autowired
    private ValidatorService validatorService;

    @GetMapping
    public String getView(){
        return "view";
    }

    @PostMapping
    public String validateJson(@RequestParam("file") MultipartFile file, Map<String, Object> model){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            RequestDtoList input = objectMapper.readValue(file.getInputStream(), RequestDtoList.class);
            ResponseDtoList output = validatorService.validate(input);
            model.put("data", output.getContent());
        } catch (IOException e) {
            model.put("message", e.getMessage());
        }

        return "view";
    }
}
