package com.example.demo.shared.base;


import org.springframework.http.HttpStatus;

public class VehiculoExistException extends BaseException {

    public VehiculoExistException(String message){
        super(HttpStatus.CONFLICT, message, ExceptionCode.VEHICULO_NOT_SAVED);
    }
}
