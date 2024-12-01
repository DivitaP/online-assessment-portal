package com.example.online_assessment_portal.model;

public class User {
    private String name;
    private String email;
    private String mobile;

    public User(String email, String name, String mobile) {
        this.email = email;
        this.name = name;
        this.mobile = mobile;
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
