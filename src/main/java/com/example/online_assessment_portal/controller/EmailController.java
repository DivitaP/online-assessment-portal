package com.example.online_assessment_portal.controller;

import com.example.online_assessment_portal.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public String sendEmail(@RequestParam String email) {
       return emailService.sendEmail(email);
    }

    @PostMapping("/send-email-with-html")
    public String sendEmailWithHtml(@RequestParam String email, @RequestParam String otp) {
        return emailService.sendEmailWithHtml(email, otp);
    }


}
