package com.group.syllabus.dto;

import java.util.UUID;

public class AssessmentSchemeDTO {
    private UUID id;
    private int quiz;
    private int assignment;
    private int finalPoint;
    private int finalTheory;
    private int finalPractice;
    private int gpa;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    public int getAssignment() {
        return assignment;
    }

    public void setAssignment(int assignment) {
        this.assignment = assignment;
    }

    public int getFinalPoint() {
        return finalPoint;
    }

    public void setFinalPoint(int finalPoint) {
        this.finalPoint = finalPoint;
    }

    public int getFinalTheory() {
        return finalTheory;
    }

    public void setFinalTheory(int finalTheory) {
        this.finalTheory = finalTheory;
    }

    public int getFinalPractice() {
        return finalPractice;
    }

    public void setFinalPractice(int finalPractice) {
        this.finalPractice = finalPractice;
    }

    public int getGpa() {
        return gpa;
    }

    public void setGpa(int gpa) {
        this.gpa = gpa;
    }
}
