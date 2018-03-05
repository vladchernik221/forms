package com.chernik.forms.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"message", "localizedMessage", "cause", "stackTrace"})
public class BaseException extends Exception {
    public BaseException(String message) {
        super(message);
    }
}
