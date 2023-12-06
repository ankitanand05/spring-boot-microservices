package com.quizservice.controller;

import com.quizservice.entity.Quiz;
import com.quizservice.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    final private QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping()
    public Quiz create(@RequestBody Quiz quiz){
        return quizService.addQuiz(quiz);
    }

    @GetMapping()
    public List<Quiz> getAll(){
        return quizService.getAllQuiz();
    }

    @GetMapping("/{id}")
    public Quiz getQuizById(@PathVariable Long id){
        return quizService.getSingleQuiz(id);
    }








}
