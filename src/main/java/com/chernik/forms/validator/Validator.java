package com.chernik.forms.validator;

import com.chernik.forms.exception.BaseException;

public interface Validator<T> {
    void validate(T entity) throws BaseException;
}
