package com.chernik.forms.service.Impl;

import com.chernik.forms.api.dto.FormDto;
import com.chernik.forms.exception.EntityNotFoundException;
import com.chernik.forms.exception.EntityType;
import com.chernik.forms.persistence.entity.FormEntity;
import com.chernik.forms.persistence.jparepository.FormRepository;
import com.chernik.forms.service.FormService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class FormServiceImpl implements FormService {

    private final FormRepository formRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public FormServiceImpl(FormRepository formRepository, ModelMapper modelMapper) {
        this.formRepository = formRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    @Transactional
    public FormDto create(FormDto formDto) {
        FormEntity formEntity = modelMapper.map(formDto, FormEntity.class);
        FormEntity savedFormEntity = formRepository.save(formEntity);
        return modelMapper.map(savedFormEntity, FormDto.class);
    }

    @Override
    @Transactional
    public FormDto update(FormDto formDto) throws EntityNotFoundException {
        FormEntity formEntity = modelMapper.map(formDto, FormEntity.class);

        Optional<FormEntity> foundFormEntity = formRepository.findByFormId(formEntity.getFormId());

        if (!foundFormEntity.isPresent()) {
            throw new EntityNotFoundException(formEntity.getFormId(), EntityType.FORM);
        }

        FormEntity savedFormEntity = formRepository.save(formEntity);
        return modelMapper.map(savedFormEntity, FormDto.class);
    }

    @Override
    @Transactional
    public FormDto getById(Long id) throws EntityNotFoundException {
        Optional<FormEntity> formEntity = formRepository.findByFormId(id);

        if (!formEntity.isPresent()) {
            throw new EntityNotFoundException(id, EntityType.FORM);
        }

        return modelMapper.map(formEntity.get(), FormDto.class);
    }


}
