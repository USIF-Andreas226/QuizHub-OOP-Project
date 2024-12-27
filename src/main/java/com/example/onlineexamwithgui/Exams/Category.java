package com.example.onlineexamwithgui.Exams;

public class Category {

    private String category;

    public Category(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
