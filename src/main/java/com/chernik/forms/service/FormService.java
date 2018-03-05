package com.chernik.forms.service;

import com.chernik.forms.exception.BaseException;
import com.chernik.forms.persistence.entity.Form;

import javax.persistence.criteria.From;

public interface FormService {
    Form create(Form form) throws BaseException;

    Form update(From form);

    void delete(Long id);

    Form getById(Long id);
}
