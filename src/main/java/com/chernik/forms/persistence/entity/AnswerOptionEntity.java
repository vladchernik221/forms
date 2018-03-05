package com.chernik.forms.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "answer_option")
public class AnswerOptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerOptionId;

    @Column(nullable = false)
    private String answer;

    @Column(name = "question_id", insertable = false, updatable = false)
    private Long questionId;
}
