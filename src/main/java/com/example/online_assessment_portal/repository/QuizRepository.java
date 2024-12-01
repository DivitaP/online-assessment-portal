package com.example.online_assessment_portal.repository;

import com.example.online_assessment_portal.model.Question;
import com.example.online_assessment_portal.model.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuizRepository extends MongoRepository<Quiz, String> {

}
