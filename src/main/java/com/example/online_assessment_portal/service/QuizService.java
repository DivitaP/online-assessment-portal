package com.example.online_assessment_portal.service;

import com.example.online_assessment_portal.model.Question;
import com.example.online_assessment_portal.model.Quiz;
import com.example.online_assessment_portal.model.Student;
import com.example.online_assessment_portal.repository.QuizRepository;
import com.example.online_assessment_portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    UserRepository userRepository;

    public void createNewQuiz(List<Question> questions) {
        Quiz quiz = new Quiz(questions);
        quizRepository.save(quiz);
    }

    public void addQuestionToQuiz(String id, Question question) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if(quiz.isPresent()) {
            Quiz current_quiz = quiz.get();
            current_quiz.addQuestion(question);
            quizRepository.save(current_quiz);
        } else {
            throw new RuntimeException("Quiz not found!");
        }
    }

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Quiz getQuizByQuizId(String id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if(quiz.isPresent())
            return quiz.get();
        else
            throw new RuntimeException("Quiz not found");
    }

    public void removeQuestionToQuiz(String id, Question question) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        if(quiz.isPresent()) {
            Quiz current_quiz = quiz.get();
            current_quiz.removeQuestion(question);
            quizRepository.save(current_quiz);
        } else {
            throw new RuntimeException("Quiz not found!");
        }
    }

    public void submitQuizByStudent(Quiz quiz, String studentId) {
        Optional<Student> student = userRepository.findById(studentId);
        if(student.isPresent()) {
            Student current_student = student.get();
            if (current_student.getAttemptedQuiz() == null || current_student.getAttemptedQuiz().isEmpty()) {
                List<Quiz> first_quiz = new ArrayList<>();
                first_quiz.add(quiz);
                current_student.setAttemptedQuiz(first_quiz);
            } else {
                List<Quiz> quizAttempts = current_student.getAttemptedQuiz();
                quizAttempts.add(quiz);
                current_student.setAttemptedQuiz(quizAttempts);
            }
            userRepository.save(current_student);
        } else {
            throw new RuntimeException("Student not found!");
        }

    }
}
