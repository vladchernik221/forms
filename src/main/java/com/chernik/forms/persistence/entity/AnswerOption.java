package com.chernik.forms.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class AnswerOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerOptionId;

    @Column(nullable = false)
    private String answer;

    @Column(nullable = false)
    private Integer positionNumber;

    @Column(name = "question_id", insertable = false, updatable = false)
    private Long questionId;
}
