package com.codingdojo.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Question;
import com.codingdojo.mvc.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	QuestionRepository questionRepository;
	
	// //// FIND ALL QUESTIONS /////////////////
	public List<Question> findQuestions() {
		System.out.println("service - find - all - questions: "+questionRepository.findAll());
		System.out.println("-------------- FIND ALL QUESTIONS FROM DB ---------------");
		return questionRepository.findAll();
	}
	// //// NEW QUESTION ///////////////////////
	public Question newQuestion(Question question) {
		System.out.println("-------------- CREATE NEW BOOK DB ---------------");
		return questionRepository.save(question);
	}
	// //// FIND QUESTION BY ID //////////////////////
	public Question findQuestionById(Long id) {
		System.out.println("************** GET QUESTION BY ID ***************");
		Optional<Question> optional = questionRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}else {
			return null;			
		}
	}
}
