package com.questionservice.controller;

import com.questionservice.entity.Question;
import com.questionservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    final private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public Question addQuestion(@RequestBody Question question) {
        return questionService.add(question);
    }


    @GetMapping
    public List<Question> getALl() {
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public Question get(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }

    @GetMapping("/quiz/{quizId}")
    public List<Question> getQuestionOfQuiz(@PathVariable Long quizId) {
        return questionService.getQuestionOfQuiz(quizId);
    }
}
