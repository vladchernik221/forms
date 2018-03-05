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

    @NotNull(groups = {UpdateChecks.class})
    private Long questionId;

    @NotEmpty
    @Length(max = 512, groups = {UpdateChecks.class, CreateChecks.class})
    private String text;

    @NotNull(groups = {UpdateChecks.class, CreateChecks.class})
    private QuestionType type;

    @NotNull(groups = {UpdateChecks.class, CreateChecks.class})
    private Long formId;

    private List<AnswerOptionDto> answerOptions = new ArrayList<>();
}
