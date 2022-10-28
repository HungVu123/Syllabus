package com.group.syllabus.DTO;

public class AssesmentSchemeDTO {

    private int quiz;
    private int assignment;
    private int total;
    private int finalTheory;
    private int finalPractice;
    private int gpa;

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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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
