package com.example.online_assessment_portal.repository;

import com.example.online_assessment_portal.model.OTP;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface OTPRepository extends MongoRepository<OTP, String> {
    Optional<OTP> findByEmail(String email);
}
