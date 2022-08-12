package com.practice.entityrelationship.answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;
    public void createAnswer(AnswerEntity answer) {
       answer= answerRepository.save(answer);
       System.out.println("answer: "+answer);
    }

    public AnswerEntity getAnswerById(long id) {
        Optional<AnswerEntity> optionalAnswerEntity= answerRepository.findById(id);
        return optionalAnswerEntity.get();
    }
}
