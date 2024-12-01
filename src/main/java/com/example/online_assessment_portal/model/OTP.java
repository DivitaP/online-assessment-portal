package com.example.online_assessment_portal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "OTP")
public class OTP {
    public static final Integer MAX_RETRIES = 5;

    @Id
    private String id;
    private String OTP;
    private String email;
    private Integer maxRetries;
    private LocalDateTime interval;

    public OTP(String OTP, LocalDateTime interval, String email) {
        this.OTP = OTP;
        this.interval = interval;
        this.email = email;
        this.maxRetries = 0;
    }

    public String getOTP() {
        return OTP;
    }

    public void setOTP(String OTP) {
        this.OTP = OTP;
    }

    public LocalDateTime getInterval() {
        return interval;
    }

    public void setInterval(LocalDateTime interval) {
        this.interval = interval;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(Integer maxRetries) {
        this.maxRetries = maxRetries;
    }
}
