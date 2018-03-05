package com.chernik.forms.service;

import com.chernik.forms.api.dto.AnswerDto;

import java.util.List;

public interface AnswerService {
    void saveResults(List<AnswerDto> answerDtos);
}