package com.chernik.forms.service.Impl;

import com.chernik.forms.api.dto.AnswerDto;
import com.chernik.forms.persistence.entity.AnswerEntity;
import com.chernik.forms.persistence.jparepository.AnswerRepository;
import com.chernik.forms.service.AnswerService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;

@Data
@Service
public class AnswerServiceImpl implements AnswerService {

    private final AnswerRepository answerRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public AnswerServiceImpl(AnswerRepository answerRepository, ModelMapper modelMapper) {
        this.answerRepository = answerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    @Transactional
    public void saveResults(List<AnswerDto> answerDtos) {
        Type listType = new TypeToken<List<AnswerEntity>>() {
        }.getType();
        List<AnswerEntity> answerEntities = modelMapper.map(answerDtos, listType);

        answerRepository.saveAll(answerEntities);
    }
}
