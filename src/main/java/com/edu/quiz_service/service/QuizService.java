package com.edu.quiz_service.service;


import com.edu.quiz_service.dao.QuizDao;
import com.edu.quiz_service.feign.QuizInterface;
import com.edu.quiz_service.model.QuestionWrapper;
import com.edu.quiz_service.model.Quiz;
import com.edu.quiz_service.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor()
public class QuizService {
    private final QuizDao quizDao;
    private final QuizInterface quizInterface;

    public Integer createQuiz(String category, Integer numQ, String title) {

        List<Integer> questionsIds = quizInterface.generateQuestionsForQuiz(category, numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsIds(questionsIds);
        return  quizDao.save(quiz).getId();
    }

    @Transactional
    public List<QuestionWrapper> getQuizQuestions(Integer id) {
        Quiz quiz = quizDao.findById(id).get();
        return quizInterface.getQuestionsFromIds(quiz.getQuestionsIds()).getBody();
    }

    @Transactional
    public Integer calculateResult(Integer id, List<Response> responses) {
        return quizInterface.getScore(responses).getBody();
    }
}
