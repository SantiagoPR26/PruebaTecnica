package com.example.demo.shared.base;

import lombok.Getter;

@Getter
public enum ExceptionCode {

    CONDUCTOR_NOT_SAVED("ERR-001", "Exception.CONDUCTOR_NOT_SAVED"),
    VEHICULO_NOT_SAVED("ERR-002", "Exception.VEHICULO_NOT_SAVED");

    private final String code;
    private final String type;

    ExceptionCode(String code, String type){
        this.code = code;
        this.type = type;
    }
}
