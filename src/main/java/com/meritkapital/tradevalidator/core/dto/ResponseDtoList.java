package com.meritkapital.tradevalidator.core.dto;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseDtoList {
    private List<ResponseDto> content = new ArrayList<>();

    public void add(ResponseDto item){
        content.add(item);
    }
}
