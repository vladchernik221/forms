package com.chernik.forms.api.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnswerOptionDto {

    private Long answerOptionId;

    @NotEmpty
    @Length(max = 256, groups = {UpdateChecks.class, CreateChecks.class})
    private String answer;

    @NotNull(groups = {UpdateChecks.class, CreateChecks.class})
    private Long questionId;
}
