package com.demo.library_app.core.exception;

import lombok.Getter;

@Getter
public class EntityGenericException extends RuntimeException{
    private final String code;

    public EntityGenericException(String code, String message) {
        super(message);
        this.code = code;
    }
}
