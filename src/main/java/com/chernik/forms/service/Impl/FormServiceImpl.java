package com.chernik.forms.service.Impl;

import com.chernik.forms.exception.BaseException;
import com.chernik.forms.persistence.entity.Form;
import com.chernik.forms.persistence.jparepository.FormRepository;
import com.chernik.forms.service.FormService;
import com.chernik.forms.validator.FormCreateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.From;
import javax.transaction.Transactional;

@Service
public class FormServiceImpl implements FormService {

    private final FormRepository formRepository;

    private final FormCreateValidator formCreateValidator;

    @Autowired
    public FormServiceImpl(FormRepository formRepository, FormCreateValidator formCreateValidator) {
        this.formRepository = formRepository;
        this.formCreateValidator = formCreateValidator;
    }


    @Override
    @Transactional
    public Form create(Form form) throws BaseException {
        formCreateValidator.validate(form);
        formRepository.save(form);
        return form;
    }

    @Override
    public Form update(From form) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Form getById(Long id) {
        return null;
    }


}
