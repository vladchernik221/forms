package com.chernik.forms.persistence.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "answer")
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    private String simpleAnswer;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "questionId", nullable = false)
    private QuestionEntity question;

    @ManyToOne
    @JoinColumn(name = "answer_option_id", referencedColumnName = "answerOptionId")
    private AnswerOptionEntity answerOption;
}
