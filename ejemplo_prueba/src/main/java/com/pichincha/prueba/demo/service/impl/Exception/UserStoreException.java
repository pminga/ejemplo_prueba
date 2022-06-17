package com.pichincha.prueba.demo.service.impl.Exception;

import lombok.Getter;

@Getter
public class UserStoreException extends Exception {
    private static final long serialVersionUID = -1393415637717906283L;

    private String message;

    public UserStoreException(String message, Throwable exception) {
        super(message,exception);
        this.message = message;

    }
}
