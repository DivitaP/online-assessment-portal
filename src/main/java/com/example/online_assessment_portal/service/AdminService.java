package com.example.online_assessment_portal.service;

import com.example.online_assessment_portal.model.Student;
import com.example.online_assessment_portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    UserRepository userRepository;

    public List<Student> getAllStudents() {
        return userRepository.findAll();
    }
}
