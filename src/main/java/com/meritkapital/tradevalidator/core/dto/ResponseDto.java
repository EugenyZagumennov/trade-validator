package com.meritkapital.tradevalidator.core.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ResponseDto {
    private int id;
    private boolean success;
    private List<String> messages;

    public static ResponseDto success(int id){
        return ResponseDto.builder()
                .id(id)
                .success(true)
                .build();
    }

    public static ResponseDto fail(int id, List<String> messages){
        return ResponseDto.builder()
                .id(id)
                .success(false)
                .messages(messages)
                .build();
    }
}