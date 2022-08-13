package com.practice.entityrelationship.answer;

import com.practice.entityrelationship.question.QuestionEntity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="answer")
@Data
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="answer_id")
    private Long id;

    @Column(name="answer")
    private String answer;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name="question_id")
    QuestionEntity question;
}
