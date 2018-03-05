package com.chernik.forms.api.controller;

import com.chernik.forms.api.dto.CreateChecks;
import com.chernik.forms.api.dto.FormDto;
import com.chernik.forms.api.dto.UpdateChecks;
import com.chernik.forms.exception.EntityNotFoundException;
import com.chernik.forms.persistence.entity.User;
import com.chernik.forms.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data/form")
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

    @PostMapping(value = "/{formId}")
    public FormDto updateForm(@PathVariable Long formId, @Validated(UpdateChecks.class) @RequestBody FormDto formDto) throws EntityNotFoundException {
        formDto.setFormId(formId);
        return formService.update(formDto);
    }

    @PostMapping(value = "/new")
    public FormDto saveForm(@Validated(CreateChecks.class) @RequestBody FormDto formDto) {
        User user = new User();
        user.setUserId(1L);
        formDto.setUser(user);
        return formService.create(formDto);
    }

    @GetMapping
    public List<FormDto> getAllForm() {
        return formService.getAll();
    }
}
