package com.example.online_assessment_portal.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.Random;

@Service
public class EmailService {

    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    public EmailService(JavaMailSender mailSender, SpringTemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }


    public String sendEmail(String to_email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("quiz@gmail.com");
            message.setTo(to_email);
            message.setSubject("Simple test email from java");
            message.setText("Just a simple test for checking mail service");

            mailSender.send(message);
            return "Sent email successfully!";
        } catch (Exception e) {
            return e.getMessage();
        }

    }
//        String otp = String.valueOf((int) (Math.random() * 900000) + 100000);

    public String sendEmailWithHtml(String to_email, String otp) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            Context context = new Context();
            context.setVariable("otp", otp);
            String htmlContent = templateEngine.process("email-content", context);

            helper.setFrom("quiz@gmail.com");
            helper.setTo(to_email);
            helper.setSubject("[OTP]: Online Assessment Portal");
            helper.setText(htmlContent, true);

            mailSender.send(message);
            return "Sent email successfully!";

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
