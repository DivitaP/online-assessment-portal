package com.example.online_assessment_portal.controller;

import com.example.online_assessment_portal.model.Student;
import com.example.online_assessment_portal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    private String createStudent(@RequestBody Student student) {
        studentService.createOrUpdateStudent(student);
        return "Student data created with id: " + student.get_id();
    }

    @PutMapping("/update/{_id}")
    private Student updateStudentData(@RequestBody Student student, @PathVariable String _id) {
        student.set_id(_id);
        studentService.createOrUpdateStudent(student);
        return student;
    }

    @DeleteMapping("/delete/{_id}")
    private String deleteStudentData(@PathVariable String _id) {
        studentService.deleteStudent(_id);
        return "Student data deleted with id: " + _id;
    }

    @GetMapping("/{_id}")
    private Student getStudentByStudentID(@PathVariable String _id) {
        Optional<Student> student = studentService.getStudentByStudentID(_id);

        if(student.isPresent()) {
            return student.get();
        }

        throw new RuntimeException("No student found for id: "+ _id);
    }

    @PostMapping("/login/{email}/{otp}")
    private Boolean loginStudentUsingOTP(@PathVariable String email, @PathVariable String otp) {
        return studentService.loginStudentUsingEmailAndOTP(email, otp);
    }
}