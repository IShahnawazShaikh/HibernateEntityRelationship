package com.practice.entityrelationship.question;

import com.practice.entityrelationship.answer.AnswerEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<AnswerEntity> answer;       // One Question has many answers
}
