package com.chernik.forms.api.controller;

import com.chernik.forms.api.dto.AnswerDto;
import com.chernik.forms.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private final AnswerService answerService;

    @Autowired
    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public void saveAnswers(@Validated @RequestBody List<AnswerDto> answerDtos) {
        answerService.saveResults(answerDtos);
    }
}
