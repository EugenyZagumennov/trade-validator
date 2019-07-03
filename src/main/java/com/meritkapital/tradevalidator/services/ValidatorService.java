package com.meritkapital.tradevalidator.services;

import com.meritkapital.tradevalidator.core.dto.RequestDto;
import com.meritkapital.tradevalidator.core.dto.RequestDtoList;
import com.meritkapital.tradevalidator.core.dto.ResponseDto;
import com.meritkapital.tradevalidator.core.dto.ResponseDtoList;
import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.mappers.RequestDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Service which validates {@link RequestDtoList}
 *
 * @author Evgenii Zagumennov
 */
@Service
public class ValidatorService {

    @Autowired
    private RequestDtoMapper mapper;

    @Autowired
    private RulesService rulesService;

    /**
     * Validates {@link RequestDtoList}
     *
     * @param dtoList {@link RequestDtoList}
     * @return {@link ResponseDtoList}
     */
    public ResponseDtoList validate(RequestDtoList dtoList){
        ResponseDtoList result = new ResponseDtoList();
        List<RequestDto> list = dtoList.getTest();

        if(list.isEmpty()){
            return result;
        }

        //for-cycle is used to make index for entities
        for (int i = 0; i < list.size(); i++) {
            ResponseDto dto;
            try {
                RequestEntity entity = mapper.map(list.get(i), i);
                List<String> messges = rulesService.applyRules(entity);

                dto = messges.isEmpty() ? ResponseDto.success(i) : ResponseDto.fail(i, messges);
            } catch (Exception e) {
                dto = ResponseDto.fail(i, Arrays.asList(e.getMessage()));
            }
            result.add(dto);
        }

        return result;
    }
}
