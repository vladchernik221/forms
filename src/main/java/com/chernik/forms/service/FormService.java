package com.chernik.forms.service;

import com.chernik.forms.exception.BaseException;
import com.chernik.forms.persistence.entity.FormEntity;

import javax.persistence.criteria.From;

public interface FormService {
    FormEntity create(FormEntity formEntity) throws BaseException;

    FormEntity update(From form);

    void delete(Long id);

    FormEntity getById(Long id);
}
