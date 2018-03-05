package com.chernik.forms.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Маша on 08.10.2017.
 */
@Getter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends BaseException {
    final private Object identity;
    final private EntityType type;

    private static String MESSAGE_FORMAT = "Cannot find element with type %s and login %s";

    public EntityNotFoundException(Object identity, EntityType type) {
        super(String.format(MESSAGE_FORMAT, type, identity));
        this.identity = identity;
        this.type = type;
    }
}
