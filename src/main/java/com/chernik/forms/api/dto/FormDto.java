package com.chernik.forms.api.dto;

import com.chernik.forms.persistence.entity.User;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class FormDto {
    private Long formId;

    @NotEmpty
    @Length(max = 256)
    private String name;

    @Length(max = 512)
    private String description;

    private Date creationDate;
    private List<QuestionDto> questions = new ArrayList<>();
    private User user;
}
