package com.example.online_assessment_portal.model;

import com.mongodb.lang.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "quiz")
public class Quiz {
    @Id
    private String _id;

    private List<Question> questions;

    @Nullable
    private Integer score;

    @Nullable
    private Boolean isAttempted;

    public Quiz(List<Question> questions) {
        this.questions = questions;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question) {
        this.questions.add(question);
    }

    public void removeQuestion(Question question) {
        this.questions.remove(question);
    }

    @Nullable
    public Integer getScore() {
        return score;
    }

    public void setScore(@Nullable Integer score) {
        this.score = score;
    }

    @Nullable
    public Boolean getAttempted() {
        return isAttempted;
    }

    public void setAttempted(@Nullable Boolean attempted) {
        isAttempted = attempted;
    }
}
