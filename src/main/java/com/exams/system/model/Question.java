package com.exams.system.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "questions")
@Getter @Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @Column(length = 5000)
    private String description;
    private String img;
    private String op1;
    private String op2;
    private String op3;
    private String op4;
    @Transient
    private String correctAnswer;
    private String answer;

    @ManyToOne(fetch = FetchType.EAGER)
    private Exam exam;

    public Question() {}
}
