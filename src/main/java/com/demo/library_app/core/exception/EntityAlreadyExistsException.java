package com.demo.library_app.core.exception;

public class EntityAlreadyExistsException extends EntityGenericException {
    public static final String DEFAULT_CODE = "AlreadyExists";
    public EntityAlreadyExistsException(String code, String message) {
        super(code + DEFAULT_CODE, message);
    }
}
