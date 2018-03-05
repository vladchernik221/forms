package com.chernik.forms.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private Integer positionNumber;

    @Column(nullable = false)
    private Boolean hasOtherOption;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM ('OPEN', 'RADIO', 'CHECK')")
    private QuestionType type;

    @Column(name = "form_id", insertable = false, updatable = false)
    private Long formId;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id", nullable = false)
    private List<AnswerOption> answerOptions;
}
