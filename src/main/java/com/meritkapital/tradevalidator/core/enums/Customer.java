package com.meritkapital.tradevalidator.core.enums;

import com.meritkapital.tradevalidator.core.exceptions.mappingexcpetions.InvalidCustomerException;

public enum Customer {
    PLUTO1("PLUTO1"), PLUTO2("PLUTO2");

    private String name;

    Customer(String name) {
        this.name = name;
    }

    public static Customer parse(String str){
        if(str == null){
            return null;
        }

        switch (str) {
            case "PLUTO1": return PLUTO1;
            case "PLUTO2": return PLUTO2;
            default: throw new InvalidCustomerException(str);
        }
    }
}
