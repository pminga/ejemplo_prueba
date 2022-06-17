package com.pichincha.prueba.demo.service.impl.Exception;

import lombok.Getter;

@Getter
public class StoreException extends Exception{
    private static final long serialVersionUID = -1393415637717906283L;

    private String message;

    public StoreException(String message, Throwable exception) {
        super(message,exception);
        this.message = message;

    }
}
