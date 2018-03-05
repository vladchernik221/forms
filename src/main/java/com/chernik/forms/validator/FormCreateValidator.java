package com.chernik.forms.validator;

import com.chernik.forms.exception.BaseException;
import com.chernik.forms.exception.MissedParameterException;
import com.chernik.forms.persistence.entity.Form;
import org.springframework.stereotype.Component;

@Component
public class FormCreateValidator implements Validator<Form> {

    @Override
    public void validate(Form form) throws BaseException {
        if (form.getName() == null || form.getName().isEmpty()) {
            throw new MissedParameterException("name");
        }
    }
}
