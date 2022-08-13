package com.practice.entityrelationship.question;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    public void createQuestion(QuestionEntity question1) {
        questionRepository.save(question1);
    }

    public QuestionEntity getQuestionById(long id) {
       Optional< QuestionEntity> optionalQuestionEntity= questionRepository.findById(id);
       return optionalQuestionEntity.get();
    }

    public void saveQuestion(QuestionEntity question1) {
        questionRepository.save(question1);
    }
}
