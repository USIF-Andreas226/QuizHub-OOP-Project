
package com.example.onlineexamwithgui.Exams;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ResultRow {

    private StringProperty examTitle;
    private StringProperty examCategory;
    private IntegerProperty examScore;
    private StringProperty examGrade;

    public ResultRow(String examTitle, String examCategory, int examScore, String examGrade) {
        this.examTitle = new SimpleStringProperty();
        this.examCategory =  new SimpleStringProperty();
        this.examScore =  new SimpleIntegerProperty();
        this.examGrade =  new SimpleStringProperty();

        setExamTitle(examTitle);
        setExamCategory(examCategory);
        setExamScore(examScore);
        setExamGrade(examGrade);
    }

    public String getExamTitle() {
        return examTitle.get();
    }

    public StringProperty examTitleProperty() {
        return examTitle;
    }

    public void setExamTitle(String examTitle) {
        this.examTitle.set(examTitle);
    }

    public String getExamCategory() {
        return examCategory.get();
    }

    public StringProperty examCategoryProperty() {
        return examCategory;
    }

    public void setExamCategory(String examCategory) {
        this.examCategory.set(examCategory);
    }

    public int getExamScore() {
        return examScore.get();
    }

    public IntegerProperty examScoreProperty() {
        return examScore;
    }

    public void setExamScore(int examScore) {
        this.examScore.set(examScore);
    }

    public String getExamGrade() {
        return examGrade.get();
    }

    public StringProperty examGradeProperty() {
        return examGrade;
    }

    public void setExamGrade(String examGrade) {
        this.examGrade.set(examGrade);
    }
}
