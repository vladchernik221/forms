package com.chernik.forms.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "form")
public class FormEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long formId;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Date creationDate;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "form_id", nullable = false)
    private List<Question> questions;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "userId", nullable = false)
    private User user;
}
