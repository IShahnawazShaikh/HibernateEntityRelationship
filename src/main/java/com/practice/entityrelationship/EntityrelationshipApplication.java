package com.practice.entityrelationship;

import com.practice.entityrelationship.answer.AnswerEntity;
import com.practice.entityrelationship.answer.AnswerService;
import com.practice.entityrelationship.question.QuestionEntity;
import com.practice.entityrelationship.question.QuestionService;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class EntityrelationshipApplication implements CommandLineRunner {

	@Autowired
	AnswerService answerService;

	@Autowired
	QuestionService questionService;
	public static void main(String[] args) {
		SpringApplication.run(EntityrelationshipApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("************* Application started  **************************");

		QuestionEntity question1=new QuestionEntity();
		question1.setQuestion("What is Java ?");

		AnswerEntity answer1=new AnswerEntity();
		answer1.setAnswer("Java is a Programming Language");
		answer1.setQuestion(question1);

		AnswerEntity answer2=new AnswerEntity();
		answer2.setAnswer("Java is used to develop Application");
		answer2.setQuestion(question1);

		AnswerEntity answer3=new AnswerEntity();
		answer3.setAnswer("Java support OOPs");
		answer3.setQuestion(question1);

		List<AnswerEntity> answerEntityList= Arrays.asList(answer1,answer2,answer3);

		question1.setAnswer(answerEntityList);

		questionService.saveQuestion(question1);


		/***** Fetching *************/

		QuestionEntity question=questionService.getQuestionById(1L);
		System.out.println(question.getId() +" - "+question.getQuestion());

		for(AnswerEntity answers: question.getAnswer()){
			System.out.println("answers: "+answers.getAnswer());
		}


	}
}
