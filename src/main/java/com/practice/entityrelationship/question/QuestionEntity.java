package com.practice.entityrelationship.question;

import com.practice.entityrelationship.answer.AnswerEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="question")
@Data
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="question_id")
    private Long id;

    @Column(name="question")
    private String question;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="answer_id")
    private AnswerEntity answer;
}
