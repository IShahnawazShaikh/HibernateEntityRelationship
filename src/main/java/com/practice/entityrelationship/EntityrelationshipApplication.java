package com.practice.entityrelationship;

import com.practice.entityrelationship.answer.AnswerEntity;
import com.practice.entityrelationship.answer.AnswerService;
import com.practice.entityrelationship.employee.EmployeeEntity;
import com.practice.entityrelationship.employee.EmployeeRepository;
import com.practice.entityrelationship.project.ProjectEntity;
import com.practice.entityrelationship.project.ProjectRepository;
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
import java.util.Optional;

@SpringBootApplication
public class EntityrelationshipApplication implements CommandLineRunner {

	@Autowired
	AnswerService answerService;

	@Autowired
	QuestionService questionService;


	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	EmployeeRepository employeeRepository;

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

	/************* Many To Many *********************************************/


		EmployeeEntity emp1=new EmployeeEntity();
		emp1.setEmpName("Shahnawaz");

		EmployeeEntity emp2=new EmployeeEntity();
		emp2.setEmpName("Akhilesh");

		EmployeeEntity emp3=new EmployeeEntity();
		emp3.setEmpName("Niraj");


		ProjectEntity p1=new ProjectEntity();
		p1.setProjectName("LMS");

		ProjectEntity p2=new ProjectEntity();
		p2.setProjectName("Chat Boat");

		List<EmployeeEntity> empList=Arrays.asList(emp1,emp2);
		List<EmployeeEntity> empList2=Arrays.asList(emp1,emp2,emp3);

		List<ProjectEntity> projectList=Arrays.asList(p1,p2);

		emp1.setProject(projectList);  // 1 employee has 2 project
		emp2.setProject(projectList);
		emp3.setProject(projectList);

		p2.setEmployee(empList2);      // 1 Project has Assign to two employee

		projectRepository.save(p1);
		projectRepository.save(p2);

		employeeRepository.save(emp1);
		employeeRepository.save(emp2);
		employeeRepository.save(emp3);

        /*************** Fetch ******************************/

		Optional<EmployeeEntity> optionalEmployeeEntity=employeeRepository.findById(3L);
		EmployeeEntity employee=optionalEmployeeEntity.get();
		System.out.println(employee.getEmpName());
		for(ProjectEntity projectEntity: employee.getProject()){
			System.out.println(projectEntity.getPId()+" - "+projectEntity.getProjectName());
		}

		Optional<ProjectEntity> optionalProjectEntity=projectRepository.findById(2L);
		ProjectEntity project=optionalProjectEntity.get();

		System.out.println(project.getProjectName()+" "+project.getEmployee().size());
		for(EmployeeEntity employeeEntity2: project.getEmployee()){
			System.out.println(employeeEntity2.getEmpId()+" - "+employeeEntity2.getEmpName());
		}



	}
}
