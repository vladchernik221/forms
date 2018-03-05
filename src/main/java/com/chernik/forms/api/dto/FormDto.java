package com.chernik.forms.api.dto;

import com.chernik.forms.persistence.entity.Question;
import com.chernik.forms.persistence.entity.User;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class FormDto {
    private Long formId;
    private String name;
    private String description;
    private Date creationDate;
    private List<Question> questions;
    private User user;
}
