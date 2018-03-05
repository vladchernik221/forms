package com.chernik.forms.api.controller;

import com.chernik.forms.api.dto.FormDto;
import com.chernik.forms.api.dto.Version1Checks;
import com.chernik.forms.api.dto.Version2Checks;
import com.chernik.forms.exception.EntityNotFoundException;
import com.chernik.forms.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/form")
public class FormController {
    private FormService formService;

    @Autowired
    public FormController(FormService formService) {
        this.formService = formService;
    }

    @GetMapping(value = "/{formId}")
    public FormDto getFormByID(@PathVariable Long formId) throws EntityNotFoundException {
        return formService.getById(formId);
    }

    @PutMapping(value = "/{formId}")
    public FormDto updateForm(@PathVariable Long formId, @Validated(Version1Checks.class) @RequestBody FormDto formDto) throws EntityNotFoundException {
        formDto.setFormId(formId);
        return formService.update(formDto);
    }

    @PostMapping(value = "/{formId}")
    public FormDto saveForm(@PathVariable Long formId, @Validated(Version2Checks.class) @RequestBody FormDto formDto) {
        formDto.setFormId(formId);
        return formService.create(formDto);
    }
}
