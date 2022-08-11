package com.practice.entityrelationship;

import com.practice.entityrelationship.answer.AnswerEntity;
import com.practice.entityrelationship.answer.AnswerService;
import com.practice.entityrelationship.question.QuestionEntity;
import com.practice.entityrelationship.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		question1.setAnswer(answer1);


		QuestionEntity question2=new QuestionEntity();
		question2.setQuestion("What is Collection?");
		AnswerEntity answer2=new AnswerEntity();
		answer2.setAnswer("Collection is Framework comprise of interfaces and classes to store data.");
		question2.setAnswer(answer2);

		questionService.createQuestion(question1);
		answerService.createAnswer(answer1);

		questionService.createQuestion(question2);
		answerService.createAnswer(answer2);

	}
}
