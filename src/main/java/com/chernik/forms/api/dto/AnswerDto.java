package com.chernik.forms.api.dto;

import com.chernik.forms.persistence.entity.User;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Data
public class AnswerDto {
    private Long answerId;

    @Length(max = 256)
    private String simpleAnswer;

    @NotEmpty
    private User user;

    @NotEmpty
    private QuestionDto question;

    @NotEmpty
    private AnswerOptionDto answerOption;
}
