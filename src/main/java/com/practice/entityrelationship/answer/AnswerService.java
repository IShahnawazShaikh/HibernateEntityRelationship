package com.practice.entityrelationship.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;
    public void createAnswer(AnswerEntity answer) {
       answer= answerRepository.save(answer);
       System.out.println("answer: "+answer);
    }
}
