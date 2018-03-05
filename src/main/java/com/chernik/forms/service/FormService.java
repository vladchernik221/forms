package com.chernik.forms.service;

import com.chernik.forms.api.dto.FormDto;
import com.chernik.forms.exception.EntityNotFoundException;

import java.util.List;

public interface FormService {
    FormDto create(FormDto formDto);

    FormDto update(FormDto formDto) throws EntityNotFoundException;

    FormDto getById(Long id) throws EntityNotFoundException;

    List<FormDto> getAll();
}
