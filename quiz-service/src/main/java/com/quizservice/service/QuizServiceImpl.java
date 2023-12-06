package com.quizservice.service;

import com.quizservice.client.QuestionClient;
import com.quizservice.entity.Quiz;
import com.quizservice.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService{

    final private QuizRepository quizRepository;

    final private QuestionClient questionClient;


    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }


    @Override
    public Quiz addQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getAllQuiz() {
        List<Quiz> quizzes = quizRepository.findAll();
        List<Quiz> newQuizList = quizzes.stream().map(
                quiz -> {
                    quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
                    return quiz;
                }).collect(Collectors.toList());
        return newQuizList;
    }

    @Override
    public Quiz getSingleQuiz(Long id) {
        Quiz quiz = quizRepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
        quiz.setQuestions(questionClient.getQuestionOfQuiz(quiz.getId()));
        return quiz;
    }
}
