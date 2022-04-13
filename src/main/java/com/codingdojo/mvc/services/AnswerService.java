package com.codingdojo.mvc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.mvc.models.Answer;
import com.codingdojo.mvc.repositories.AnswerRepository;

@Service
public class AnswerService {
	
	@Autowired
	AnswerRepository answerRepository;
	
	// //// CREATE ANSWER ///////////////7
	public Answer createAnswer(Answer answer) {
		System.out.println("************ CREATE NEW ANSWER ***********");
		return answerRepository.save(answer);
	}
}
