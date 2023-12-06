package com.questionservice.service;

import com.questionservice.entity.Question;
import java.util.List;

public interface QuestionService {

    Question add(Question question);
    List<Question> getAll();
    Question getQuestionById(Long id);
    List<Question> getQuestionOfQuiz(Long quizId);
}
