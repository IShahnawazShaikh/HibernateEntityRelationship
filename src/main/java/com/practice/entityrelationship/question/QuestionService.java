package com.practice.entityrelationship.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    public void createQuestion(QuestionEntity question1) {
        questionRepository.save(question1);
    }
}
