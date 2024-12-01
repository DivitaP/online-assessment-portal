package com.example.online_assessment_portal.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Document(collection = "question")
public class Question {
    private String question;
    private List<String> options;
    private String answer;

    public Question(String question, List<String> options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(options, question1.options) && Objects.equals(answer, question1.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, options, answer);
    }
}
