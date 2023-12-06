package com.quizservice.service;



import com.quizservice.entity.Quiz;

import java.util.List;

public interface QuizService {

    Quiz addQuiz(Quiz quiz);
    List<Quiz> getAllQuiz();
    Quiz getSingleQuiz(Long id);

}
