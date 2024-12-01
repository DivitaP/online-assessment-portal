package com.example.online_assessment_portal.service;

import com.example.online_assessment_portal.model.OTP;
import com.example.online_assessment_portal.model.Student;
import com.example.online_assessment_portal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.example.online_assessment_portal.model.OTP.MAX_RETRIES;

@Service
public class StudentService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    OTPService otpService;

    public void createOrUpdateStudent(Student student) {
        userRepository.save(student);
    }


    public void deleteStudent(String id) {
        userRepository.deleteById(id);
    }

    public Optional<Student> getStudentByStudentID(String id) {
        return userRepository.findById(id);
    }

    public Boolean loginStudentUsingEmailAndOTP(String email, String otp) {
        Optional<OTP> actual_otp = otpService.findByEmail(email);
        if (actual_otp.isPresent()) {
            OTP current_otp = actual_otp.get();

            Boolean result = current_otp.getInterval().isAfter(LocalDateTime.now()) &&
                    otp.equals(current_otp.getOTP()) &&
                    current_otp.getMaxRetries() <= MAX_RETRIES;

            current_otp.setMaxRetries(current_otp.getMaxRetries() + 1);
            otpService.save(current_otp);

            if(current_otp.getMaxRetries() > MAX_RETRIES || result) {
                otpService.delete(current_otp);
            }

            return result;

        } else {

            return false;
        }
    }
}
