package com.chernik.forms.validator;

import com.chernik.forms.exception.BaseException;
import com.chernik.forms.exception.MissedParameterException;
import com.chernik.forms.persistence.entity.FormEntity;
import org.springframework.stereotype.Component;

@Component
public class FormCreateValidator implements Validator<FormEntity> {

    @Override
    public void validate(FormEntity formEntity) throws BaseException {
        if (formEntity.getName() == null || formEntity.getName().isEmpty()) {
            throw new MissedParameterException("name");
        }
    }
}
