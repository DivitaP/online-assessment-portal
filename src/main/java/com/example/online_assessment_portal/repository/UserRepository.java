package com.example.online_assessment_portal.repository;

import com.example.online_assessment_portal.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<Student, String> {

    Optional<Student> findByEmail(String email);
}
