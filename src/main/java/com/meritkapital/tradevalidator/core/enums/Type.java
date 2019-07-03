package com.meritkapital.tradevalidator.core.enums;

import com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions.InvalidTypeException;

/**
 * Supported types
 *
 * @author Evgenii Zagumennov
 */
public enum Type {
    FXSPOT("Spot"), FORWARD("Forward"), OPTION("VanillaOption");

    private String name;

    Type(String name) {
        this.name = name;
    }

    public static Type parse(String str){
        if(str == null){
            return null;
        }

        switch (str){
            case "Spot": return FXSPOT;
            case "Forward": return FORWARD;
            case "VanillaOption": return OPTION;
            default:
                throw new InvalidTypeException(str);
        }
    }
}
