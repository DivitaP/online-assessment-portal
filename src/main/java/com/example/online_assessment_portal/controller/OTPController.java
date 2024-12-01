package com.example.online_assessment_portal.controller;

import com.example.online_assessment_portal.service.OTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/otp")
public class OTPController {

    @Autowired
    OTPService otpService;

    @PostMapping("/generate-otp")
    public String generateOTP(@RequestParam String email) {
        otpService.generateOTP(email);
        return "OTP generated successfully!";
    }
}
