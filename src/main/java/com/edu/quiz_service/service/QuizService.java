package com.edu.quiz_service.service;


import com.edu.quiz_service.dao.QuizDao;
import com.edu.quiz_service.model.QuestionWrapper;
import com.edu.quiz_service.model.Quiz;
import com.edu.quiz_service.model.Response;
import lombok.RequiredArgsConstructor;
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

    public Integer createQuiz(String category, String numQ, String title) {

//        List<Question> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
//
//        Quiz quiz = new Quiz();
//        quiz.setTitle(title);
//        quiz.setQuestions(questions);
//        return quizDao.save(quiz).getId();

        //List<Integer> questions = call the generate url
        return 0;
    }

    @Transactional
    public List<QuestionWrapper> getQuizQuestions(Integer id) {
//        return quizDao.findById(id)
//                .map(Quiz::getQuestions)  // Get the list of questions from the quiz
//                .orElse(Collections.emptyList())  // If the quiz is not found, return an empty list
//                .stream()  // Stream the list of questions
//                .map(q -> new QuestionWrapper(q.getId(), q.getQuestionTitle(),
//                        q.getOption1(), q.getOption2(),
//                        q.getOption3(), q.getOption4()))  // Convert each Question to a QuestionWrapper
//                .collect(Collectors.toList());  // Collect to a List
        return null;
    }

    @Transactional
    public Integer calculateResult(Integer id, List<Response> responses) {
//        // Retrieve the questions and map them by their IDs for fast lookup
//        Map<Integer, Question> questionMap = quizDao.findById(id)
//                .map(quiz -> quiz.getQuestions().stream()
//                        .collect(Collectors.toMap(Question::getId, q -> q)))
//                .orElse(Collections.emptyMap());
//
//        // Calculate score by checking each response
//        long score = responses.stream()
//                .filter(response -> {
//                    Question question = questionMap.get(response.getId());
//                    return question != null && response.getResponse().equals(question.getRightAnswer());
//                })
//                .count();
//
//        return (int) score;
        return null;
    }
}
