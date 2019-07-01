package com.meritkapital.tradevalidator.core.enums;

import com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions.InvalidDirectionException;

public enum Direction {
    BUY("BUY"), SELL("SELL");

    private String name;

    Direction(String name) {
        this.name = name;
    }

    public static Direction parse(String str){
        if(str == null){
            return null;
        }

        switch (str){
            case "BUY": return BUY;
            case "SELL": return SELL;
            default:
                throw new InvalidDirectionException(str);
        }
    }
}
