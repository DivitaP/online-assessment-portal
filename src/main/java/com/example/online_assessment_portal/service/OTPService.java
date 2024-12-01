package com.example.online_assessment_portal.service;

import com.example.online_assessment_portal.model.OTP;
import com.example.online_assessment_portal.repository.OTPRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class OTPService {

    public static final int OTP_VALIDITY_MINUTES = 10;
    @Autowired
    OTPRepository otpRepository;

    @Autowired
    EmailService emailService;

    public void generateOTP(String email) {
        String otp = String.valueOf((int) (Math.random() * 900000) + 100000);
        LocalDateTime timeLeft = LocalDateTime.now().plusMinutes(OTP_VALIDITY_MINUTES);
        OTP otp_data = new OTP(otp, timeLeft, email);

        otpRepository.save(otp_data);

        emailService.sendEmailWithHtml(email, otp_data.getOTP());
    }

    public Optional<OTP> findByEmail(String email) {
        return otpRepository.findByEmail(email);

    }

    public void save(OTP currentOtp) {
        otpRepository.save(currentOtp);
    }

    public void delete(OTP currentOtp) {
        otpRepository.delete(currentOtp);
    }
}
