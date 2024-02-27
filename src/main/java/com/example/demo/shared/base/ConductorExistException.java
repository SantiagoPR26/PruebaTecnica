package com.example.demo.shared.base;

import org.springframework.http.HttpStatus;

public class ConductorExistException extends BaseException{

    public ConductorExistException(String message){
        super(HttpStatus.CONFLICT, message, ExceptionCode.CONDUCTOR_NOT_SAVED);
    }
}
