package com.meritkapital.tradevalidator.core.mappers;

import com.meritkapital.tradevalidator.core.dto.RequestDto;
import com.meritkapital.tradevalidator.core.entities.RequestEntity;
import com.meritkapital.tradevalidator.core.enums.Type;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.meritkapital.tradevalidator.core.enums.Currency;

/**
 * Mapper for mapping {@link RequestDto} to {@link RequestEntity}
 *
 * @author Evgenii Zagumennov
 */
@Mapper(componentModel = "spring")
public abstract class RequestDtoMapper {

    @Mapping(target = "id", expression = "java(id)")
    @Mapping(target = "customer", expression = "java(com.meritkapital.tradevalidator.core.enums.Customer.parse(dto.getCustomer()))")
    @Mapping(target = "ccyFirst", expression = "java(getFirstCcy(dto.getCcyPair()))")
    @Mapping(target = "ccySecond", expression = "java(getSecondCcy(dto.getCcyPair()))")
    @Mapping(target = "type", expression = "java(com.meritkapital.tradevalidator.core.enums.Type.parse(dto.getType()))")
    @Mapping(target = "direction", expression = "java(com.meritkapital.tradevalidator.core.enums.Direction.parse(dto.getDirection()))")
    @Mapping(target = "tradeDate", expression = "java(parseDate(dto.getTradeDate()))")
    @Mapping(target = "amount1", expression = "java(new java.math.BigDecimal(dto.getAmount1()))")
    @Mapping(target = "amount2", expression = "java(new java.math.BigDecimal(dto.getAmount2()))")
    @Mapping(target = "valueDate", expression = "java(parseDate(dto.getValueDate()))")
    @Mapping(target = "style", expression = "java(com.meritkapital.tradevalidator.core.enums.Style.parse(dto.getStyle()))")
    @Mapping(target = "deliveryDate", expression = "java(parseDate(dto.getDeliveryDate()))")
    @Mapping(target = "expiryDate", expression = "java(parseDate(dto.getExpiryDate()))")
    @Mapping(target = "premiumCcy", expression = "java(com.meritkapital.tradevalidator.core.enums.Currency.parse(dto.getPremiumCcy()))")
    @Mapping(target = "premiumDate", expression = "java(parseDate(dto.getPremiumDate()))")
    @Mapping(target = "excerciseStartDate", expression = "java(parseDate(dto.getExcerciseStartDate()))")
    @Mapping(target = "payCcy", expression = "java(com.meritkapital.tradevalidator.core.enums.Currency.parse(dto.getPayCcy()))")
    public abstract RequestEntity map(RequestDto dto, Integer id);

    LocalDate parseDate(String str){
        if(str == null || str.isEmpty()){
            return null;
        }

        return LocalDate
                .parse(str , DateTimeFormatter.ofPattern("yyyy-MM-dd" ));
    }

    Type parsePremiumType(String str){
        if(str == null || str.isEmpty()){
            return null;
        }

        return Type.parse(str.substring(1));
    }

    Currency getFirstCcy(String str){
        return Currency.parse(str.substring(0, 3));
    }

    Currency getSecondCcy(String str){
        return Currency.parse(str.substring(3, 6));
    }
}
