package com.chernik.forms.api.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class AnswerOptionDto {

    @NotNull(groups = {Version1Checks.class})
    private Long answerOptionId;

    @NotEmpty
    @Length(max = 256, groups = {Version1Checks.class, Version2Checks.class})
    private String answer;

    @NotNull(groups = {Version1Checks.class, Version2Checks.class})
    private Long questionId;
}
