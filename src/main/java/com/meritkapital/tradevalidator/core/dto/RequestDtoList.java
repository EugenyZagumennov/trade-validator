package com.meritkapital.tradevalidator.core.dto;

import lombok.Data;

import java.util.List;

/**
 * Bulk DTO for {@link RequestDto}
 *
 * @author Evgenii Zagumennov
 */
@Data
public class RequestDtoList {
    private List<RequestDto> test;
}
