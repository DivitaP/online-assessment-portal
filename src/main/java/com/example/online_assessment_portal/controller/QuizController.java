package com.example.online_assessment_portal.controller;

import com.example.online_assessment_portal.model.Question;
import com.example.online_assessment_portal.model.Quiz;
import com.example.online_assessment_portal.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/create-quiz")
    public String createQuiz(@RequestBody List<Question> questions) {
        quizService.createNewQuiz(questions);
        return "New quiz created successfully";
    }

    @PostMapping("/add-question/{id}")
    public String addQuestionToQuiz(@PathVariable String id, @RequestBody Question question) {
        quizService.addQuestionToQuiz(id, question);
        return "Question added successfully";
    }

    @PostMapping("/remove-question/{id}")
    public String removeQuestionFromQuiz(@PathVariable String id, @RequestBody Question question) {
        quizService.removeQuestionToQuiz(id, question);
        return "Question removed successfully";
    }

    @GetMapping("/quizzes")
    public List<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @GetMapping("/quiz/{id}")
    public Quiz getQuizById(@PathVariable String id) {
        return quizService.getQuizByQuizId(id);
    }

    @PostMapping("/submit-quiz/{student_id}")
    public String submitQuizByStudent(@RequestBody Quiz quiz, @PathVariable String student_id) {
        quizService.submitQuizByStudent(quiz, student_id);
        return "Quiz data updated successfully";
    }


}
