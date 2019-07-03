package com.meritkapital.tradevalidator.core.enums;

import com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions.InvalidStyleException;

/**
 * Supported styles
 *
 * @author Evgenii Zagumennov
 */
public enum Style {
    EUROPEAN("EUROPEAN"), AMERICAN("AMERICAN");

    private String name;

    Style(String name) {
        this.name = name;
    }

    public static Style parse(String str){
        if(str == null){
            return null;
        }

        switch (str){
            case "EUROPEAN": return EUROPEAN;
            case "AMERICAN": return AMERICAN;
            default:
                throw new InvalidStyleException(str);
        }
    }
}
