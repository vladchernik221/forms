package com.chernik.forms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MissedParameterException extends BaseException {
    private String missedField;

    private static String MESSAGE_FORMAT = "Parameter %s is required";

    public MissedParameterException(String missedField) {
        super(String.format(MESSAGE_FORMAT, missedField));
        this.missedField = missedField;
    }
}
