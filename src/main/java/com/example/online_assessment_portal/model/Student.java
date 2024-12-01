package com.example.online_assessment_portal.model;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "students")
public class Student extends User {

    @Id
    private String _id;

    @Nullable
    private List<Quiz> attemptedQuiz;

    public Student(String id, String address, String name, String mobile) {
        super(address, name, mobile);
        this._id = id;
    }

    public Student() {
        super();

    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Nullable
    public List<Quiz> getAttemptedQuiz() {
        return attemptedQuiz;
    }

    public void setAttemptedQuiz(@Nullable List<Quiz> attemptedQuiz) {
        this.attemptedQuiz = attemptedQuiz;
    }
}
