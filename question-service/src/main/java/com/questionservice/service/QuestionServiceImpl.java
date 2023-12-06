package com.questionservice.service;

import com.questionservice.entity.Question;
import com.questionservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
   final private QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }


    @Override
    public Question add(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(()->new RuntimeException("Question Not Found"));
    }

    @Override
    public List<Question> getQuestionOfQuiz(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }
}
