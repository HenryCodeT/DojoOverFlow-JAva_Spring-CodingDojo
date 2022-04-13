package com.codingdojo.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.mvc.models.Answer;
import com.codingdojo.mvc.models.Question;
import com.codingdojo.mvc.models.Tag;
import com.codingdojo.mvc.services.AnswerService;
import com.codingdojo.mvc.services.QuestionService;
import com.codingdojo.mvc.services.TagService;

@Controller
public class QuestionController {
	
	@Autowired
	QuestionService questionService;

	@Autowired
	TagService tagService;
	
	@Autowired
	AnswerService answerService;
	// //// INIT ////////////////////
	@GetMapping("/")
	public String init() {
		return "redirect:/questions";
	}

	// //// QUESTIONS VIEW //////////
	@GetMapping("/questions")
	public String findAllQuestionString(Model model) {
		List<Question> questions = questionService.findQuestions();
		model.addAttribute("questions", questions);
		return "showquestions";
	}
	
	// //// NEW QUESTION /////////////////
	// ///////////////////////////////////

	// //// QUESTION NEW VIEW ////////////
	@GetMapping("/questions/new")
	public String newQuestionView() {
		System.out.println("********* Question NEW VIEW *********");
		return "newquestion";
	}
	// //// QUESTION POST ///////////////
	@PostMapping("/questions/create")
	public String createQuestions(@RequestParam("question") String question, @RequestParam("subject") String subject) {
		Question newQuestion = new Question();
		String[] tagsStrings = subject.split("\\s*,\\s*");
		
		List<Tag> tags = new ArrayList<Tag>();
		
		for (String tag : tagsStrings) {
			Tag tagObj = new Tag();
			tagObj.setSubject(tag);
			tagService.createTag(tagObj);
			System.out.println(tagObj.getId());
			Long idLong = tagObj.getId();
			Tag createdTag = tagService.findTagById(idLong);
			tags.add(createdTag);
		}
		
		newQuestion.setQuestion(question);
		newQuestion.setTags(tags);
		System.out.println("get-question: "+newQuestion.getQuestion());
		System.out.println("get-all-tags: "+newQuestion.getTags());
		
		questionService.newQuestion(newQuestion);
		System.out.println("result: "+newQuestion.getId());
		
		return "redirect:/questions/new";
	}
	
	// ///// SHOW QUESTION BY ID ////////////////
	
	@GetMapping("/questions/{id}")
	public String questionsId(Model model, @PathVariable("id") Long question_id) {
		Question question = questionService.findQuestionById(question_id);
		model.addAttribute("question", question);
		List<Answer> answers = question.getAnswers();
		model.addAttribute("answers", answers);
		return "showquestion";
	}
	
	// //// CREATE NEW ANSWER ////////////////////////////
	@PostMapping("/questions/{id}/answer")
	public String createAnswer(@RequestParam("answer") String answer, @PathVariable("id") Long question_id) {
			Answer newAnswer = new Answer();
			newAnswer.setAnswer(answer);
			Question question = questionService.findQuestionById(question_id);
			newAnswer.setQuestion(question);
			answerService.createAnswer(newAnswer);
			return "redirect:/questions/"+question_id;
		}
}
