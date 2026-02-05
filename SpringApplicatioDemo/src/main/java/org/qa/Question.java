package org.qa;

import java.util.List;

public class Question {
    private int id;
    private String question;
    private List<String> answers;

    public Question(int id, String question, List<String> answers) {
        this.id = id;
        this.question = question;
        this.answers = answers;
    }

    public void display() {
        System.out.println(id + " " + question);
        System.out.println("answers are: ");
        for (String answer : answers) {
            System.out.println(answer);
        }
    }
}
