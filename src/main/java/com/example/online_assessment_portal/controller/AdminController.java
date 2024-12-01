package com.example.online_assessment_portal.controller;

import com.example.online_assessment_portal.model.Student;
import com.example.online_assessment_portal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/students")
    private List<Student> getStudentData() {
        return adminService.getAllStudents();
    }
}
