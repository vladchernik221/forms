package com.chernik.forms.api.dto;

import com.chernik.forms.persistence.entity.QuestionType;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class QuestionDto {

    @NotNull(groups = {Version1Checks.class})
    private Long questionId;

    @NotEmpty
    @Length(max = 512, groups = {Version1Checks.class, Version2Checks.class})
    private String text;

    @NotNull(groups = {Version1Checks.class, Version2Checks.class})
    private QuestionType type;

    @NotNull(groups = {Version1Checks.class, Version2Checks.class})
    private Long formId;

    private List<AnswerOptionDto> answerOptions = new ArrayList<>();
}
