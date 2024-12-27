package com.example.onlineexamwithgui.Exams;

import java.util.Date;

public class Result {
    private int examId;
    private int studentId;
    private float score;
    private String grade;
    private boolean passed;
    private Date date;

    public Result(int examId, int studentId, float score, String grade, boolean passed) {
        this.examId = examId;
        this.studentId = studentId;
        this.score = score;
        this.grade = grade;
        this.passed = passed;
    }


    @Override
    public String toString() {
        return examId + "," + studentId + "," + score + ',' + grade + ','+ passed;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean isPassed() {
        return passed;
    }

    public void setPassed(boolean passed) {
        this.passed = passed;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
